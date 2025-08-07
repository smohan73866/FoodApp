package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tap.DAOimpl.ResturantDAOimpl;
import com.tap.models.Resturant;
import com.tap.models.User;
import com.tap.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	static int num=1;
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		PrintWriter out =resp.getWriter();
		System.out.println("Welcome to Home Servlet");
		ResturantDAOimpl rda=new ResturantDAOimpl();
		List<Resturant> list=rda.getAllResturants();
		
		for(Resturant r:list)
		{
			System.out.println(r);
		}
		
		req.setAttribute("allresturants", list);
		
		String name=req.getParameter("name");
		String login=req.getParameter("login");
		req.setAttribute("name", name);
		req.setAttribute("check", "match");
		req.setAttribute("num", num);
		req.setAttribute("login", login);
		num++;
		login="hi";
		
		User u=(User)req.getAttribute("user");
		req.setAttribute("user", u);
		
		
		
		
		
		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		rd.forward(req, resp);
	}

}
