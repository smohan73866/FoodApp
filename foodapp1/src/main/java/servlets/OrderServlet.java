package servlets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOimpl.OrderDAOimpl;
import com.tap.models.Order;
import com.tap.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/orderservlet")
public class OrderServlet extends HttpServlet {
	
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("html/text");
		
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("user");
		int userId=u.getUserid();
		
		System.out.println("Hi from Order Servlet");
		
		OrderDAOimpl odo=new OrderDAOimpl();
		List<Order> list=odo.getOrder(userId);
		
		for(Order o:list)
		{
			System.out.println(o);
		}
		
		req.setAttribute("orders", list);
		RequestDispatcher rd=req.getRequestDispatcher("ordershistory.jsp");
		rd.forward(req, resp);
	}

}
