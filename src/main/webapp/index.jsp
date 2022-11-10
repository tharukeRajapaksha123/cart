<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
	
	<div class="body">
			<a href="Cart.jsp"><button class="button" > Cart </button></a>
			<form method="post" action="AddToCartServerlet">
				<div class="item-card">
						<input name="image" value="https://ic.carid.com/bi/steering-wheels/steering-wheels_0.jpg"><img src="https://ic.carid.com/bi/steering-wheels/steering-wheels_0.jpg" ></input>
						<input name="item_name" value = "Steering wheel"><h3 id="item" name = "item_name">Steering Wheel</h3></input>
						<input name="brand" value= "Mazda"><h4>Mazda</h4></input>
						<input name = "price" value = "5000"><h5 name="price">LKR : 5000</h5></input>
						<button class="button" type="submit">Add to card</button>
					
				</div>
			</form>
	</div>
</body>
</html>