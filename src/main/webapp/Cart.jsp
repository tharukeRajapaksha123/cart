<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="css/cart.css">
</head>
<body>
	<div class="body">
		<div class= "title-wrapper">
			<h1>My Cart</h1>
		</div>
		<div class="item-container">
			<%
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","");
			PreparedStatement pst 
				= (PreparedStatement) con.prepareStatement("SELECT * from cart_item");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				int id =rs.getInt("id");
				String image = rs.getString("image");
				int quantity = rs.getInt("quantity");
				String name = rs.getString("item_name");
				%> 
				 	<div class="item-card" id="<%=id%>">
				 		<form method="post" action="DeleteEditServerlet">
				 			<input name="id" value="<%=id%>" id="hidden-input" >
					 		<div class="image-wrapper">
					 			  <img src="<%=image%>">
					 		</div>
					 		   	<input class="item-name" value="<%=name%>" name="name">
					 		   	<p> <%=rs.getString("brand") %> </p>
					 		    <p> LKR. <%=rs.getDouble("price") %> </p>
					 		  	<div classname="row"> 
					 		  		<span>Quantity : </span> <input value="<%=quantity%>" name="quantity">	
					 		  	 </div>
					 		    <div class="row">
					 		    	<button class="delete-button" type="submit">Delete</button>
					 		    	<button type="submit" type="submit">Edit</button>
					 		    </div>
				 		</form>
				 	</div>
				<%
			}
		
			%>
		</div>
	</div>
	<script>
		const deleteButton = document.querySelector(".delete-button")
		
		
		deleteButton.addEventListener("click", ()=>{
			
		});
		
		
		
		
	</script>
</body>
</html>