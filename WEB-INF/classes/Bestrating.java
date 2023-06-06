import java.io.*;
public class Bestrating
{
String productname ;
String rating;
String price;


public  Bestrating(String productname,String price, String rating)
{
	
	this.productname = productname ;
    this.rating = rating;
    this.price=price;
}


public String getProductname(){
 return productname;
}
public String getprice(){
    return price;
}

public String getRating () {
 return rating;
}
}