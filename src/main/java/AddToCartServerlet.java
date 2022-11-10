

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@WebServlet("/AddToCartServerlet")
public class AddToCartServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemName = request.getParameter("item_name");
		String image = request.getParameter("image");
		String price = request.getParameter("price");
		String brand = request.getParameter("brand");
		
		
		
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","");
			PreparedStatement pst 
				= (PreparedStatement) con.prepareStatement("INSERT INTO cart_item(item_name,image,brand,price,quantity) VALUES(?,?,?,?,?)");
			pst.setString(1, itemName);
			pst.setString(2, image);
			pst.setString(3, brand);
			pst.setString(4, price);
			pst.setInt(5,1);
			int rowCount = pst.executeUpdate();
			if(rowCount >0 ) {
				request.setAttribute("status", "sucess");
				dispatcher = request.getRequestDispatcher("Cart.jsp");
				
			}else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("register.jsp");
			}
		
			dispatcher.forward(request, response);
		}catch (Exception e) {
			System.out.print("Insert data int database failed " + e.getMessage());
		}
		System.out.print(price);
	
	}

}
