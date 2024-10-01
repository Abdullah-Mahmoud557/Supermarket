package supermarket.model.cart;

import java.util.ArrayList;

import supermarket.model.product.GroceryProduct;


public class Cart  {
	private ArrayList<GroceryProduct> products;


	public Cart() {
		products = new ArrayList<>();
	}

	public ArrayList<GroceryProduct> getProducts() {
		return products;
	}

	

	public double getTotal() {
		double total = 0;
		for (GroceryProduct product : products) {
			total += product.getActualPrice();
		}
		return total;
	}


}
