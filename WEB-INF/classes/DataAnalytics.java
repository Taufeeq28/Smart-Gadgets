// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.*;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import com.mongodb.*;
// import javax.servlet.http.HttpSession;
// @WebServlet("/DataAnalytics")

// public class DataAnalytics extends HttpServlet {
// 	static DBCollection myReviews;
// 	/* Trending Page Displays all the Consoles and their Information in Game Speed*/

// 	protected void doGet(HttpServletRequest request,
// 		HttpServletResponse response) throws ServletException, IOException {
// 		response.setContentType("text/html");
// 		PrintWriter pw = response.getWriter();
// 		Utilities utility = new Utilities(request, pw);
				
		
// 		//check if the user is logged in
// 		if(!utility.isLoggedin()){
// 			HttpSession session = request.getSession(true);				
// 			session.setAttribute("login_msg", "Please Login to View Reviews");
// 			response.sendRedirect("Login");
// 			return;
// 		}
		
						
// 		utility.printHtml("header.html");
// 		//utility.printHtml("LeftNavigationBar.html");
// 		pw.print("<div id='container'>");
// 		pw.print("<a style='font-size: 24px;'>Data Analytics on Review</a>");
// 		pw.print("</h2><div class='entry'>");
// 		pw.print("<table id='bestseller'>");
// 		pw.print("<form method='post' action='FindReviews'>");
	
//      		pw.print("<table id='bestseller'>");
// 			pw.print("<tr>");
// 			pw.print("<td> <input type='checkbox' name='queryCheckBox' value='productName'> Select </td>");
//                                 pw.print("<td> Product Name: </td>");
//                                 pw.print("<td>");
//                                        pw.print("<select name='productName'>");
// 				       pw.print("<option value='ALL_PRODUCTS'>All Products</option>");
//                                        pw.print("<option value='Iphone12'>Iphone 12</option>");
//                                        pw.print("<option value='Iphone13'>Iphone 13</option>");
//                                        pw.print("<option value='IphoneSE'>Iphone SE</option>");
//                                        pw.print(" <option value='SamsungGalaxyBook'>Samsung Galaxy Book</option>");
//                                        pw.print("<option value='Iphone13ProMax'>Iphone 13 Pro Max</option>");
									   
// 							           pw.print("<option value='SamsungGalaxyS10'>SamsungGalaxyS10</option>");
// 										pw.print("<option value='SamsungGalaxyNote10'>Samsung Galaxy Note 10</option>");
// 										pw.print("<option value='SamsungGalaxyS9'>Samsung Galaxy S9</option>");
// 										pw.print("<option value='One Plus Nord 2'>One Plus Nord 2</option>");
// 										pw.print("<option value='One Plus 7'>One Plus 7</option>");
										
// 										pw.print("<option value='LG Wing 5G'>LG Wing 5G</option>");
// 										pw.print("<option value='Samsung Galaxy Book Pro 2'>Samsung Galaxy Book Pro 2</option>");
// 										pw.print("<option value='Samsung Galaxy Book Go'>Samsung Galaxy Book Go</option>");
// 										pw.print("<option value='AppleMacbookPro'>Apple Macbook Pro</option>");
// 										pw.print("<option value='AppleMacbookAir'>Apple Macbook Air</option>");
// 										pw.print("<option value='DellLatitute3301'>Dell Latitute 3301</option>");
// 										pw.print("<option value='FitBitVersa3'>Fit Bit Versa 3</option>");
// 										pw.print("<option value='Fit Bit Versa 2'>Fit Bit Versa 2</option>");
// 										pw.print("<option value='SamsungGalaxyWatch2'>Samsung Galaxy Watch 2</option>");
// 										pw.print("<option value='Samsung Bluetooth'>Samsung Bluetooth</option>");
// 										pw.print("<option value='Beats Solo3 Wireless'>Beats Solo3 Wireless</option>");
// 										pw.print("<option value='Mellco VR Set'>Mellco VR Set</option>");
// 										pw.print("<option value='Tractive GPS Dog 4'>Tractive GPS Dog 4</option>");
// 										pw.print("<option value='Google Home'>Google Home</option>");
// 										pw.print("<option value='Google Nest'>Google Nest</option>");
// 										pw.print("<option value='Amazon Echo Dot 4th Gen'>Amazon Echo Dot 4th Gen</option>");
// 										pw.print("<option value='Samsung Transparent Case'>Samsung Transparent Case</option>");

//                                 pw.print("</td>");
// 			pw.print("<tr>");
// 			     pw.print("<td> <input type='checkbox' name='queryCheckBox' value='productPrice'> Select </td>");
//                                 pw.print("<td> Product Price: </td>");
//                               pw.print(" <td>");
//                                   pw.print("  <input type='number' name='productPrice' value = '0' size=10  /> </td>");
// 						pw.print("<td>");
// 					pw.print("<input type='radio' name='comparePrice' value='EQUALS_TO' checked> Equals <br>");
// 					pw.print("<input type='radio' name='comparePrice' value='GREATER_THAN'> Greater Than <br>");
// 					pw.print("<input type='radio' name='comparePrice' value='LESS_THAN'> Less Than");
// 					pw.print("</td></tr>");				
                            
  			
// 			pw.print("<tr><td> <input type='checkbox' name='queryCheckBox' value='reviewRating'> Select </td>");
//                                pw.print(" <td> Review Rating: </td>");
//                                pw.print(" <td>");
//                                    pw.print(" <select name='reviewRating'>");
//                                        pw.print(" <option value='1' selected>1</option>");
//                                        pw.print(" <option value='2'>2</option>");
//                                        pw.print(" <option value='3'>3</option>");
//                                      pw.print("   <option value='4'>4</option>");
//                                       pw.print("  <option value='5'>5</option>");
//                                 pw.print("</td>");
// 				pw.print("<td>");
// 				pw.print("<input type='radio' name='compareRating' value='EQUALS_TO' checked> Equals <br>");
// 				pw.print("<input type='radio' name='compareRating' value='GREATER_THAN'> Greater Than"); 
// 			pw.print("</td></tr>");
			
// 			pw.print("<tr>");
// 								pw.print("<td> <input type='checkbox' name='queryCheckBox' value='retailerCity'> Select </td>");
//                                 pw.print("<td> Retailer City: </td>");
//                                 pw.print("<td>");
//                                 pw.print("<input type='text' name='retailerCity' /> </td>");
								
//                             pw.print("</tr>");
							
// 							 pw.print("<tr>");
// 								pw.print("<td> <input type='checkbox' name='queryCheckBox' value='retailerZipcode'> Select </td>");
//                                pw.print(" <td> Retailer Zip code: </td>");
//                                pw.print(" <td>");
//                                     pw.print("<input type='text' name='retailerZipcode' /> </td>");
// 					        pw.print("</tr>");
// 				pw.print("<tr><td>");
// 					pw.print("<input type='checkbox' name='extraSettings' value='GROUP_BY'> Group By");
// 								pw.print("</td>");
// 								pw.print("<td>");
// 								pw.print("<select name='groupByDropdown'>");
//                                 pw.print("<option value='GROUP_BY_CITY' selected>City</option>");
//                                 pw.print("<option value='GROUP_BY_PRODUCT'>Product Name</option>");                                        
//                                 pw.print("</td><td>");
// 								pw.print("<input type='radio' name='dataGroupBy' value='Count' checked> Count <br>");
// 								pw.print("<input type='radio' name='dataGroupBy' value='Detail'> Detail <br>");
// 								pw.print("</td></tr>");
								
									
			
// 						pw.print("<tr>");
//                                 pw.print("<td colspan = '4'> <input type='submit' value='Find Data' class='btnbuy' /> </td>");
//                             pw.print("</tr>");
							
							
// 		pw.print("</table>");	
// 		pw.print("</div></div></div>");			
// 		utility.printHtml("footer.html");
	
	
	
			
// 	}
// 	protected void doPost(HttpServletRequest request,
// 			HttpServletResponse response) throws ServletException, IOException {

// 	}

// }
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.*;
import javax.servlet.http.HttpSession;
@WebServlet("/DataAnalytics")

public class DataAnalytics extends HttpServlet {
	static DBCollection myReviews;
	/* Trending Page Displays all the Consoles and their Information in Game Speed*/

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request, pw);
				
		
		//check if the user is logged in
		if(!utility.isLoggedin()){
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Please Login to View Reviews");
			response.sendRedirect("Login");
			return;
		}
		
						
		utility.printHtml("header.html");
		//utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='container'>");
		pw.print("<a style='font-size: 24px;'>Data Analytics on Review</a>");
		pw.print("</h2><div class='entry'>");
		pw.print("<table id='bestseller'>");
		pw.print("<form method='post' action='FindReviews'>");
	
     		pw.print("<table id='bestseller'>");
			pw.print("<tr>");
			pw.print("<td> <input type='checkbox' name='queryCheckBox' value='productName'> Select </td>");
                                pw.print("<td> Product Name: </td>");
                                pw.print("<td>");
                                       pw.print("<select name='productName'>");
				       pw.print("<option value='ALL_PRODUCTS'>All Products</option>");
                                       pw.print("<option value='pixel6'>Google Pixel 6</option>");
                                       pw.print("<option value='iphone14pro'>phone 14 pro</option>");
                                       pw.print("<option value='motog'>Motorola G</option>");
                                       pw.print(" <option value='S22ultra'>Samsung S 22 Ultra</option>");				   
							           pw.print("<option value='Samsung Galaxy Note 10'>Samsung Galaxy Note 10</option>");
										pw.print("<option value='SamsungGalaxyS9'>Samsung Galaxy S9</option>");
										pw.print("<option value='OnePlus10t'>One Plus 10t</option>");
										pw.print("<option value='OnePlus7'>One Plus 7</option>");
										
										pw.print("<option value='SamsungGalaxyBook'>SamsungGalaxyBook</option>");
										pw.print("<option value='SamsungGalaxyBookPro2'>Samsung Galaxy Book Pro 2</option>");
										pw.print("<option value='SamsungGalaxyBookGo'>Samsung Galaxy Book Go</option>");
										pw.print("<option value='Macbook pro 14'>Macbook pro 14</option>");
										pw.print("<option value='Applemacbookair'>Apple Macbook Air</option>");
										pw.print("<option value='Dell-Inspiron'>Dell-Inspiron 15</option>");
										pw.print("<option value='Dellzenbook'>Dell Zen Book</option>");
										pw.print("<option value='hpenvy'>HP Envy</option>");
										pw.print("<option value='lenovo'>Lenovo Ideapad</option>");
										pw.print("<option value='GoogleHome'>GoogleHome</option>");
										pw.print("<option value='GoogleHomeMini'>GoogleHomeMini</option>");
										pw.print("<option value='GoogleNest'>GoogleNest</option>");
										pw.print("<option value='GoogleNestMini'>GoogleNestMini</option>");
										pw.print("<option value='amazonechodot'>amazonechodot</option>");
										pw.print("<option value='AppleHP'>AppleHP</option>");
										pw.print("<option value='googlenesthub'>googlenesthub</option>");
										pw.print("<option value='Fitbit'>Fitbit</option>");
										pw.print("<option value='amazfit'>amazfit</option>");
										pw.print("<option value='mi'>mi</option>");
										pw.print("<option value='morepro'>morepro</option>");
										pw.print("<option value='zururu'>zururu</option>");
										pw.print("<option value='AmazfitWatch'>AmazfitWatch</option>");
										pw.print("<option value='AppleSeries8'>AppleSeries8</option>");
										pw.print("<option value='FitbitVersa2'>FitbitVersa2</option>");
										pw.print("<option value='Galaxywatch5'>Galaxywatch5</option>");
										pw.print("<option value='AppleAirPodsMax'>AppleAirPodsMax</option>");
										pw.print("<option value='BeatsWireLess'>BeatsWireLess</option>");
										pw.print("<option value='BosewireLess'>BosewireLess</option>");
										pw.print("<option value='Sennheiser'>Sennheiser</option>");
										pw.print("<option value='Sony-WH-1000XM5'>Sony-WH-1000XM5</option>");
										pw.print("<option value='AirtagCollar'>AirtagCollar</option>");
										pw.print("<option value='catTailer'>catTailer</option>");
										pw.print("<option value='TractiveDogTracker'>TractiveDogTracker</option>");
										pw.print("<option value='WhistlegoTracker'>WhistlegoTracker</option>");
										pw.print("<option value='SonyVR'>SonyVR</option>");
										pw.print("<option value='skywinvr'>skywinvr</option>");
										pw.print("<option value='LogitechChorus'>LogitechChorus</option>");
										pw.print("<option value='Meta-Quest2'>Meta-Quest2</option>");
										

                                pw.print("</td>");
			pw.print("<tr>");
			     pw.print("<td> <input type='checkbox' name='queryCheckBox' value='productPrice'> Select </td>");
                                pw.print("<td> Product Price: </td>");
                              pw.print(" <td>");
                                  pw.print("  <input type='number' name='productPrice' value = '0' size=10  /> </td>");
						pw.print("<td>");
					pw.print("<input type='radio' name='comparePrice' value='EQUALS_TO' checked> Equals <br>");
					pw.print("<input type='radio' name='comparePrice' value='GREATER_THAN'> Greater Than <br>");
					pw.print("<input type='radio' name='comparePrice' value='LESS_THAN'> Less Than");
					pw.print("</td></tr>");				
                            
  			
			pw.print("<tr><td> <input type='checkbox' name='queryCheckBox' value='reviewRating'> Select </td>");
                               pw.print(" <td> Review Rating: </td>");
                               pw.print(" <td>");
                                   pw.print(" <select name='reviewRating'>");
                                       pw.print(" <option value='1' selected>1</option>");
                                       pw.print(" <option value='2'>2</option>");
                                       pw.print(" <option value='3'>3</option>");
                                     pw.print("   <option value='4'>4</option>");
                                      pw.print("  <option value='5'>5</option>");
                                pw.print("</td>");
				pw.print("<td>");
				pw.print("<input type='radio' name='compareRating' value='EQUALS_TO' checked> Equals <br>");
				pw.print("<input type='radio' name='compareRating' value='GREATER_THAN'> Greater Than"); 
			pw.print("</td></tr>");
			
			pw.print("<tr>");
								pw.print("<td> <input type='checkbox' name='queryCheckBox' value='retailerCity'> Select </td>");
                                pw.print("<td> Retailer City: </td>");
                                pw.print("<td>");
                                pw.print("<input type='text' name='retailerCity' /> </td>");
								
                            pw.print("</tr>");
							
							 pw.print("<tr>");
								pw.print("<td> <input type='checkbox' name='queryCheckBox' value='retailerZipcode'> Select </td>");
                               pw.print(" <td> Retailer Zip code: </td>");
                               pw.print(" <td>");
                                    pw.print("<input type='text' name='retailerZipcode' /> </td>");
					        pw.print("</tr>");
				pw.print("<tr><td>");
					pw.print("<input type='checkbox' name='extraSettings' value='GROUP_BY'> Group By");
								pw.print("</td>");
								pw.print("<td>");
								pw.print("<select name='groupByDropdown'>");
                                pw.print("<option value='GROUP_BY_CITY' selected>City</option>");
                                pw.print("<option value='GROUP_BY_PRODUCT'>Product Name</option>");                                        
                                pw.print("</td><td>");
								pw.print("<input type='radio' name='dataGroupBy' value='Count' checked> Count <br>");
								pw.print("<input type='radio' name='dataGroupBy' value='Detail'> Detail <br>");
								pw.print("</td></tr>");
								
									
			
						pw.print("<tr>");
                                pw.print("<td colspan = '4'> <input type='submit' value='Find Data' class='btnbuy' /> </td>");
                            pw.print("</tr>");
							
							
		pw.print("</table>");	
		pw.print("</div></div></div>");			
		utility.printHtml("footer.html");
	
	
	
			
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}

