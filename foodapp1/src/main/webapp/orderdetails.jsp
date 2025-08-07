<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List,com.tap.models.Menu" %>
    
    <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Order Details</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #fafafa;
      padding: 20px;
    }

    h2 {
      margin-bottom: 25px;
    }

    .menu-item {
      display: flex;
      background: #fff;
      border-radius: 12px;
      box-shadow: 0 4px 8px rgba(0,0,0,0.1);
      margin-bottom: 20px;
      overflow: hidden;
    }

    .menu-item img {
      width: 180px;
      height: 150px;
      object-fit: cover;
    }

    .item-details {
      padding: 15px;
      flex: 1;
    }

    .item-details h3 {
      margin: 0 0 10px 0;
    }

    .item-details p {
      margin: 4px 0;
      color: #555;
    }

    .price {
      color: #e53935;
      font-weight: bold;
      font-size: 16px;
    }

    .quantity {
      font-size: 14px;
      color: #333;
    }

    .rating {
      background: #4caf50;
      color: #fff;
      padding: 3px 8px;
      border-radius: 5px;
      font-size: 14px;
      display: inline-block;
      margin-top: 10px;
    }
    
    .top-right {
  position: absolute;
  top: 10px;
  right: 20px;
}

.back-button {
  text-decoration: none;
  background-color: #4CAF50; /* green */
  color: white;
  padding: 8px 14px;
  border-radius: 6px;
  font-weight: bold;
  border: none;
  transition: background-color 0.3s;
}

.back-button:hover {
  background-color: #45a049; /* darker green on hover */
}
  </style>
</head>
<body>

  <h2>Order  Details</h2>
  
  <div class="top-right">
  <a href="orderservlet" class="back-button">BACK</a></div>

<%
	List<Menu> list=(List<Menu>)request.getAttribute("allMenus");

	for(Menu m:list)
	{
		%>
		
		<!-- Paneer Pizza -->
		  <div class="menu-item">
		    <img src="<%= m.getImagepath() %>" alt="Paneer Pizza">
		    <div class="item-details">
		      <h3><%= m.getItemname() %></h3>
		      <p><%= m.getDescription() %></p>
		      <p class="price">₹<%= m.getPrice() %></p>
		      <p class="quantity">Qty: <%= m.getQuantity() %></p>
		      <div class="rating">⭐ <%= m.getRating() %></div>
		    </div>
		  </div>
		  
		  <% 
	}

	
%>
  

  

</body>
</html>