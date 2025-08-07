package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.DAOimpl.UserDAOimpl;
import com.tap.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callingSignUpServlet")
public class SignUpServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		resp.setContentType("text/html");
		
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String phonenumber=req.getParameter("phonenumber");
		String email=req.getParameter("email");
		
		PrintWriter out=resp.getWriter();
		
		
		User u=new User(name,password,email,phonenumber);
		UserDAOimpl udi=new UserDAOimpl();
		
		if(udi.isNamePresent(u,name))
		{
			out.println("Name already registerd try with other name");
			RequestDispatcher rd=req.getRequestDispatcher("signup.html");
			rd.include(req, resp);
			
		}
		
		udi.addData(u);
		
		
		out.println("Account Created Successfully");
		
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, resp);
		
	}

}
