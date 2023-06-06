import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet("/Utilities")


public class Utilities extends HttpServlet{
	HttpServletRequest req;
	PrintWriter pw;
	String url;
	HttpSession session; 
	public Utilities(HttpServletRequest req, PrintWriter pw) {
		this.req = req;
		this.pw = pw;
		this.url = this.getFullURL();
		this.session = req.getSession(true);
	}

	public void printHtml(String file) {
		// String result = HtmlToString(file);
		// //to print the right navigation in header of username cart and logout etc
		// if (file == "header.html") {
		// 		result=result+"<div id='nav' style='inherit: right;'><ul>";
		// 	if (session.getAttribute("username")!=null){
		// 		String username = session.getAttribute("username").toString();
		// 		username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
		// 		if(session.getAttribute("usertype").equals("manager"))
		// 		{
		// 			result = result + "<li><a href='ProductModify?button=Addproduct'><span class='glyphicon'>Addproduct</span></a></li>"
		// 				+ "<li><a href='ProductModify?button=Updateproduct'><span class='glyphicon'>Updateproduct</span></a></li>"
		// 				+"<li><a href='ProductModify?button=Deleteproduct'><span class='glyphicon'>Deleteproduct</span></a></li>"
		// 				+"<li><a href='DataVisualization'><span class='glyphicon'>Trending</span></a></li>"
		// 				+"<li><a href='DataAnalytics'><span class='glyphicon'>DataAnalytics</span></a></li>"
		// 				+ "<li><a><span class='glyphicon'>Hello,"+username+"</span></a></li>"
		// 				+"<li><a href='SRFile'><span class='glyphicon'>SalesReport</span></a></li>"
		// 				+ "<li><a href='Logout'><span class='glyphicon'>Logout</span></a></li>";
		// 		}
				
		// 		else if(session.getAttribute("usertype").equals("retailer")){
		// 			result = result + "<li><a href='Registration'><span class='glyphicon'>Create Customer</span></a></li>"
		// 				+ "<li><a href='ViewOrder'><span class='glyphicon'>ViewOrder</span></a></li>"
		// 				+ "<li><a><span class='glyphicon'>Hello,"+username+"</span></a></li>"
		// 				+ "<li><a href='Logout'><span class='glyphicon'>Logout</span></a></li>";
		// 		}
		// 		else
		// 		{
		// 		result = result + "<li><a href='ViewOrder'><span class='glyphicon'>ViewOrder</span></a></li>"
		// 				+ "<li><a><span class='glyphicon'>Hello,"+username+"</span></a></li>"
		// 				+ "<li><a href='Account'><span class='glyphicon'>Account</span></a></li>"
		// 				+ "<li><a href='Logout'><span class='glyphicon'>Logout</span></a></li>";
		// 	    }
		// 	}
		// 	else
		// 		result = result +"<li><a href='ViewOrder'><span class='glyphicon'>ViewOrder</span></a></li>"+ "<li><a href='Login'><span class='glyphicon'>Login</span></a></li>";
		// 		result = result +"<li><a href='Cart'><span class='glyphicon'>Cart("+CartCount()+")</span></a></li></ul></div></div><div id='page'>";
		// 		pw.print(result);
		// } else
		// 		pw.print(result);
		 String result = HtmlToString(file);
		//to print the right navigation in header of username cart and logout etc
		if (file == "header.html") {
				result=result+"<div id='nav' style='inherit: right;'><ul>";
			if (session.getAttribute("username")!=null){
				String username = session.getAttribute("username").toString();
				username = Character.toUpperCase(username.charAt(0)) + username.substring(1);
				if(session.getAttribute("usertype").equals("manager"))
				{
					result = result + "<li><a href='ProductModify?button=Addproduct'><span class='glyphicon'>Addproduct</span></a></li>"
						+ "<li><a href='ProductModify?button=Updateproduct'><span class='glyphicon'>Updateproduct</span></a></li>"
						+"<li><a href='ProductModify?button=Deleteproduct'><span class='glyphicon'>Deleteproduct</span></a></li>"
						+"<li><a href='DataVisualization'><span class='glyphicon'>Trending</span></a></li>"
						+"<li><a href='DataAnalytics'><span class='glyphicon'>DataAnalytics</span></a></li>"
						+ "<li><a><span class='glyphicon'>Hello,"+username+"</span></a></li>"
						+"<li><a href='SRFile'><span class='glyphicon'>SalesReport</span></a></li>"
												+"<li><a href='Inventory'><span class='glyphicon'>InventoryReport</span></a></li>"
						+ "<li><a href='Logout'><span class='glyphicon'>Logout</span></a></li>";
				}
				
				else if(session.getAttribute("usertype").equals("retailer")){
					result = result + "<li><a href='Registration'><span class='glyphicon'>Create Customer</span></a></li>"
						+ "<li><a href='ViewOrder'><span class='glyphicon'>ViewOrder</span></a></li>"
						+ "<li><a><span class='glyphicon'>Hello,"+username+"</span></a></li>"
						+ "<li><a href='Logout'><span class='glyphicon'>Logout</span></a></li>";
				}
				else
				{
				result = result + "<li><a href='ViewOrder'><span class='glyphicon'>ViewOrder</span></a></li>"
						+ "<li><a><span class='glyphicon'>Hello,"+username+"</span></a></li>"
						+ "<li><a href='Account'><span class='glyphicon'>Account</span></a></li>"
						+ "<li><a href='Logout'><span class='glyphicon'>Logout</span></a></li>";
			    }
			}
			else
				result = result +"<li><a href='ViewOrder'><span class='glyphicon'>ViewOrder</span></a></li>"+ "<li><a href='Login'><span class='glyphicon'>Login</span></a></li>";
				result = result +"<li><a href='Cart'><span class='glyphicon'>Cart("+CartCount()+")</span></a></li></ul></div></div><div id='page'>";
				pw.print(result);
		} else
				pw.print(result);
	}

public String getFullURL() {
		String scheme = req.getScheme();
		String serverName = req.getServerName();
		int serverPort = req.getServerPort();
		String contextPath = req.getContextPath();
		StringBuffer url = new StringBuffer();
		url.append(scheme).append("://").append(serverName);

		if ((serverPort != 80) && (serverPort != 443)) {
			url.append(":").append(serverPort);
		}
		url.append(contextPath);
		url.append("/");
		return url.toString();
	}

	
	public String HtmlToString(String file) {
		String result = null;
		try {
			String webPage = url + file;
			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			result = sb.toString();
		} 
		catch (Exception e) {
		}
		return result;
	}

	public void logout(){
		session.removeAttribute("username");
		session.removeAttribute("usertype");
	}
	
	

	public boolean isLoggedin(){
		if (session.getAttribute("username")==null)
			return false;
		return true;
	}

	
	
	public String username(){
		if (session.getAttribute("username")!=null)
			return session.getAttribute("username").toString();
		return null;
	}
	
	
	public String usertype(){
		if (session.getAttribute("usertype")!=null)
			return session.getAttribute("usertype").toString();
		return null;
	}
	
	
	public User getUser(){
		String usertype = usertype();
		HashMap<String, User> hm=new HashMap<String, User>();
		//String TOMCAT_HOME = System.getProperty("catalina.home");
			try
			{		
				//FileInputStream fileInputStream=new FileInputStream(new File(TOMCAT_HOME+"//webapps//Assignment1//UserDetails.txt"));
				//ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);	      
				hm=MySqlDataStoreUtilities.selectUser();
			}
			catch(Exception e)
			{
			}	
		User user = hm.get(username());
		return user;
	}

	public ArrayList<OrderItem> getCustomerOrders(){
		ArrayList<OrderItem> order = new ArrayList<OrderItem>(); 
		if(OrdersHashMap.orders.containsKey(username()))
			order= OrdersHashMap.orders.get(username());
		return order;
	}

	public int getOrderPaymentSize(){
		HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
		//`	int size=0;
		//String TOMCAT_HOME = System.getProperty("catalina.home");
			try
			{
				//FileInputStream fileInputStream = new FileInputStream(new File(TOMCAT_HOME+"//webapps//Assignment1//PaymentDetails.txt"));
				//ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);	      
				orderPayments =MySqlDataStoreUtilities.selectOrder();
			}
			catch(Exception e)
			{
			
			}
			int size=0;
			for(Map.Entry<Integer, ArrayList<OrderPayment>> entry : orderPayments.entrySet()){
					 size=entry.getKey();
					 
			}
			return size;		
	}
	

	
	public int CartCount(){
		if(isLoggedin())
		return getCustomerOrders().size();
		return 0;
	}
	

	public void storeProduct(String name,String type,String maker, String acc){
		if(!OrdersHashMap.orders.containsKey(username())){	
			ArrayList<OrderItem> arr = new ArrayList<OrderItem>();
			OrdersHashMap.orders.put(username(), arr);
		}
		ArrayList<OrderItem> orderItems = OrdersHashMap.orders.get(username());
		HashMap<String,Phone> allphones = new HashMap<String,Phone> ();
		HashMap<String,Laptop> alllaptops = new HashMap<String,Laptop> ();
		HashMap<String,WearableTech> allwts = new HashMap<String,WearableTech> ();
		HashMap<String,VoiceAsst> allvas = new HashMap<String,VoiceAsst> ();
		HashMap<String,Accessory> allaccessories=new HashMap<String,Accessory>();
		if(type.equals("phones")){
			Phone phone;
			try{
			allphones = MySqlDataStoreUtilities.getPhones();
			
			}
			catch(Exception e){
				
			}

			phone = allphones.get(name);
			OrderItem orderitem = new OrderItem(phone.getName(), phone.getPrice(), phone.getImage(), phone.getRetailer());
			orderItems.add(orderitem);
		}
		if(type.equals("laptops")){
			Laptop laptop=null;
			try{
			alllaptops = MySqlDataStoreUtilities.getLaptops();
			
			}
			catch(Exception e){
				
			}
			laptop = alllaptops.get(name);
			OrderItem orderitem = new OrderItem(laptop.getName(), laptop.getPrice(), laptop.getImage(), laptop.getRetailer());
			orderItems.add(orderitem);
		}
		if(type.equals("wts")){
			WearableTech wt=null;
			try{
			allwts = MySqlDataStoreUtilities.getWearableTechs();
			
			}
			catch(Exception e){
				
			}
			wt = allwts.get(name);
			OrderItem orderitem = new OrderItem(wt.getName(), wt.getPrice(), wt.getImage(), wt.getRetailer());
			orderItems.add(orderitem);
		}
		if(type.equals("vas")){
			VoiceAsst va=null;
			try{
			allvas = MySqlDataStoreUtilities.getVoiceAsst();
			
			}
			catch(Exception e){
				
			}
			va = allvas.get(name);
			OrderItem orderitem = new OrderItem(va.getName(), va.getPrice(), va.getImage(), va.getRetailer());
			orderItems.add(orderitem);
		}
		if(type.equals("accessories")){	
			try{
			allaccessories = MySqlDataStoreUtilities.getAccessories();
			}
			catch(Exception e){
				
			}
			Accessory accessory = allaccessories.get(name); 
			OrderItem orderitem = new OrderItem(accessory.getName(), accessory.getPrice(), accessory.getImage(), accessory.getRetailer());
			orderItems.add(orderitem);
		}



		
	}

	public void storePayment(int orderId,
		String orderName,double orderPrice,String userAddress,String creditCardNo,String street,String city,String state, String zipcode,String deliverydate){
		HashMap<Integer, ArrayList<OrderPayment>> orderPayments= new HashMap<Integer, ArrayList<OrderPayment>>();
			// get the payment details file 
		try
		{
			orderPayments=MySqlDataStoreUtilities.selectOrder();
		}
		catch(Exception e)
		{
			
		}
		if(orderPayments==null)

		{
			orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
		}
			// if there exist order id already add it into same list for order id or create a new record with order id
			
		if(!orderPayments.containsKey(orderId)){	
			ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
			orderPayments.put(orderId, arr);
		}
		ArrayList<OrderPayment> listOrderPayment = orderPayments.get(orderId);		
		
		OrderPayment orderpayment = new OrderPayment(orderId,username(),orderName,orderPrice,userAddress,creditCardNo,street,city,state,zipcode,deliverydate);
		listOrderPayment.add(orderpayment);	
			
			// add order details into database
		try
		{	if(session.getAttribute("usertype").equals("retailer"))
			{
				MySqlDataStoreUtilities.insertOrder(orderId,username(),orderName,orderPrice,userAddress,creditCardNo,street,city,state,zipcode,deliverydate);
			}else
				
				{MySqlDataStoreUtilities.insertOrder(orderId,username(),orderName,orderPrice,userAddress,creditCardNo,street,city,state,zipcode,deliverydate);}
		}
		catch(Exception e)
		{
			System.out.println("inside exception file not written properly");
		}	
	}


	public String storeReview(String productname,String producttype,String productmaker,String reviewrating,String reviewdate,String  reviewtext,String reatilerpin,String price,String city,String userage){
	String message=MongoDBDataStoreUtilities.insertReview(productname,username(),producttype,productmaker,reviewrating,reviewdate,reviewtext,reatilerpin,price,city,userage);
		if(!message.equals("Successfull"))
		{ return "UnSuccessfull";
		}
		else
		{
		HashMap<String, ArrayList<Review>> reviews= new HashMap<String, ArrayList<Review>>();
		try
		{
			reviews=MongoDBDataStoreUtilities.selectReview();
		}
		catch(Exception e)
		{
			
		}
		if(reviews==null)
		{
			reviews = new HashMap<String, ArrayList<Review>>();
		}
			// if there exist product review already add it into same list for productname or create a new record with product name
			
		if(!reviews.containsKey(productname)){	
			ArrayList<Review> arr = new ArrayList<Review>();
			reviews.put(productname, arr);
		}
		ArrayList<Review> listReview = reviews.get(productname);		
		Review review = new Review(productname,username(),producttype,productmaker,reviewrating,reviewdate,reviewtext,reatilerpin,price,city,userage);
		listReview.add(review);	
			
			// add Reviews into database
		
		return "Successfull";	
		}
	}


	public HashMap<String, Phone> getPhones(){
			HashMap<String, Phone> hm = new HashMap<String, Phone>();
			hm.putAll(SaxParserDataStore.phones);
			return hm;
	}
	public ArrayList<String> getProducts(){
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, Phone> entry : getPhones().entrySet()){			
			ar.add(entry.getValue().getName());
		}
		return ar;
	}


	public HashMap<String, Laptop> getLaptops(){
			HashMap<String, Laptop> hm = new HashMap<String, Laptop>();
			hm.putAll(SaxParserDataStore.laptops);
			return hm;
	}
	public ArrayList<String> getProductsLaptop(){
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, Laptop> entry : getLaptops().entrySet()){			
			ar.add(entry.getValue().getName());
		}
		return ar;
	}

	public HashMap<String, WearableTech> getWearableTechs(){
		HashMap<String, WearableTech> hm = new HashMap<String, WearableTech>();
		hm.putAll(SaxParserDataStore.wts);
		return hm;
	}
	public ArrayList<String> getProductsWearableTech(){
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, WearableTech> entry : getWearableTechs().entrySet()){			
			ar.add(entry.getValue().getName());
		}
		return ar;
	}

	public HashMap<String, VoiceAsst> getVoiceAsst(){
		HashMap<String, VoiceAsst> hm = new HashMap<String, VoiceAsst>();
		hm.putAll(SaxParserDataStore.vas);
		return hm;
	}
	public ArrayList<String> getProductsVoiceAsst(){
		ArrayList<String> ar = new ArrayList<String>();
		for(Map.Entry<String, VoiceAsst> entry : getVoiceAsst().entrySet()){			
			ar.add(entry.getValue().getName());
		}
		return ar;
	}
}