// import java.util.ArrayList;
// import java.io.PrintWriter;
// import java.util.HashMap;
// import java.io.IOException;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
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



// 
// Decompiled by Procyon v0.5.36
// 
class MyComparator implements Comparator<String>
    {
        public int compare(String o1,String o2)
        {
           return (o1.compareTo(o2));
        }
    }
@WebServlet({ "/SRFile" })
public class SRFile extends HttpServlet
{
    private String error_msg;
    
    protected void doGet(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.getWriter();
        this.displaySR(httpServletRequest, httpServletResponse);

    }
    
    protected void displaySR(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        // String  parameter=request.getParameter();
        final PrintWriter writer = httpServletResponse.getWriter();
        final MySqlDataStoreUtilities mySqlDataStoreUtilities = new MySqlDataStoreUtilities();
        final Utilities utilities = new Utilities(httpServletRequest, writer);
        try {
            httpServletResponse.setContentType("text/html");
            httpServletRequest.getSession();
            utilities.printHtml("header.html");
            writer.print("<div id='container'>");
            writer.print("<a style='font-size: 35px;color:#fff'>Sales Report</a>");
            writer.print("</h2><div class='entry'>");
            writer.print("<table class='gridtable'>");
            final HashMap hashMap = new HashMap();
            try {
              MySqlDataStoreUtilities.selectOrderCount();
            }
            catch (Exception ex) {}
           
            writer.print("<tr>");
            writer.print("<td>Product Ordered</td>");
             writer.print("<td>Product Price</td>");
            writer.print("<td>Number of Items</td>");
             writer.print("<td>Total Sales</td></tr>");
            final ArrayList findcountname = MySqlDataStoreUtilities.Findcountname();
            final ArrayList findcount = MySqlDataStoreUtilities.Findcount();
             final ArrayList findcountprice = MySqlDataStoreUtilities.Findcountprice();
            for (Integer n = 0; n < findcountname.size(); ++n) {
                writer.print("<tr><td>");
                writer.print(findcountname.get(n)+"</td><td>");
                    writer.print(findcountprice.get(n)+"</td><td>");
                writer.print(findcount.get(n)+"</td><td>");
                Double ans=Double.parseDouble(String.valueOf(findcountprice.get(n)))*Double.parseDouble(String.valueOf(findcount.get(n)));
                writer.print(ans+"</td>");
                writer.print("</tr>");
            }
            writer.print("</table><hr>");





 writer.print("<a style='font-size: 35px;color:#fff''>Sales Report by Date</a>");
            writer.print("</h2><div class='entry'>");
            writer.print("<table class='gridtable'>");
        
           
            writer.print("<tr>");
            writer.print("<td>Date</td>");
             writer.print("<td>Total Sales</td></tr>");
            final ArrayList finddeliverydate = MySqlDataStoreUtilities.Finddeliverydate();
            //final ArrayList findcount = MySqlDataStoreUtilities.Findcount();
            // final ArrayList findcountprice = MySqlDataStoreUtilities.Findcountprice();
            for (Integer n = 0; n < findcountname.size(); ++n) {
                writer.print("<tr><td>");
                //writer.print(findcountname.get(n)+"</td><td>");
                   // writer.print(findcountprice.get(n)+"</td><td>");
               // writer.print(findcount.get(n)+"</td><td>");
                writer.print(finddeliverydate.get(n)+"</td><td>");
                Double ans=Double.parseDouble(String.valueOf(findcountprice.get(n)))*Double.parseDouble(String.valueOf(findcount.get(n)));
                writer.print(ans+"</td>");
                writer.print("</tr>");
            }
            writer.print("</table><hr>");












            writer.print("<div><h2><a href='Chart'><span class='glyphicon'style='color:#fff'>Click here for BarChart</span></a></div>");
            writer.print("</h2></div></div></div>");
            utilities.printHtml("footer.html");
        }
        catch (Exception ex2) {}
    }
}