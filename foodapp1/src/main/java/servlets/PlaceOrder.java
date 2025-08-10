package servlets;

import java.io.IOException;

import com.tap.DAOimpl.OrderDAOimpl;
import com.tap.DAOimpl.OrderItemDAOimpl;
import com.tap.models.Cart;
import com.tap.models.CartItem;
import com.tap.models.Order;
import com.tap.models.OrderItem;
import com.tap.models.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeorder")
public class PlaceOrder extends HttpServlet{
	
	private OrderDAOimpl orderDAO;
	private OrderItemDAOimpl orderItemDAO;
	
	public void init()
	{
		orderDAO=new OrderDAOimpl();
		orderItemDAO=new OrderItemDAOimpl();
	}
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		
	HttpSession session=req.getSession();
	Cart cart=(Cart)session.getAttribute("cart");
	User user=(User)session.getAttribute("user");
	
	System.out.println("User "+user);
	
	if(cart != null && user != null  && !cart.getItems().isEmpty())
	{
		// && user != null
		
		System.out.println("User present");
		
		String paymentMethod=req.getParameter("payment");
		String address=req.getParameter("address");
		
		//calculate Total Amount
		double totalAmount=0;
		for(CartItem item:cart.getItems().values())
		{
			totalAmount=(totalAmount+item.getPrice()*item.getQuantity());
		}
		
		int resturantId=(int) session.getAttribute("resturantId");
		int userId=user.getUserid();
		System.out.println("User id: "+userId );
		String status="deliverd";
		
		Order order=new Order(resturantId,userId,totalAmount,status,paymentMethod);
		
		
		
		int orderid = orderDAO.addOrder(order);
		
		for(CartItem ci:cart.getItems().values())
		{
			int menuid=ci.getItemId();
			double price=ci.getPrice();
			int quantity=ci.getQuantity();
			double totalPrice= (ci.getPrice()*quantity);
			
			OrderItem orderitem=new OrderItem(orderid,menuid,quantity,totalPrice);
			
			orderItemDAO.addOrderItem(orderitem);
			
		}
		System.out.println("Place Order Servlet");
		System.out.println(totalAmount);
		session.setAttribute("total", totalAmount);
		session.removeAttribute("cart");
		session.setAttribute("order", orderid);
		
		resp.sendRedirect("orderconfirm.jsp");
		
	}
	else {
		resp.sendRedirect("cart.jsp");
	}
	
	}

}
