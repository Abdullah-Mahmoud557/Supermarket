package supermarket.model.product;

import supermarket.model.cart.Cart;

public abstract class GroceryProduct {
	private String name;
	private double price;
	private int discount;

	public GroceryProduct(String name, double price, int discount) {
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}


	public final double getActualPrice() {
		return price - price * discount / 100;
	}


	

	@Override
	public String toString() {
		return String.format("%s ($%.2f)", name, getActualPrice()); // %.2f limits double values to 2 decimal places
	}
}
