

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class DeleteEditServerlet
 */
@WebServlet("/DeleteEditServerlet")
public class DeleteEditServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Id is " + id);
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","");
			PreparedStatement pst 
			= (PreparedStatement) con.prepareStatement("SELECT * from cart_item where item_name = ?");
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			System.out.print("called" +  name) ;
			if(rs.next()) {
				int prevoius = rs.getInt("quantity");
				if(prevoius == quantity) {
					System.out.println("delete callled");
					PreparedStatement delete 
					= (PreparedStatement) con.prepareStatement("DELETE  from cart_item where id = ? ");
					delete.setInt(1, id);
					delete.execute();					
					dispatcher = request.getRequestDispatcher("Cart.jsp");
				}else {
					System.out.println("update callled");
					PreparedStatement delete 
					= (PreparedStatement) con.prepareStatement("UPDATE cart_item SET quantity = ?  where id = ? ");
					delete.setInt(1, quantity);
					delete.setInt(2,id);
					delete.execute();					
					dispatcher = request.getRequestDispatcher("Cart.jsp");
				}
			}
			
		
			dispatcher.forward(request, response);
		}catch (Exception e) {
			System.out.print("Get data int database failed " + e.getMessage());
		}
	
	}

}
