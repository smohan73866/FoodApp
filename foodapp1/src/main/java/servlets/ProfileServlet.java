package servlets;

import java.io.IOException;

import com.tap.DAOimpl.UserDAOimpl;
import com.tap.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		System.out.println("profile servlet");
		UserDAOimpl udo=new UserDAOimpl();
		String name=(String)req.getParameter("name");
		
		if(name.equals("null"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
			
		}
		
		else {
		User u=udo.getData(name);
		
		String phone=u.getPhonenumber();
		String email=u.getEmail();
		
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
		
		req.setAttribute("name", name);
		req.setAttribute("phone", phone);
		req.setAttribute("email", email);
		
		RequestDispatcher rd=req.getRequestDispatcher("profile.jsp");
		rd.forward(req, resp);
		
		}
	}

}
