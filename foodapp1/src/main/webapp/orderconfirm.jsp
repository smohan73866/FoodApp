<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>Order Placed Overlay</title>
<style>
  html, body {
    height: 100%; margin: 0; background: #000; font-family: system-ui, sans-serif;
    overflow: hidden;
  }
  .stage {
    position: fixed; inset: 0;
    background: #111;
    display: flex; justify-content: center; align-items: center;
    overflow: hidden;
  }
  video {
    width: 100vw; height: 100vh; object-fit: cover;
  }
  .home-btn {
    position: fixed; top: 16px; right: 16px;
    background: rgba(255,255,255,0.85);
    color: #111; padding: 8px 16px; border-radius: 24px;
    font-weight: 600; text-decoration: none;
    z-index: 9999;
    transition: background 0.2s ease;
  }
  .home-btn:hover {
    background: rgba(255,255,255,1);
  }
  .order-overlay {
    position: fixed; inset: 0;
    background: linear-gradient(180deg, rgba(0,0,0,0.35), rgba(0,0,0,0.55));
    backdrop-filter: blur(6px);
    display: flex; flex-direction: column; align-items: center; justify-content: center;
    pointer-events: none;
    opacity: 0;
    transform: translateY(20px) scale(0.98);
    transition: opacity 0.35s ease, transform 0.35s cubic-bezier(.2,.9,.3,1);
    z-index: 10;
  }
  .order-overlay.show {
    opacity: 1;
    transform: translateY(0) scale(1);
  }
  .card {
    max-width: 400px;
    width: 85%;
    padding: 24px 20px;
    border-radius: 14px;
    background: #fff;
    box-shadow: 0 6px 18px rgba(0,0,0,0.25);
    text-align: center;
  }
  .card h1 {
    font-size: 24px;
    margin-bottom: 10px;
    color: #111;
  }
  .card p {
    font-size: 16px;
    color: #333;
    margin-bottom: 12px;
  }
  .check {
    width: 60px; height: 60px;
    border-radius: 50%;
    background: linear-gradient(135deg,#0ea5a1,#059669);
    display: inline-grid; place-items: center;
    color: #fff; font-weight: 700;
    margin: 8px auto 14px;
    font-size: 30px;
    box-shadow: 0 6px 14px rgba(6,95,70,0.18);
  }
  .order-meta {
    display: flex; justify-content: space-between;
    font-size: 14px;
    color: #666;
  }
</style>
</head>
<body>
<%
	Double totalamount=(Double)session.getAttribute("total");
%>

<div class="stage" aria-live="polite">
  <!-- Home button -->
  <a href="home" class="home-btn">Home</a>

  <video id="clip" playsinline preload="auto" autoplay muted>
    <source src="images/order.mp4" type="video/mp4" />
    Your browser doesn't support HTML5 video.
  </video>

  <div id="order" class="order-overlay" role="status" aria-hidden="true">
    <div class="card">
      <div class="check">✓</div>
      <h1>Order Placed!</h1>
      <div class="order-meta">
        <div>Total Amount: <strong><span id="totalAmount">₹<%= totalamount %></span></strong></div>
      </div>
    </div>
  </div>
</div>

<script>
  const video = document.getElementById('clip');
  const orderOverlay = document.getElementById('order');
  const homeBtn = document.querySelector('.home-btn');

  video.addEventListener('ended', () => {
    orderOverlay.classList.add('show');
    orderOverlay.setAttribute('aria-hidden', 'false');
  });

  homeBtn.addEventListener('click', () => {
    orderOverlay.classList.remove('show');
    orderOverlay.setAttribute('aria-hidden', 'true');
  });
</script>

</body>
</html>