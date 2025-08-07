<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List,com.tap.models.Order" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>My Orders</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f5f5f5;
      padding: 20px;
    }

    .order-card {
      background: white;
      border-radius: 10px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
      margin-bottom: 20px;
      padding: 20px;
      text-decoration: none;
      color: black;
      display: block;
      transition: transform 0.2s;
    }

    .order-card:hover {
      transform: scale(1.02);
      background-color: #f0f8ff;
    }

    .order-header {
      font-size: 18px;
      font-weight: bold;
    }

    .order-details {
      margin-top: 8px;
    }

    .status {
      color: green;
      font-weight: bold;
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

  <h2>My Orders</h2>
  
  <div class="top-right">
  <a href="home" class="back-button">BACK</a></div>
  
  <%
  List<Order> list=(List<Order>)request.getAttribute("orders");
  
  for(Order o:list)
  {
	  java.sql.Timestamp ts=o.getOrderdate();
	  
	  String date=new java.text.SimpleDateFormat("yyyy-MM-dd").format(ts);
	%>
  <!-- Order 1 -->
  <a href="orderdetails?orderId=<%=o.getOrderid() %>" class="order-card">
    <div class="order-header">Order</div>
    <div>Resturant Name: <%= o.getResturantName() %></div>
    <div class="order-details">Date: <%= date %></div>
    <div class="order-details">Total Price: ₹<%=o.getTotalamount() %></div>
    <div class="status"><%= o.getStatus() %></div>
  </a>
  <%
  }
  %>
  

</body>
</html>