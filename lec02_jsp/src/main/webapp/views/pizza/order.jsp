<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문</title>
</head>
<body>
<h2>피자 주문하기</h2>
<form name="orderFrm" id="orderFrm" action=/pizzaOrderEnd method="post">
  <fieldset>
      <legend>고객 정보</legend>
      <label for="user_name">고객명 : </label>
      <input type="text" id="user_name" name="user_name">
      <br>
      <label for="user_phone">전화번호 : </label>
      <input type="text" id="user_phone" name="user_phone">
      <br>
      <label for="user_email">E-mail : </label>
      <input type="email" id="user_email" name="user_email">
  </fieldset>
  <fieldset>
      <legend>피자 사이즈</legend>
      <input type="radio" name="size" id="small" value="1">
      <label for="small" >Small</label>
      <br>
      <input type="radio" name="size" id="medium" value="2">
      <label for="medium" >Medium</label>
      <br>
      <input type="radio" name="size" id="large" value="3" checked>
      <label for="large" >Large</label>
  </fieldset>
  <fieldset>
      <legend>토핑 선택</legend>
      <input type="checkbox" name="topping" id="shrimp" value="1">
      <label for="shrimp" >새우</label>
      <br>
      <input type="checkbox" name="topping" id="sweet" value="2">
      <label for="sweet" >고구마</label>
      <br>
      <input type="checkbox" name="topping" id="potato" value="3">
      <label for="potato" >감자</label>
      <br>
      <input type="checkbox" name="topping" id="pine" value="4">
      <label for="pine" >파인애플</label>
  </fieldset>
  <br>
  <label for="delivery_time">희망 배송 시간 : </label>
  <input type="time" id="delivery_time" name="delivery_time">
  <input type="submit" value="주문하기">
</form>
</body>
</html>