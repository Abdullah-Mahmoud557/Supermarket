package supermarket.model.product;

public class DairyProduct extends GroceryProduct {
	private FatType fatType;

	public DairyProduct(String name, double price, int discount, FatType fatType) {
		super(name, price, discount);
		this.fatType = fatType;
	}

	public FatType getFat() {
		return fatType;
	}
}
