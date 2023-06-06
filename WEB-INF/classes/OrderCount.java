import java.io.IOException;
import java.io.*;


public class OrderCount implements Serializable{
	
	private String orderName;
	private double orderPrice;
	private int count1;
	public OrderCount(String orderName,double orderPrice){
		
		
		this.orderName=orderName;
		//this.count1=count1;
	 	this.orderPrice=orderPrice;
	 }

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public int getOrderCount() {
		return count1;
	}

	public void setOrderCount(int count1) {
		this.count1 = count1;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

}