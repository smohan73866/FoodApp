<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.tap.models.Menu,java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Restaurant Menu</title>
  <style>
    * {
      box-sizing: border-box;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
      margin: 0;
      padding: 0;
      background: #f9f9f9;
      color: #333;
    }

    header {
      background-color: #ff4c4c;
      color: white;
      padding: 20px 40px;
      text-align: center;
    }

    h1 {
      margin: 0;
      font-size: 2.5rem;
    }

    .menu-container {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 20px;
      padding: 40px;
      max-width: 1200px;
      margin: auto;
    }

    .menu-item {
      background: white;
      border-radius: 12px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
      overflow: hidden;
      transition: transform 0.2s ease;
    }

    .menu-item:hover {
      transform: translateY(-5px);
    }

    .menu-item img {
      width: 100%;
      height: 200px;
      object-fit: cover;
    }

    .item-info {
      padding: 20px;
    }

    .item-info h3 {
      margin: 0 0 10px;
      font-size: 1.5rem;
      color: #333;
    }

    .item-info p.description {
      font-size: 0.95rem;
      color: #555;
      margin: 10px 0;
      height: 50px;
      overflow: hidden;
    }

    .item-info .price-rating {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-top: 15px;
    }

    .price {
      font-size: 1.1rem;
      font-weight: bold;
      color: #ff4c4c;
    }

    .rating {
      background: #28a745;
      color: white;
      padding: 4px 10px;
      border-radius: 8px;
      font-size: 0.9rem;
    }
    
    .add-cart-btn:hover{
    background-color: #c82333;
    }
    
    .add-cart-btn {
      
      background-color: red;
      color: white;
      padding: 10px 50px;
      border: none;
      border-radius: 20px;
      font-size: 16px;
      cursor: pointer;
      text-transform: uppercase;
      transition: 0.3s;
    }
	.button-container{
	text-align: left;
      padding-left:50px;
      }

    @media (max-width: 600px) {
      .item-info p.description {
        height: auto;
      }
    }
    .top-bar {
  display: flex;
  justify-content: flex-end;
  padding: 10px 20px;
  background-color: #fff; /* Optional: background strip at top */
}

.home-box {
  background-color: #4CAF50; /* Green color */
  color: white;
  border: none;
  padding: 10px 20px;
  font-weight: bold;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 5px rgba(0,0,0,0.2);
  transition: 0.3s;
}

.home-box:hover {
  background-color: #388E3C; /* Darker green on hover */
}
  </style>
</head>
<body>

  <header>
    <h1>Menu List</h1>
    <div class="top-bar">
  <button class="home-box" onclick="location.href='home'">HOME</button>
</div>
  </header>

  <div class="menu-container">
  
  <%
  		List<Menu> menulist=(List<Menu>)request.getAttribute("menuList");
  
  		for(Menu m:menulist)
  		{
  		%>	
  			<div class="menu-item">
  	      <img src="<%= m.getImagepath() %>" alt="Chicken Biryani">
  	      <div class="item-info">
  	        <h3><%= m.getItemname() %></h3>
  	        <p class="description"><%= m.getDescription() %></p>
  	        <div class="price-rating">
  	          <div class="price">₹<%= m.getPrice() %></div>
  	          <div class="rating">⭐ <%= m.getRating() %></div>
  	        </div>
  	        
  	        <form action="cart">
  	        <input type="hidden" name="menuId" value="<%=m.getMenuid() %>">
  	        <input type="hidden" name="quantity" value="1">
  	        <input type="hidden" name="resturantId" value="<%=m.getResturantid() %>">
  	        <input type="hidden" name="action" value="add">
  	        <input type="submit" value="ADD TO CART">
  	        </form>
  	      </div>
  	      
  	    </div>
  	    
  	    

  		<% 	
  			
  		}
  
  
  %>
    
    
    
</body>
</html>
