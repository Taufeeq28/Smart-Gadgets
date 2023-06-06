import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/All")

public class All extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = null;
		String CategoryName = request.getParameter("maker");
        


		HashMap<String, WearableTech> h1 = new HashMap<String, WearableTech>(SaxParserDataStore.wts);
		HashMap<String, VoiceAsst> h2 = new HashMap<String, VoiceAsst>(SaxParserDataStore.vas);
		HashMap<String, Laptop> h3 = new HashMap<String, Laptop>(SaxParserDataStore.laptops);
		HashMap<String, Phone> h4 = new HashMap<String, Phone>(SaxParserDataStore.phones);
	/*	if(CategoryName==null){
			hm.putAll(SaxParserDataStore.wts);
			name = "";
		}
		else
		{
		   if(CategoryName.equals("Fitnesswatches"))
		   {
			 for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wts.entrySet())
			 {
				if(entry.getValue().getRetailer().equals("Fitnesswatches"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
			 }
				name = "FitnessWatches";
		   }
		   if(CategoryName.equals("Smartwatches"))
		   {
			 for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wts.entrySet())
			 {
				if(entry.getValue().getRetailer().equals("Smartwatches"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
			 }
				name = "SmartWatches";
		   }
		   if(CategoryName.equals("headphones"))
		   {
			 for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wts.entrySet())
			 {
				if(entry.getValue().getRetailer().equals("Headphones"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
			 }
				name = "Headphones";
		   }
		   if(CategoryName.equals("vr"))
		   {
			 for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wts.entrySet())
			 {
				if(entry.getValue().getRetailer().equals("VirtualReality"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
			 }
				name = "Virtual Reality";
		   }
		   if(CategoryName.equals("pettracker"))
		   {
			 for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wts.entrySet())
			 {
				if(entry.getValue().getRetailer().equals("PetTracker"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
			 }
				name = "Pet Tracker";
		   }
		
		}

*/
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("header.html");
		utility.printHtml("LeftNavBar.html");
		pw.print("<div id='container'>");
		//pw.print("<a style='font-size: 24px;'>Wearable Technology</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= h1.size()+h2.size()+h3.size()+h4.size();
		for(Map.Entry<String, WearableTech> entry : h1.entrySet())
		{
			WearableTech wt = entry.getValue();
			if(i%3==1) pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+wt.getName()+"</h3>");
			pw.print("<strong>$"+wt.getPrice()+"</strong><ul>");
			pw.print("<li id='item'><img src='images/wts/"+wt.getImage()+"' alt='' /></li>");
			
			pw.print("<form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form>");

			pw.print("<li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='price' value='"+wt.getPrice()+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li>");
			pw.print("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li>");
			pw.print("</ul></div></td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}	
		size=h1.size()+h2.size()+h3.size()+h4.size();
		for(Map.Entry<String, Phone> entry : h4.entrySet())
		{
			Phone wt = entry.getValue();
			if(i%3==1) pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+wt.getName()+"</h3>");
			pw.print("<strong>$"+wt.getPrice()+"</strong><ul>");
			pw.print("<li id='item'><img src='images/phones/"+wt.getImage()+"' alt='' /></li>");
			
			pw.print("<form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form>");
			pw.print("<li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='price' value='"+wt.getPrice()+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li>");
			pw.print("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li>");

			pw.print("</ul></div></td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}	
		size=h1.size()+h2.size()+h3.size()+h4.size();
		for(Map.Entry<String, Laptop> entry : h3.entrySet())
		{
			Laptop wt = entry.getValue();
			if(i%3==1) pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+wt.getName()+"</h3>");
			pw.print("<strong>$"+wt.getPrice()+"</strong><ul>");
			pw.print("<li id='item'><img src='images/laptops/"+wt.getImage()+"' alt='' /></li>");
			
			pw.print("<form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form>");
			pw.print("<li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='price' value='"+wt.getPrice()+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li>");
			pw.print("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li>");

			pw.print("</ul></div></td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}	
		size=h1.size()+h2.size()+h3.size()+h4.size();
		for(Map.Entry<String, VoiceAsst> entry : h2.entrySet())
		{
			VoiceAsst wt = entry.getValue();
			if(i%3==1) pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+wt.getName()+"</h3>");
			pw.print("<strong>$"+wt.getPrice()+"</strong><ul>");
			pw.print("<li id='item'><img src='images/vas/"+wt.getImage()+"' alt='' /></li>");
			
			pw.print("<form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form>");
			
			pw.print("<li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='price' value='"+wt.getPrice()+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li>");
			pw.print("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='wts'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li>");
			pw.print("</ul></div></td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}
		pw.print("</table></div></div></div>");
   
		utility.printHtml("footer.html");
		
	}
}
