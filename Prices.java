import java.util.*;

public class Prices {

	public static void main(String args[]){


		HashMap<String, Double> priceList = new HashMap<String, Double>();

		priceList.put("Hammer", 10.99);


		Double hammerPrice = priceList.get("Hammer");


		if(hammerPrice != null){
			
			System.out.println("A hammer costs " + hammerPrice);
		} 
           else{
			System.out.println("We don't sell hammers.");
		
		}
    }
}