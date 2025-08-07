package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.DAOimpl.UserDAOimpl;
import com.tap.DAOimpl.UserDataimpl;
import com.tap.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callingLoginServlet")
public class LoginServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		resp.setContentType("text/html");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		System.out.println("Hi "+name+" login servlet");
		String login=req.getParameter("login");
		
		System.out.println(login);
		
		PrintWriter out=resp.getWriter();
		
		User u=new User(name);
		UserDAOimpl udi=new UserDAOimpl();
		
		String ogName=udi.findName(u);
		
		if(name.equals(ogName))
		{
		String ogPass=udi.findData(u);
		
		req.setAttribute("ogPass", ogPass);
		req.setAttribute("login", login);
		
		RequestDispatcher rd= req.getRequestDispatcher("callingLoginValidation");
		rd.include(req, resp);
		}
		else {
			out.println("You dont have account");
			out.println("Please create account");
			
			RequestDispatcher rd=req.getRequestDispatcher("signup.html");
			rd.include(req, resp);
			
		}
		}

}
