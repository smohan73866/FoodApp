<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List ,com.tap.models.Resturant,com.tap.models.Data" %>
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

    body {
      font-family: Arial, sans-serif;
      background-color: #f8f8f8;
    }

    /* Navbar */
    .navbar {
      background-color: #fff;
      padding: 15px 30px;
      display: flex;
      justify-content: space-between;
      align-items: center;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
      position: sticky;
      top: 0;
      z-index: 1000;
    }

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
      text-align: center;
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
  <nav class="navbar">
    <div class="logo">FoodExpress</div>
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="cart">Cart</a></li>
      <li><a href="login.html">Login</a></li>
      
      <% 
      String name;
      String check;
      int num=(Integer)request.getAttribute("num");
      String login=(String)request.getAttribute("login");
      if("TRUE".equals(login))
      {
      name=(String)request.getAttribute("name");
      check=(String)request.getAttribute("check");
      session.setAttribute("name",name);
      session.setAttribute("check",check);
      session.setAttribute("login",login);
      }
      
      else{
    	  
      name=(String)session.getAttribute("name");
      check=(String)session.getAttribute("check");
      }
      
      %>
      <li><a href="profile?name=<%= name %>">
      <%
      
      
      if("match".equals(check))
      {
    	  %>
    	  
    	  <%= name%></a></li>
    	  
    	  <% 
      }
      
      else{
    	  %>
    	  Profile</a></li>
    	  <% 
      }
      %>
      
    </ul>
  </nav>
  

  <h1>Popular Restaurants Near You</h1>
  
  

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
