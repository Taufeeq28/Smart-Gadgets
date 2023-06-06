import java.io.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/Payment")

public class Payment extends HttpServlet {
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		

		Utilities utility = new Utilities(request, pw);
		if(!utility.isLoggedin())
		{
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "You are not logged in.Please Login to Pay!");
			response.sendRedirect("Login");
			return;
		}
		// get the payment details like credit card no address processed from cart servlet	

		String userAddress=request.getParameter("userAddress");
		String creditCardNo=request.getParameter("creditCardNo");
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zipcode=request.getParameter("zipcode");
String storeid=request.getParameter("storeid");

		System.out.print("the user address is" +userAddress);
		System.out.print(creditCardNo);
		if(!userAddress.isEmpty() && !creditCardNo.isEmpty() && !street.isEmpty()&& !city.isEmpty()&& !state.isEmpty()&& !zipcode.isEmpty() )
		{
			//Random rand = new Random(); 
			//int orderId = rand.nextInt(100);
			int orderId=utility.getOrderPaymentSize()+1;

			//iterate through each order
SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
			Calendar c= Calendar.getInstance();		//Getting current date					
		        c.add(Calendar.DAY_OF_MONTH, 14);			//Number of Days to adding					
				String dd = s.format(c.getTime());	//Date after adding the days to the current date

				Date date = new Date();
				String orderDate = s.format(date);
				c= Calendar.getInstance();	
				c.add(Calendar.DAY_OF_MONTH, 9);			//Number of Days to adding					
				String ddl = s.format(c.getTime());
			for (OrderItem oi : utility.getCustomerOrders())
			{

				//set the parameter for each column and execute the prepared statement

				utility.storePayment(orderId,oi.getName(),oi.getPrice(),userAddress,creditCardNo,street,city,state,zipcode,ddl);
			}

			//remove the order details from cart after processing
			// MySqlDataStoreUtilities.storelocations(storeid,street,city,state,zipcode);
// SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
// 			Calendar c= Calendar.getInstance();		//Getting current date					
// 		        c.add(Calendar.DAY_OF_MONTH, 14);			//Number of Days to adding					
// 				String dd = s.format(c.getTime());	//Date after adding the days to the current date

// 				Date date = new Date();
// 				String orderDate = s.format(date);
// 				c= Calendar.getInstance();	
// 				c.add(Calendar.DAY_OF_MONTH, 9);			//Number of Days to adding					
// 				String ddl = s.format(c.getTime());	//Date after adding the days to the current date
			OrdersHashMap.orders.remove(utility.username());	
			utility.printHtml("header.html");
			//utility.printHtml("LeftNavigationBar.html");
			pw.print("<div id='container'>");
			pw.print("<a style='font-size: 24px; color:#a80000'>Order</a>");
			pw.print("</h2><div class='entry'>");
		
			pw.print("<h2>Your Order");
			pw.print("&nbsp&nbsp");  
			pw.print("is stored ");
			pw.print("<br>Your Order Number is "+(orderId));
			pw.print("<br>Delivery date is "+(dd));
			pw.print("<br>You can cancel the order before "+(ddl));
			pw.print("</h2></div></div></div>");		
			utility.printHtml("footer.html");
		}else
		{
			utility.printHtml("header.html");
			//utility.printHtml("LeftNavigationBar.html");
			pw.print("<div id='container'>");
			pw.print("<a style='font-size: 24px;'>Order</a>");
			pw.print("</h2><div class='entry'>");
		
			pw.print("<h4 style='color:red'>Please enter valid address and credit card number</h4>");
			pw.print("</h2></div></div></div>");		
			utility.printHtml("footer.html");
		}	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request, pw);
		
		
	}
}
