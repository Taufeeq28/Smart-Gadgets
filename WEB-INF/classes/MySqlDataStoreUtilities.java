import java.sql.*;
import java.util.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
public class MySqlDataStoreUtilities
{
static Connection conn = null;
static String message;
static Integer ress;
//static String ress1;
public static String getConnection()
{

	try
	{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex","root","root");	
	message="Successfull";
	return message;						
	}
	catch(SQLException e)
	{
		message="unsuccessful";
		  return message;
	}
	catch(Exception e)
	{
		message=e.getMessage();
		return message;
	}
}



public static void Insertproducts() 
{
	
	try{
		
		
		getConnection();
		
		
		String truncatetableacc = "delete from Product_accessories;";
		PreparedStatement pstt = conn.prepareStatement(truncatetableacc);
		pstt.executeUpdate();
		
		String truncatetableprod = "delete from  Productdetails;";
		PreparedStatement psttprod = conn.prepareStatement(truncatetableprod);
		psttprod.executeUpdate();
		
				
		
		String insertProductQurey = "INSERT INTO  Productdetails(ProductType,Id,productName,productPrice,productImage,productManufacturer,productCondition,productDiscount,quantity,manufacturerRebate)" +
		"VALUES (?,?,?,?,?,?,?,?,?,?);";
		for(Map.Entry<String,Accessory> entry : SaxParserDataStore.accessories.entrySet())
		{   
			String name = "accessories";
	        Accessory acc = entry.getValue();
			
			PreparedStatement pst = conn.prepareStatement(insertProductQurey);
			pst.setString(1,name);
			pst.setString(2,acc.getId());
			pst.setString(3,acc.getName());
			pst.setDouble(4,acc.getPrice());
			pst.setString(5,acc.getImage());
			pst.setString(6,acc.getRetailer());
			pst.setString(7,acc.getCondition());
			pst.setDouble(8,acc.getDiscount());
			pst.setDouble(9,acc.getQuantity());
			pst.setString(10,acc.getManufacturerRebate());
			pst.executeUpdate();
			
			
		}
		
		for(Map.Entry<String,Phone> entry : SaxParserDataStore.phones.entrySet())
		{   
	        Phone ph = entry.getValue();
			String name = "phones";
			
						
			
			PreparedStatement pst = conn.prepareStatement(insertProductQurey);
			pst.setString(1,name);
			pst.setString(2,ph.getId());
			pst.setString(3,ph.getName());
			pst.setDouble(4,ph.getPrice());
			pst.setString(5,ph.getImage());
			pst.setString(6,ph.getRetailer());
			pst.setString(7,ph.getCondition());
			pst.setDouble(8,ph.getDiscount());
			pst.setDouble(9,ph.getQuantity());
			pst.setString(10,ph.getManufacturerRebate());
			
			pst.executeUpdate();
			try{
			HashMap<String,String> acc = ph.getAccessories();
			String insertAccessoryQurey = "INSERT INTO  Product_accessories(productName,accessoriesName)" +
			"VALUES (?,?);";
			for(Map.Entry<String,String> accentry : acc.entrySet())
			{
				PreparedStatement pstacc = conn.prepareStatement(insertAccessoryQurey);
				pstacc.setString(1,ph.getId());
				pstacc.setString(2,accentry.getValue());
				pstacc.executeUpdate();
			}
			}catch(Exception et){
				et.printStackTrace();
			}
		}
		for(Map.Entry<String,Laptop> entry : SaxParserDataStore.laptops.entrySet())
		{   
			String name = "laptops";
	        Laptop game = entry.getValue();
			
			PreparedStatement pst = conn.prepareStatement(insertProductQurey);
			pst.setString(1,name);
			pst.setString(2,game.getId());
			pst.setString(3,game.getName());
			pst.setDouble(4,game.getPrice());
			pst.setString(5,game.getImage());
			pst.setString(6,game.getRetailer());
			pst.setString(7,game.getCondition());
			pst.setDouble(8,game.getDiscount());
			pst.setDouble(9,game.getQuantity());
			pst.setString(10,game.getManufacturerRebate());
			pst.executeUpdate();
			
			
		}
		for(Map.Entry<String,WearableTech> entry : SaxParserDataStore.wts.entrySet())
		{   
			String name = "wts";
	        WearableTech wear = entry.getValue();
			
			PreparedStatement pst = conn.prepareStatement(insertProductQurey);
			pst.setString(1,name);
			pst.setString(2,wear.getId());
			pst.setString(3,wear.getName());
			pst.setDouble(4,wear.getPrice());
			pst.setString(5,wear.getImage());
			pst.setString(6,wear.getRetailer());
			pst.setString(7,wear.getCondition());
			pst.setDouble(8,wear.getDiscount());
			pst.setDouble(9,wear.getQuantity());
			pst.setString(10,wear.getManufacturerRebate());
			
			pst.executeUpdate();
			
			
		}

		for(Map.Entry<String,VoiceAsst> entry : SaxParserDataStore.vas.entrySet())
		{   
			String name = "vas";
	        VoiceAsst v = entry.getValue();
			
			PreparedStatement pst = conn.prepareStatement(insertProductQurey);
			pst.setString(1,name);
			pst.setString(2,v.getId());
			pst.setString(3,v.getName());
			pst.setDouble(4,v.getPrice());
			pst.setString(5,v.getImage());
			pst.setString(6,v.getRetailer());
			pst.setString(7,v.getCondition());
			pst.setDouble(8,v.getDiscount());
			pst.setDouble(9,v.getQuantity());
			pst.setString(10,v.getManufacturerRebate());
			
			pst.executeUpdate();
			
			
		}
		
	}catch(Exception e)
	{
  		e.printStackTrace();
	}
} 

public static HashMap<String,Phone> getPhones()
{	
	HashMap<String,Phone> hm=new HashMap<String,Phone>();
	try 
	{
		getConnection();
		
		String selectPhone="select * from  Productdetails where ProductType=?";
		PreparedStatement pst = conn.prepareStatement(selectPhone);
		pst.setString(1,"phones");
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	Phone con = new Phone(rs.getString("productName"),rs.getDouble("productPrice"),
			rs.getString("productImage"),rs.getString("productManufacturer"),
			rs.getString("productCondition"),rs.getDouble("productDiscount"),
			rs.getDouble("quantity"),rs.getString("manufacturerRebate"));
				hm.put(rs.getString("Id"), con);
				con.setId(rs.getString("Id"));
				
				try
				{
				String selectaccessory = "Select * from Product_accessories where productName=?";
				PreparedStatement pstacc = conn.prepareStatement(selectaccessory);
				pstacc.setString(1,rs.getString("Id"));
				ResultSet rsacc = pstacc.executeQuery();
				
				HashMap<String,String> acchashmap = new HashMap<String,String>();
				while(rsacc.next())
				{    
					if (rsacc.getString("accessoriesName") != null){
					
					 acchashmap.put(rsacc.getString("accessoriesName"),rsacc.getString("accessoriesName"));
					 con.setAccessories(acchashmap);
					}
					 
				}					
				}catch(Exception e)
				{
						e.printStackTrace();
				}
		}
	}
	catch(Exception e)
	{
	}
	return hm;			
}

public static HashMap<String,Laptop> getLaptops()
{	
	HashMap<String,Laptop> hm=new HashMap<String,Laptop>();
	try 
	{
		getConnection();
		
		String selectLaptop="select * from  Productdetails where ProductType=?";
		PreparedStatement pst = conn.prepareStatement(selectLaptop);
		pst.setString(1,"laptops");
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	Laptop lp = new Laptop(rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"),rs.getDouble("quantity"),rs.getString("manufacturerRebate"));
				hm.put(rs.getString("Id"), lp);
				lp.setId(rs.getString("Id"));
				
		}
	}			
	catch(Exception e)
	{
	}
	return hm;			
}

public static HashMap<String,WearableTech> getWearableTechs()
{	
	HashMap<String,WearableTech> hm=new HashMap<String,WearableTech>();
	try 
	{
		getConnection();
		
		String selectWearableTech="select * from  Productdetails where ProductType=?";
		PreparedStatement pst = conn.prepareStatement(selectWearableTech);
		pst.setString(1,"wts");
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	WearableTech wtech = new WearableTech(rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"),rs.getDouble("quantity"),rs.getString("manufacturerRebate"));
				hm.put(rs.getString("Id"), wtech);
				wtech.setId(rs.getString("Id"));
				
				
		}
	}
	catch(Exception e)
	{
	}
	return hm;			
}

public static HashMap<String,VoiceAsst> getVoiceAsst()
{	
	HashMap<String,VoiceAsst> hm=new HashMap<String,VoiceAsst>();
	try 
	{
		getConnection();
		
		String selectVoiceAsst="select * from  Productdetails where ProductType=?";
		PreparedStatement pst = conn.prepareStatement(selectVoiceAsst);
		pst.setString(1,"vas");
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	VoiceAsst vasst = new VoiceAsst(rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"),rs.getDouble("quantity"),rs.getString("manufacturerRebate"));
				hm.put(rs.getString("Id"), vasst);
				vasst.setId(rs.getString("Id"));
				
				
		}
	}
	catch(Exception e)
	{
	}
	return hm;			
}

public static HashMap<String,Accessory> getAccessories()
{	
	HashMap<String,Accessory> hm=new HashMap<String,Accessory>();
	try 
	{
		getConnection();
		
		String selectAcc="select * from  Productdetails where ProductType=?";
		PreparedStatement pst = conn.prepareStatement(selectAcc);
		pst.setString(1,"accessories");
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	Accessory acc = new Accessory(rs.getString("productName"),rs.getDouble("productPrice"),rs.getString("productImage"),rs.getString("productManufacturer"),rs.getString("productCondition"),rs.getDouble("productDiscount"),rs.getDouble("quantity"),rs.getString("manufacturerRebate"));
				hm.put(rs.getString("Id"), acc);
				acc.setId(rs.getString("Id"));

		}
	}
	catch(Exception e)
	{
	}
	return hm;			
}
public static TreeMap getDailySales()
	{

		TreeMap<String,String> map= new TreeMap<String,String>();
		String query = "select deliverydate,SUM(OrderPrice) AS quantity from customerorders group by deliverydate ORDER BY CAST(deliverydate As DATETIME);";
		try
		{
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Calendar cal = Calendar.getInstance();
				String DATE_FORMAT = "MM/dd/yyyy"; 
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				java.util.Date deliveryDate = sdf.parse(rs.getString("deliveryDate"));
				cal.setTime(deliveryDate);
				cal.add(Calendar.DATE, -14);
				java.util.Date date = cal.getTime();
				String purchaseDate = sdf.format(date);
				map.put(purchaseDate,rs.getString("quantity"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
public static String addproducts(String producttype,String productId,String productName,double productPrice,String productImage,String productManufacturer,String productCondition,double productDiscount,String prod)
{
	String msg = "Product is added successfully";
	try{
		
		getConnection();
		String addProductQurey = "INSERT INTO  Productdetails(ProductType,Id,productName,productPrice,productImage,productManufacturer,productCondition,productDiscount,quantity,manufacturerRebate)" +
		"VALUES (?,?,?,?,?,?,?,?,?,?);";
		   
			String name = producttype;
	        			
			PreparedStatement pst = conn.prepareStatement(addProductQurey);
			pst.setString(1,name);
			pst.setString(2,productId);
			pst.setString(3,productName);
			pst.setDouble(4,productPrice);
			pst.setString(5,productImage);
			pst.setString(6,productManufacturer);
			pst.setString(7,productCondition);
			pst.setDouble(8,productDiscount);
			pst.setDouble(9,100);
			pst.setString(10,"Yes");
			
			pst.executeUpdate();
			try{
				if (!prod.isEmpty())
				{
					String addaprodacc =  "INSERT INTO  Product_accessories(productName,accessoriesName)" +
					"VALUES (?,?);";
					PreparedStatement pst1 = conn.prepareStatement(addaprodacc);
					pst1.setString(1,prod);
					pst1.setString(2,productId);
					pst1.executeUpdate();
					
				}
			}catch(Exception e)
			{
				msg = "Erro while adding the product";
				e.printStackTrace();
		
			}
			
			
		
	}
	catch(Exception e)
	{
		msg = "Error while adding the product";
		e.printStackTrace();
		
	}
	return msg;
}
public static String updateproducts(String producttype,String productId,String productName,double productPrice,String productImage,String productManufacturer,String productCondition,double productDiscount)
{ 
    String msg = "Product is updated successfully";
	try{
		
		getConnection();
		String updateProductQurey = "UPDATE Productdetails SET productName=?,productPrice=?,productImage=?,productManufacturer=?,productCondition=?,productDiscount=? where Id =?;" ;
		
		   
				        			
			PreparedStatement pst = conn.prepareStatement(updateProductQurey);
			
			pst.setString(1,productName);
			pst.setDouble(2,productPrice);
			pst.setString(3,productImage);
			pst.setString(4,productManufacturer);
			pst.setString(5,productCondition);
			pst.setDouble(6,productDiscount);
			pst.setString(7,productId);
			pst.executeUpdate();
			
			
		
	}
	catch(Exception e)
	{
		msg = "Product cannot be updated";
		e.printStackTrace();
		
	}
 return msg;	
}

public static String deleteproducts(String productId)
{   String msg = "Product is deleted successfully";
	try
	{
		
		getConnection();
		String deleteproductsQuery ="Delete from Productdetails where Id=?";
		PreparedStatement pst = conn.prepareStatement(deleteproductsQuery);
		pst.setString(1,productId);
		
		pst.executeUpdate();
	}
	catch(Exception e)
	{
			msg = "Proudct cannot be deleted";
	}
	return msg;
}



public static void deleteOrder(int orderId,String orderName)
{
	try
	{
		
		getConnection();
		String deleteOrderQuery ="Delete from customerorders where OrderId=? and orderName=?";
		PreparedStatement pst = conn.prepareStatement(deleteOrderQuery);
		pst.setInt(1,orderId);
		pst.setString(2,orderName);
		pst.executeUpdate();
	}
	catch(Exception e)
	{
			
	}
}

public static void insertOrder(int orderId,String userName,String orderName,double orderPrice,String userAddress,String creditCardNo,String street,String city,String state,String zipcode,String deliverydate)
{
	try
	{
	
		getConnection();
		String insertIntoCustomerOrderQuery = "INSERT INTO customerOrders(OrderId,UserName,OrderName,OrderPrice,userAddress,creditCardNo,street,city,state,zipcode,deliverydate) "
		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?);";	
			
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerOrderQuery);
		//set the parameter for each column and execute the prepared statement
		pst.setInt(1,orderId);
		pst.setString(2,userName);
		pst.setString(3,orderName);
		pst.setDouble(4,orderPrice);
		pst.setString(5,userAddress);
		pst.setString(6,creditCardNo);
		pst.setString(7,street);
		pst.setString(8,city);
		pst.setString(9,state);
		pst.setString(10,zipcode);
pst.setString(11,deliverydate);
		pst.execute();
	} 
	catch(Exception e)
	{
	
	}		
}


				
public static HashMap<Integer, ArrayList<OrderPayment>> selectOrder()
{	

	HashMap<Integer, ArrayList<OrderPayment>> orderPayments=new HashMap<Integer, ArrayList<OrderPayment>>();
		
	try
	{					

		getConnection();
        //select the table 
		String selectOrderQuery ="select * from customerorders";			
		PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
		ResultSet rs = pst.executeQuery();	
		ArrayList<OrderPayment> orderList=new ArrayList<OrderPayment>();
		while(rs.next())
		{
			if(!orderPayments.containsKey(rs.getInt("OrderId")))
			{	
				ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
				orderPayments.put(rs.getInt("orderId"), arr);
			}
			ArrayList<OrderPayment> listOrderPayment = orderPayments.get(rs.getInt("OrderId"));		
			System.out.println("data is"+rs.getInt("OrderId")+orderPayments.get(rs.getInt("OrderId")));

			//add to orderpayment hashmap
			OrderPayment order= new OrderPayment(rs.getInt("OrderId"),rs.getString("userName"),rs.getString("orderName"),rs.getDouble("orderPrice"),rs.getString("userAddress"),rs.getString("creditCardNo"),rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getString("zipcode"),rs.getString("deliverydate"));
			listOrderPayment.add(order);
			}
				
					
	}
	catch(Exception e)
	{
		
	}
	return orderPayments;
}


public static void insertUser(String username,String password,String repassword,String usertype)
{
	try
	{	

		getConnection();
		String insertIntoCustomerRegisterQuery = "INSERT INTO Registration(username,password,repassword,usertype) "
		+ "VALUES (?,?,?,?);";	
				
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
		pst.setString(1,username);
		pst.setString(2,password);
		pst.setString(3,repassword);
		pst.setString(4,usertype);
		pst.execute();
	}
	catch(Exception e)
	{
	
	}	
}

public static HashMap<String,User> selectUser()
{	
	HashMap<String,User> hm=new HashMap<String,User>();
	try 
	{
		getConnection();
		Statement stmt=conn.createStatement();
		String selectCustomerQuery="select * from  Registration";
		ResultSet rs = stmt.executeQuery(selectCustomerQuery);
		while(rs.next())
		{	User user = new User(rs.getString("username"),rs.getString("password"),rs.getString("usertype"));
				hm.put(rs.getString("username"), user);
		}
	}
	catch(Exception e)
	{
	}
	return hm;			
}

public static HashMap<Integer, ArrayList<OrderCount>> selectOrderCount()
{	

	HashMap<Integer, ArrayList<OrderCount>> orderCounts=new HashMap<Integer, ArrayList<OrderCount>>();
		
	try
	{					

		getConnection();
        //select the table 
		String selectOrderQuery ="select * from customerorders";			
		PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
		ResultSet rs = pst.executeQuery();	
		ArrayList<OrderCount> orderList=new ArrayList<OrderCount>();
		while(rs.next())
		{
			if(!orderCounts.containsKey(rs.getInt("OrderId")))
			{	
				ArrayList<OrderCount> arr = new ArrayList<OrderCount>();
				orderCounts.put(rs.getInt("OrderId"), arr);
			}
			ArrayList<OrderCount> listOrderCount = orderCounts.get(rs.getInt("OrderId"));		
			//System.out.println("data is"+rs.getInt("OrderId")+orderPayments.get(rs.getInt("OrderId")));

			//add to orderpayment hashmap
			OrderCount order= new OrderCount(rs.getString("orderName"),rs.getDouble("orderPrice"));
			listOrderCount.add(order);
					
		}
				
					
	}
	catch(Exception e)
	{
		
	}
	return orderCounts;
}
public static ArrayList<Integer> Findcount()
{
	ArrayList<Integer> list2 = new ArrayList<Integer>();
	try{
		getConnection();
		Statement stmt = conn.createStatement();
		String query = "Select orderName,count(*) from customerorders group by orderName";
		ResultSet rs = stmt.executeQuery(query);
		//ArrayList<Integer> ress = new ArrayList<Integer>();
		while(rs.next())
		{
			//ArrayList<Integer> ress = new ArrayList<Integer>();
			list2.add(rs.getInt(2));
		}
		
	}
	catch(Exception e)
	{

	}
	return list2;
}
public static ArrayList<Double> Findcountprice()
{
	ArrayList<Double> list2 = new ArrayList<Double>();
	try{
		getConnection();
		Statement stmt = conn.createStatement();
		String query = "Select orderName,orderPrice from customerorders group by orderName";
		ResultSet rs = stmt.executeQuery(query);
		//ArrayList<Integer> ress = new ArrayList<Integer>();
		while(rs.next())
		{
			//ArrayList<Integer> ress = new ArrayList<Integer>();
			list2.add(rs.getDouble(2));
		}
		
	}
	catch(Exception e)
	{

	}
	return list2;
}


public static ArrayList<String> Finddeliverydate()
{
	ArrayList<String> list2 = new ArrayList<String>();
	try{
		getConnection();
		Statement stmt = conn.createStatement();
		String query = "Select orderName,deliverydate from customerorders group by orderName";
		ResultSet rs = stmt.executeQuery(query);
		//ArrayList<Integer> ress = new ArrayList<Integer>();
		while(rs.next())
		{
			//ArrayList<Integer> ress = new ArrayList<Integer>();
			list2.add(rs.getString(2));
		}
		
	}
	catch(Exception e)
	{

	}
	return list2;
}





public static HashMap<String,Product> getAllProducts(){

	HashMap<String,Product> hm=new HashMap<String,Product>();
	try 
	{
		//System.out.print("Inside getTrackers");
		getConnection();
		
		String selecttrackers="select * from  Productdetails";
		PreparedStatement pst = conn.prepareStatement(selecttrackers);
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	
				Product trk = new Product(rs.getString("Id"),rs.getString("productName"),rs.getDouble("productPrice"),
			rs.getString("productImage"),rs.getString("productManufacturer"),
			rs.getString("productCondition"),rs.getString("productType"),rs.getDouble("productDiscount"),
			rs.getDouble("quantity"),rs.getString("manufacturerRebate"));
							hm.put(rs.getString("Id"), trk);
				//trk.setId(rs.getString("Id"));

		}
	}
	catch(Exception e)
	{
	}
	return hm;		

}

public static void Updateproductquantity(){
	try
	{	

		getConnection();

		Map<OrderItem,String> map = new HashMap<OrderItem,String>();
		map = MySqlDataStoreUtilities.getAllProductSold();
		if(map!=null){
			Iterator it = map.entrySet().iterator();
					while(it.hasNext())
					{
						Map.Entry entry = (Map.Entry) it.next();
						OrderItem key = (OrderItem) entry.getKey();
						String value = (String) entry.getValue();
						double d = Double.parseDouble(value);
						double qnew= 100-d;

						String updateProductQuantityQurey = "UPDATE Productdetails SET quantity=? where productName =?;" ;
		
		   
				        			
						PreparedStatement pst = conn.prepareStatement(updateProductQuantityQurey);
						
						
						pst.setDouble(1,qnew);
						pst.setString(2,key.getName());
						pst.executeUpdate();

						//pw.println("<tr><td style='font-size:12px;text-align:center'>" +key.getName()+ " </td><td style='font-size:12px;text-align:center'>$" +key.getPrice()+ "</td><td style='font-size:12px;text-align:center'>" +value+ "</td><td style='font-size:12px;text-align:center'>$" + key.getPrice() * Float.parseFloat(value) + "</td></tr>");
					}
		}
		
	}
	catch(Exception e)
	{
	
	}	
}
public static HashMap<String,Product> getAllManufactureRebateProducts(){

	HashMap<String,Product> hm=new HashMap<String,Product>();
	try 
	{
		getConnection();
		
		String selecttrackers="select * from  Productdetails where manufacturerRebate=?";
		PreparedStatement pst = conn.prepareStatement(selecttrackers);
		pst.setString(1,"Yes");
		ResultSet rs = pst.executeQuery();
	
		while(rs.next())
		{	
				Product trk = new Product(rs.getString("Id"),rs.getString("productName"),rs.getDouble("productPrice"),
			rs.getString("productImage"),rs.getString("productManufacturer"),
			rs.getString("productCondition"),rs.getString("productType"),rs.getDouble("productDiscount"),
			rs.getDouble("quantity"),rs.getString("manufacturerRebate"));
				hm.put(rs.getString("Id"), trk);
				//trk.setId(rs.getString("Id"));

		}
	}
	catch(Exception e)
	{
	}
	return hm;		

}

public static Map getAllProductSold()
	{

		getConnection();
		Map<OrderItem,String> map= new HashMap<OrderItem,String>();
		String query = "select *,count(*) AS quantity FROM customerorders GROUP BY orderName ORDER BY orderName ASC ;";
		try
		{
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			OrderItem order=null;
			while(rs.next())
			{
				order = new OrderItem();
				order.setName(rs.getString("orderName"));
				order.setPrice(rs.getDouble("orderPrice"));
				map.put(order,rs.getString("quantity"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
public static ArrayList<String> Findcountname()
{
	//ArrayList<String> list;
	ArrayList<String> list = new ArrayList<String>();
	try{
		getConnection();
		Statement stmt = conn.createStatement();
		String query = "Select orderName,count(*) from customerorders group by orderName";
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next())
		{
			//ArrayList<String> ress1 = new ArrayList<String>();
			list.add(rs.getString(1));

		}
		
	}
	catch(Exception e)
	{

	}
	return list;
}
	
}	