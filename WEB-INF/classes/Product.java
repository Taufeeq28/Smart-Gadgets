import java.util.*;
import java.util.Map;



public class Product {
	private String id;
	private String name;
	private double price;
	private String image;
	private String retailer;
	private String condition;
	private String type;
	private double quantity;
	private String manufacturerRebate;
	private double discount;
	HashMap<String,String> accessories;
	// public Product(String id,String name, double price, String image, String retailer,String condition,String type,double discount){
	// 	this.id=id;
	// 	this.name=name;
	// 	this.price=price;
	// 	this.image=image;
	// 	this.retailer = retailer;
	// 	this.condition=condition;
	// 	this.type=type;
	// 	this.discount = discount;
 //     		this.accessories=new HashMap<String,String>();
	// }
	public Product(String id,String name, double price, String image, String retailer,String condition,String type,double discount,double quantity,String manufacturerRebate){
		this.id=id;
		this.name=name;
		this.price=price;
		this.image=image;
		this.retailer = retailer;
		this.condition=condition;
		this.type=type;
		this.discount = discount;
		this.manufacturerRebate=manufacturerRebate;
		this.quantity=quantity;
     		this.accessories=new HashMap<String,String>();
	}

	// public Product(String id,String name, double price, String image, String retailer,String condition,String type,double discount,double quantity,String manufacturerRebate){
	// 	this.id=id;
	// 	this.name=name;
	// 	this.price=price;
	// 	this.image=image;
	// 	this.retailer = retailer;
	// 	this.condition=condition;
	// 	this.type=type;
	// 	this.discount = discount;
	// 	this.quantity=quantity;
	// 	this.manufacturerRebate=manufacturerRebate;
 //     		this.accessories=new HashMap<String,String>();
	// }
    HashMap<String,String> getAccessories() {
		return accessories;
		}

	public Product(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type =type;
	}


	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public void setAccessories( HashMap<String,String> accessories) {
		this.accessories = accessories;
	}
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
public String getManufacturerRebate() {
		return manufacturerRebate;
	}

	public void setManufacturerRebate(String manufacturerRebate) {
		this.manufacturerRebate = manufacturerRebate;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity= quantity;
	}
	
}
