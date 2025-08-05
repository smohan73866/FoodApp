package servlets;

import com.tap.DAOimpl.OrderDAOimpl;
import com.tap.DAOimpl.OrderItemDAOimpl;
import com.tap.models.Cart;
import com.tap.models.CartItem;
import com.tap.models.Order;
import com.tap.models.OrderItem;
import com.tap.models.User;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PlaceOrder extends HttpServlet{
	
	private OrderDAOimpl orderDAO;
	private OrderItemDAOimpl orderItemDAO;
	
	public void init()
	{
		orderDAO=new OrderDAOimpl();
		orderItemDAO=new OrderItemDAOimpl();
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
	{
		
	HttpSession session=req.getSession();
	Cart cart=(Cart)session.getAttribute("cart");
	User user=(User)session.getAttribute("user");
	
	if(cart != null && user != null && !cart.getItems().isEmpty())
	{
		
		String paymentMethod=req.getParameter("payment");
		String address=req.getParameter("address");
		
		Order order=new Order();
		
		for(CartItem ci:cart.getItems().values())
		{
			int menuid=ci.getItemId();
			double price=ci.getPrice();
			int quantity=ci.getQuantity();
			int totalPrice=(int) (ci.getPrice()*quantity);
			
			OrderItem orderitem=new OrderItem(orderid,menuid,quantity,totalPrice);
			
			orderItemDAO.addOrderItem(orderitem);
		}
		
		session.removeAttribute("cart");
		session.setAttribute("order", order);
		
		resp.sendRedirect("orderConformation.jsp");
		
	}
	else {
		resp.sendRedirect("cart.jsp");
	}
	
	}

}
