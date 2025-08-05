package servlets;

import java.io.IOException;

import com.tap.DAOimpl.MenuDAOimpl;
import com.tap.models.Cart;
import com.tap.models.CartItem;
import com.tap.models.Menu;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
			
		HttpSession session=req.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		
		
		String value=req.getParameter("resturantId");
		
		if(value!=null)
		{
		
		int newResturantId=Integer.parseInt(value);		
		
		Integer oldResturantId=(Integer)session.getAttribute("resturantId");
		System.out.println("from cart servlet");
		System.out.println(newResturantId);
		
		if(cart == null || oldResturantId != newResturantId)
		{
			cart = new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("resturantId", newResturantId);
			
		}
		String action=req.getParameter("action");
		
		if(action.equals("add"))
		{
			addItemToCart(req,cart);
		}
		else if(action.equals("update"))
		{
			updateCartItem(req,cart);
		}
		else if(action.equals("remove"))
		{
			removeItemFromCart(req,cart);
		}
		
		
		
	}
	
		resp.sendRedirect("cart.jsp");

	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {
		
		int itemId=Integer.parseInt(req.getParameter("menuId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		MenuDAOimpl mdo=new MenuDAOimpl();
		Menu menu=mdo.getMenu(itemId);
		
		System.out.println("The menu in cart servlet" +menu);
		
		if(menu != null)
		{	
			int menuId=menu.getMenuid();
			String name=menu.getItemname();
			int resturantId=menu.getResturantid();
			double price=menu.getPrice();
			
			
			CartItem ci=new CartItem(menuId,resturantId,name,quantity,price);
			cart.addItem(ci);
		}
		
		
		
	}
	
	

	private void updateCartItem(HttpServletRequest req, Cart cart) {
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
		
	}
	
	private void removeItemFromCart(HttpServletRequest req, Cart cart) {
		
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		cart.deleteItem(itemId);
	}

}

