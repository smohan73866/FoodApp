<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Static Profile</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f2f5;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .profile-box {
      background-color: #fff;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
      text-align: center;
      width: 300px;
    }

    .profile-box img {
      width: 120px;
      height: 120px;
      border-radius: 50%;
      object-fit: cover;
      margin-bottom: 15px;
    }

    .profile-box h2 {
      margin: 10px 0 5px;
      font-size: 22px;
    }

    .profile-box p {
      margin: 6px 0;
      color: #555;
      font-size: 15px;
    }
  </style>
</head>
<body>
  <div class="profile-box">
  <%
  String name=(String)request.getAttribute("name");
  String phone=(String)request.getAttribute("phone");
  String email=(String)request.getAttribute("email");
  %>
    
    <h2><%=name %></h2>
    <p><strong>Phone:</strong> <%=phone %></p>
    <p><strong>Email:</strong> <%=email %></p>
  </div>
</body>
</html>
