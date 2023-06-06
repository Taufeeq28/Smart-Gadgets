import java.io.*;
public class Mostsold
{
String productname ;
String count;
String price;


public  Mostsold(String productname,String count)
{
	
	this.productname = productname;
    //this.price=price;
    this.count = count;
}


public String getProductname(){
 return productname;
}
public String getPrice(){
    return price;
}

public String getCount () {
 return count;
}
}