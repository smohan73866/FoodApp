package servlets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOimpl.MenuDAOimpl;
import com.tap.models.Menu;
import com.tap.models.Resturant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		MenuDAOimpl mdo=new MenuDAOimpl();
		String value=req.getParameter("resturantId");
		int resturantid;
		if(value != null)
		{
			resturantid=Integer.parseInt(value);
		}
		else {
			resturantid=-1;
		}
		
		
		
		System.out.println("Hi from menu Servlet");
		System.out.println(resturantid);
		
		List<Menu> list=mdo.getByResturantId(resturantid);
		
		for(Menu m:list)
		{
			System.out.println(m);
		}
		
		req.setAttribute("menuList", list);
		
		
		
		RequestDispatcher rd=req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
		
		
	}

}
