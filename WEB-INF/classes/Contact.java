import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Contact")

public class Contact extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("header.html");
		utility.printHtml("LeftNavBar.html");
		pw.print("<div id='container'>");
		//pw.print("<a style='font-size: 24px;'>Wearable Technology</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		pw.print("<h3 style='margin-left:16px'><p  text-align:center font-color: white>Welcome to Smart Portables Customer Service!<p><h3>");
		//pw.print("<br/><h4><p  text-align:center font-color: white>Our Features include:</h4>");
			pw.print("<br><br><br><h4 style='margin-left:16px'><p  text-align:center font-color: white>Please contact the Smart Portables Help Centre or Customer Care at 872 97 82345</h4>");
				pw.print("<br><h4 style='margin-left:16px'><p  text-align:center font-color: white>Email: smartp@gmail.com</h4>");
					
		// utility.printHtml("footer.html");
		
	}
}