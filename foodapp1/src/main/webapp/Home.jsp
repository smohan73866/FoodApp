<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List ,com.tap.models.Resturant,com.tap.models.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Restaurant Listings</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }
    
    .top-right-navbar a {
      text-decoration: none;
      color: white;
      margin-left: 20px;
      font-size: 16px;
      display: flex;
      align-items: center;
      transition: color 0.3s ease;
    }

    

    .top-right-navbar a span.icon {
      margin-right: 6px;
      font-size: 18px;
    }

    .top-right-navbar a.profile {
      font-weight: bold;
    }
    .top-right-navbar {
      position: absolute;
      top: 0;
      right: 0;
      display: flex;
      background-color: #008b8f;
      padding: 12px 20px;
      border-bottom-left-radius: 10px;
    }

    body {
      font-family: Arial, sans-serif;
      background-color: #f8f8f8;
    }

    /* Navbar */
    

    .navbar .logo {
      font-size: 1.5rem;
      font-weight: bold;
      color: #e53935;
    }

    .navbar ul {
      list-style: none;
      display: flex;
      gap: 20px;
    }

    .navbar ul li a {
      text-decoration: none;
      color: #333;
      font-weight: 500;
    }

    .navbar ul li a:hover {
      color: #e53935;
    }

    h1 {
      margin: 30px 0;
      color: #333;
    }

    .container {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
      gap: 20px;
      padding: 0 30px 40px;
    }

    .card {
      background-color: #fff;
      border-radius: 8px;
      overflow: hidden;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
      transition: transform 0.2s;
    }

    .card:hover {
      transform: translateY(-5px);
    }

    .card img {
      width: 100%;
      height: 180px;
      object-fit: cover;
    }

    .card-content {
      padding: 15px;
    }

    .card h2 {
      font-size: 18px;
      margin-bottom: 8px;
      color: #222;
    }

    .card p {
      font-size: 14px;
      color: #555;
      margin-bottom: 10px;
    }

    .details {
      display: flex;
      justify-content: space-between;
      font-size: 14px;
      color: #777;
    }

    .details span:first-child {
      color: #ffa000;
    }
  </style>
</head>
<body>

  <!-- Navbar -->
  <h1>Popular Restaurants</h1>
  <div class="top-right-navbar">
    <a href="home"><span class="icon">🏠</span>Home</a>
    <a href="cart"><span class="icon">🛒</span>Cart</a>
    <a href="login.html"><span class="icon">🔐</span>Login</a>
    <a href="orderservlet"><span class="icon">📦</span>Orders</a>
  

      
      <% 
      
      User u;
      
      
      String name;
      String check;
      
      int num=(Integer)request.getAttribute("num");
      String login=(String)request.getAttribute("login");
      if("TRUE".equals(login))
      {
      u=(User)request.getAttribute("user");
      name=(String)request.getAttribute("name");
      check=(String)request.getAttribute("check");
      session.setAttribute("user",u);
      session.setAttribute("name",name);
      session.setAttribute("check",check);
      session.setAttribute("login",login);
      }
      
      else{
      
      u=(User)session.getAttribute("user");
      name=(String)session.getAttribute("name");
      check=(String)session.getAttribute("check");
      }
      
      %>
      <a href="profile?name=<%= name %>"><span class="icon">👤</span>
      <%
      
      
      if("match".equals(check))
      {
    	  %>
    	  
    	  <%= name%></a></li>
    	  
    	  <% 
      }
      
      else{
    	  %>
    	  Profile</a>
    	  <% 
      }
      %>
      
    </ul>
  </div>
  <br>

  
  
  

  <div class="container">
    
    <%  
    	List<Resturant> list=(List<Resturant>)request.getAttribute("allresturants");
    
    	
    	for(Resturant r:list)
    	{
    		
    		%>
    		
    	<a href="menu?resturantId=<%= r.getResturantid() %>" style="text-decoration: none;">
    		
    		<!-- Restaurant  -->
    	    <div class="card">
    	      <img src="<%= r.getImagepath() %>" alt="Restaurant">
    	      <div class="card-content">
    	        <h2><%= r.getName() %></h2>
    	        <p><%= r.getCuisinetype() %></p>
    	        <div class="details">
    	          <span>⭐ <%= r.getRating() %></span>
    	          <span>ETA: <%= r.getDeliverytime() %> min</span>
    	        </div>
    	      </div>
    	    </div>
    	    </a>
    	<%
    	}
    	 %>
    	 
    	 
    
    
   
    
    
    

    
    

</body>
</html>
