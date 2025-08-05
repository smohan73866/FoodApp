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

@WebServlet("/callingSignUpServlet")
public class SignUpServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		resp.setContentType("text/html");
		
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String phonenumber=req.getParameter("phonenumber");
		String email=req.getParameter("email");
		String image=req.getParameter("image");
		
		PrintWriter out=resp.getWriter();
		
		
		Data d=new Data(name,password,phonenumber,email,image);
		UserDataimpl udi=new UserDataimpl();
		
		if(udi.isNamePresent(d,name))
		{
			out.println("Name already registerd try with other name");
			RequestDispatcher rd=req.getRequestDispatcher("signup.html");
			rd.include(req, resp);
			
		}
		
		udi.addData(d);
		
		
		out.println("Account Created Successfully");
		
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, resp);
		
	}

}
