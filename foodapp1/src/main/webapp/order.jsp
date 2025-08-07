<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Checkout Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f4f4f4;
      margin: 0;
      padding: 0;
    }

    .container {
      width: 400px;
      background: #fff;
      margin: 50px auto;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
      color: #333;
    }

    label {
      display: block;
      margin: 10px 0 5px;
      color: #444;
    }

    input[type="text"],
    textarea {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      resize: vertical;
    }

    .payment-options {
      margin: 15px 0;
    }

    .payment-options label {
      display: block;
      margin-bottom: 8px;
    }

    input[type="radio"] {
      margin-right: 10px;
    }

    button {
      width: 100%;
      padding: 12px;
      background-color: #28a745;
      color: white;
      border: none;
      border-radius: 5px;
      font-size: 16px;
      cursor: pointer;
      margin-top: 15px;
    }

    button:hover {
      background-color: #218838;
    }
  </style>
</head>
<body>

  <div class="container">
    <h2>Checkout</h2>

    <form action="placeorder">
      <label for="address">Delivery Address:</label>
      <textarea id="address" name="address" rows="4" placeholder="Enter your address here..." required></textarea>

      <div class="payment-options">
        <label>Payment Method:</label>
        <label><input type="radio" name="payment" value="cod" required> Cash on Delivery</label>
        <label><input type="radio" name="payment" value="upi"> UPI</label>
        <label><input type="radio" name="payment" value="card"> Card Payment</label>
      </div>

      <button type="submit">Place Order</button>
    </form>
  </div>

</body>
</html>