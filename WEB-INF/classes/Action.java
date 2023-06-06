// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.HashMap;
// import java.util.Map;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// @WebServlet("/WearableTechList")

// public class WearableTechList extends HttpServlet {

// 	private static final long serialVersionUID = 1L;
// 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 		response.setContentType("text/html");
// 		PrintWriter pw = response.getWriter();
// 		Utilities utility = new Utilities(request,pw);
// 		utility.printHtml("header.html");
// 		utility.printHtml("LeftNavBar.html");
// 		pw.print("<div id='container'>");
// 		pw.print("<h2 id='salesreport'><a href='SRFile'>Sales Report</a></h2>");
// 		pw.print("<h2 id='salesreportbydate'><a href='SRFile'>Sales Report by date</a></h2>");
// 		pw.print("<h2 id='barchart'><a href='SRFile'>Click here for Sales Report BarChart</a></h2>");	
// 		pw.print("</div>");
   
// 		utility.printHtml("footer.html");
		
// 	}
// }
