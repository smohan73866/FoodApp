<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tap.models.Cart,com.tap.models.CartItem" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #fdf5f5;
            margin: 0;
            padding: 20px;
            color: #333;
        }

        h1 {
            text-align: center;
            font-size: 36px;
            color: #d84315;
            margin-bottom: 30px;
        }
        
        .cart-container {
        max-width: 800px;
        margin: 20px auto;
        background: #fff;
        padding: 20px;
        border-radius: 12px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }

    .cart-item {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 0;
        border-bottom: 1px solid #f2f2f2;
    }
    .cart-item:last-child {
    border-bottom: none;
}

.cart-item-details {
    flex: 1;
    margin-left: 20px;
}

.cart-item h3 {
    font-size: 18px;
    margin: 0;
    color: #d84315;
}

.cart-item p {
    margin: 5px 0;
    color: #757575;
}

.quantity-controls {
    display: flex;
    align-items: center;
    gap: 10px;
}

.quantity-btn {
    background-color: #d84315;
    color: #fff;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
    border-radius: 4px;
    font-size: 14px;
}

.quantity-btn:hover {
    background-color: #bf360c;
}
.remove-btn {
    background-color: #ff5252;
    color: #fff;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
    border-radius: 4px;
    font-size: 14px;
}

.remove-btn:hover {
    background-color: #d32f2f;
}

.total {
    text-align: right;
    font-size: 22px;
    margin-top: 20px;
    font-weight: bold;
    color: #d84315;
}

.add-more-items {
    text-align: center;
    margin-top: 20px;
}

.add-more-items a {
    text-decoration: none;
    color: #d84315;
    font-size: 18px;
    border: 2px solid #d84315;
    padding: 8px 15px;
    border-radius: 6px;
    display: inline-block;
}

.add-more-items a:hover {
    background-color: #d84315;
    color: #fff;
}

.btn {
    background-color: #d84315;
    color: #fff;
    border: none;
    padding: 10px 20px;
    cursor: pointer;
    border-radius: 6px;
    font-size: 16px;
    display: inline-block;
    margin-top: 15px;
}

.btn:hover {
    background-color: #bf360c;
}

.proceed-to-checkout-btn{
display:block;
width:100%;
text-align:center;
}
.top-right-buttons {
  position: fixed;
  top: 20px;
  right: 20px;
  z-index: 999; /* Keeps it above other content */
}

.nav-button {
  background-color: green;
  color: white;
  border: none;
  padding: 10px 16px;
  margin-left: 10px;
  font-size: 14px;
  cursor: pointer;
  border-radius: 6px;
}

.nav-button:hover {
  background-color: darkgreen;
}
</style>

<head>
<body>

<h1>Your Cart</h1>
<div class="top-right-buttons">
	<%
	Integer resturantId = (Integer) session.getAttribute("resturantId");
	%>
  
  <a href="home"><button class="nav-button">HOME</button></a>
</div>
<div class="cart-container">
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        

        if (cart != null && !cart.getItems().isEmpty()) {
            for (CartItem item : cart.getItems().values()) {
    %>
        <div class="cart-item">
            <div class="cart-item-details">
                <h3><%= item.getName() %></h3>
                <p>Price: ₹<%= item.getPrice() %></p>
                <p>Total: ₹<%= item.getPrice() %></p>
            
            
           <div class="quantity-controls">
    <form action="cart" method="post" style="display: inline;">
        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
         <input type="hidden" name="resturantId" value="<%=resturantId %>">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
        <button class="quantity-btn">+</button>
    </form>

    <p><%= item.getQuantity() %></p>

    <form action="cart" method="post" style="display: inline;">
        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
        <input type="hidden" name="resturantId" value="<%=resturantId %>">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
        <button class="quantity-btn" <% if (item.getQuantity() == 1) { %> disabled <% } %>>-</button>
        
    </form>
</div>
     	</div>
     	<form action="cart" method="post">
    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
    <input type="hidden" name="resturantId" value="<%= session.getAttribute("resturantId") %>">
    <input type="hidden" name="action" value="remove">
    <button class="remove-btn">Remove</button>
</form>
</div>
<% 
}
%>

     	
<div class="total">Grand Total: ₹<%=cart.getTotalPrice() %></div>


<div class="add-more-items">
    <a href="menu?resturantId=<%= session.getAttribute("resturantId") %>" 
       class="btn add-more-items-btn">Add More Items</a>
</div>

<form action="final.jsp" method="post" style="text-align: center; margin-top: 20px;">
    <button type="submit" style="background-color: green; color: white; padding: 10px 25px; border: none; border-radius: 5px; cursor: pointer;">
        Place Order
    </button>
</form>

<% }
    else { 
    %>
    <p style="text-align: center; color: #757575;">Your cart is empty.</p>
    <div class="add-more-items">
        <a href="home" >
            Add Items
        </a>
    </div>
<%
}
%>
</div>
</body>

</head>