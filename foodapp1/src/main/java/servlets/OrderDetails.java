package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAOimpl.MenuDAOimpl;
import com.tap.DAOimpl.OrderItemDAOimpl;
import com.tap.models.Menu;
import com.tap.models.OrderItem;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderdetails")
public class OrderDetails extends HttpServlet {
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("html/text");		
		int orderid=(Integer.parseInt(req.getParameter("orderId")));
		System.out.println("Order Details "+orderid);
		
		OrderItemDAOimpl odi=new OrderItemDAOimpl();
		
		List<OrderItem> list1=odi.getOrderItem(orderid);
		System.out.println("Order details");
		
		List<Menu> list2=new ArrayList<>();
		for(OrderItem oi:list1)
		{
			System.out.println(oi);
			
			int quantity=oi.getQuantity();
			
			MenuDAOimpl mdo=new MenuDAOimpl();
			Menu m=mdo.getMenu(oi.getMenuid());
			
			System.out.println(m);
			
			int resturantid=m.getResturantid();
			String itemname=m.getItemname();
			String description=m.getDescription();
			int price=m.getPrice();
			String isavailable=m.getIsavailable();
			String rating=m.getRating();
			String imagepath=m.getImagepath();
			
			m=new Menu(oi.getMenuid(),resturantid,itemname,description,price,isavailable,rating,imagepath,quantity);
			list2.add(m);
		}
		
		req.setAttribute("allMenus", list2);
		
		RequestDispatcher rd=req.getRequestDispatcher("orderdetails.jsp");
		rd.forward(req, resp);
	}

}
