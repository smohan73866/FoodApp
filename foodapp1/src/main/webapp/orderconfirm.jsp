<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Order Confirmed</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
      font-family: Arial, sans-serif;
    }

    .overlay {
      position: fixed;
      top: 0;
      left: 0;
      width: 100vw;
      height: 100vh;
      background: rgba(0, 0, 0, 0.6);
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .modal {
      position: relative;
      background: white;
      padding: 20px;
      border-radius: 12px;
      box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
      width: 90%;
      max-width: 500px;
      text-align: center;
    }

    .modal h2 {
      margin-bottom: 15px;
      color: green;
    }

    video {
      width: 100%;
      border-radius: 8px;
    }

    .home-button {
      position: absolute;
      top: 10px;
      right: 10px;
      background-color: #007bff;
      color: white;
      padding: 8px 14px;
      border: none;
      border-radius: 6px;
      text-decoration: none;
      font-size: 14px;
      cursor: pointer;
    }

    .home-button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>

<div class="overlay">
  <div class="modal">
    <a href="home" class="home-button">🏠 Home</a>
    <h2>✅ Order Confirmed!</h2>
    <video controls autoplay>
      <source src="order-confirmed.mp4" type="video/mp4">
      Your browser does not support the video tag.
    </video>
  </div>
</div>

</body>
</html>