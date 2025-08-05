package servlets;

import java.io.IOException;

import com.tap.DAOimpl.UserDataimpl;
import com.tap.models.Data;

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
		UserDataimpl udo=new UserDataimpl();
		String name=(String)req.getParameter("name");
		
		if(name.equals("null"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
			
		}
		
		else {
		Data d=udo.getData(name);
		
		String phone=d.getPhonenumber();
		String email=d.getEmail();
		String image=d.getImage();
		
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(image);
		
		req.setAttribute("name", name);
		req.setAttribute("phone", phone);
		req.setAttribute("email", email);
		req.setAttribute("image", image);
		
		RequestDispatcher rd=req.getRequestDispatcher("profile.jsp");
		rd.forward(req, resp);
		
		}
	}

}
