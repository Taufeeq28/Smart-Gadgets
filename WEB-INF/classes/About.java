import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/About")

public class About extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("header.html");
		utility.printHtml("LeftNavBar.html");
		pw.print("<div id='container'>");
		//pw.print("<a style='font-size: 24px;'>Wearable Technology</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		pw.print("<h4 style='margin-left:16px'><p  text-align:center font-color: white>Because life waits for no one, at Smart Portables we provide consumer electronics,laptops and mobile devices that are designed to help you connect with those who matter most. Whether that means staying connected on-the-go or sharing your favorite photos.Designed with you in mind, the products offer innovative solutions to make life good. <p><h4>");
		//pw.print("<br/><h4><p  text-align:center font-color: white>Our Features include:</h4>");
			pw.print("<br/><h4 style='margin-left:16px'><p  text-align:center font-color: white>Our Features include:</h4>");
				pw.print("<br/><h4 style='margin-left:16px'><p  text-align:center font-color: white>1. Home delivery</h4>");
					pw.print("<br/><h4 style='margin-left:16px'><p  text-align:center font-color: white>2. In-Store Pickup</h4>");
						pw.print("<br/><h4 style='margin-left:16px'><p  text-align:center font-color: white>3. Credit card payment accepted</h4>");
							pw.print("<br/><h4 style='margin-left:16px'><p  text-align:center font-color: white>4. Two-Week Delivery </h4>");
		// utility.printHtml("footer.html");
		
	}
}
