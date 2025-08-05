package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.DAOimpl.UserDataimpl;
import com.tap.models.Data;

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
		
		Data d=new Data(name);
		UserDataimpl udi=new UserDataimpl();
		
		String ogName=udi.findName(d);
		
		if(name.equals(ogName))
		{
		String ogPass=udi.findData(d);
		
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
