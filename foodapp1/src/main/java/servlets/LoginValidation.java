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

@WebServlet("/callingLoginValidation")
public class LoginValidation  extends HttpServlet {
		
		int count=3;
		
		protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
		{
			resp.setContentType("text/html");
			
			
			String name=req.getParameter("name");
			String password=req.getParameter("password");
			String  login=req.getParameter("login");
			
			String ogPass=(String)req.getAttribute("ogPass");
			System.out.println(ogPass);
			
			PrintWriter out=resp.getWriter();
			
			
			req.setAttribute("name", name);
			req.setAttribute("login", login);
			
			
			
			
			if(password.equals(ogPass))
			{	
				UserDAOimpl udo=new UserDAOimpl();
				User u=udo.getData(name);
				
				req.setAttribute("user", u);
				

				RequestDispatcher rd=req.getRequestDispatcher("home");
				rd.include(req, resp);
				
				
			}
			else if(count>0)
			{
				out.println("You entered wrong password");
				out.println("You have "+count+" attempts left");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, resp);
				count--;
				
			}
			else {
				count=3;
				out.println("sorry, please contact admin");
			}
			
		}}