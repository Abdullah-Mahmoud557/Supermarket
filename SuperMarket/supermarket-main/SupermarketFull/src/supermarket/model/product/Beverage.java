package supermarket.model.product;

public class Beverage extends GroceryProduct {
	private SugarLevel sugar;

	public Beverage(String name, double price, int discount, SugarLevel sugar) {
		super(name, price, discount);
		this.sugar = sugar;
	}

	public SugarLevel getSugar() {
		return sugar;
	}
}
