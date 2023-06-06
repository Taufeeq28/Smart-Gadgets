import java.sql.*;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.*;
import org.jfree.data.*;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.*;
import java.io.PrintWriter;
import java.util.*;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;

@WebServlet("/Chart")

public class Chart extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
Utilities utility = new Utilities(request, pw);
      //  response.setContentType("text/html");
        HttpSession session=request.getSession();   
        utility.printHtml("header.html");
pw.print("<div id='content'><div class='post'>");
                pw.print("<h2 class='title meta'><a style='font-size: 24px;'>Graphical View Of Products Sold</a></h2>"
                        + "<div class='entry'>");
                pw.println("<script type='text/javascript' src=\"https://www.gstatic.com/charts/loader.js\"></script>");
                pw.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>"+
                            "<script type='text/javascript' src='https://www.google.com/jsapi'></script>");

                pw.println("<script type='text/javascript'>");
                Map<OrderItem,String> map1 = new HashMap<OrderItem,String>();
                map1 = MySqlDataStoreUtilities.getAllProductSold();
                pw.println("google.charts.load('current', {'packages':['corechart']});");
                pw.println("google.charts.setOnLoadCallback(drawChart);");
                pw.println("function drawChart() {");
                pw.println("var data = new google.visualization.DataTable();");
                pw.println("data.addColumn('string', 'Product Name');");
                pw.println("data.addColumn('number', 'Total Sales');");
                pw.println(" data.addRows([");
                    Iterator it = map1.entrySet().iterator();
                    while(it.hasNext())
                    {
                        Map.Entry entry = (Map.Entry) it.next();
                        OrderItem key = (OrderItem) entry.getKey();
                        String value = (String) entry.getValue();
                        //Float totalsale= Float.parseFloat(key.getPrice() * Float.parseFloat(value));
                        pw.println(" ['"+key.getName()+"', "+value+"],");
                        //pw.println("<tr><td style='font-size:12px;text-align:center'>" +key.getName()+ " </td><td style='font-size:12px;text-align:center'>$" +key.getPrice()+ "</td><td style='font-size:12px;text-align:center'>" +value+ "</td><td style='font-size:12px;text-align:center'>$" + key.getPrice() * Float.parseFloat(value) + "</td></tr>");
                    }


                pw.println("]);");
                // Set chart options
                pw.println(" var options = {'title':'Items Sold',");
                pw.println("        'width':600,");
                pw.println("       'height':650};");
     
                // Instantiate and draw our chart, passing in some options.
                pw.println(" var chart = new google.visualization.BarChart(document.getElementById('chart_div'));");
                pw.println("  chart.draw(data, options);     }");
                pw.println(" </script>");
            //Draw chart
                pw.println("<div id='chart_div'></div>");


                pw.print("</div></div></div>");
utility.printHtml("footer.html");








        //displayPage(request, response, pw);
    }

    /*protected void displayPage(HttpServletRequest request, HttpServletResponse response, PrintWriter pw)
            throws ServletException, IOException {

        Utilities utility = new Utilities(request, pw);
        response.setContentType("text/html");
      	HttpSession session=request.getSession(); 	
        utility.printHtml("header.html");
        //utility.printHtml("LeftNavigationBar.html");

        //pw.println("<div id='container'></div>");
        //pw.println("</div></div></div>");
        pw.println("<script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>");
        pw.println("<script type='text/javascript' src='ChartSold.js'></script>");
        utility.printHtml("footer.html");

    }
*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {




    }
}