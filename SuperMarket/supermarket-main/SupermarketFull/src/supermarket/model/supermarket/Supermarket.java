package supermarket.model.supermarket;


import java.util.ArrayList;
import java.util.Random;

import supermarket.exceptions.NotEnoughProduct;
import supermarket.model.cart.Cart;
import supermarket.model.product.Beverage;
import supermarket.model.product.DairyProduct;
import supermarket.model.product.FatType;
import supermarket.model.product.GroceryProduct;
import supermarket.model.product.SugarLevel;

public class Supermarket {
	static ArrayList<GroceryProduct> products;
	static ArrayList<Integer> productsCount= new ArrayList<>();
	static Cart cart;

	public Supermarket() {
		products = new ArrayList<>();
		cart = new Cart();

		// generate some products
		for (int i = 1; i <= 10; i++) {
			// generate a random product
			GroceryProduct product = someRandomProduct(i);

			

			// add the product to the supermarket's list of products
			products.add(product);
			Random r=new Random();
			int random=r.nextInt(6)+5;
			productsCount.add(random);
		}
		System.out.println("The products are: " + products);
	}

	public ArrayList<GroceryProduct> getProducts() {
		return products;
	}

	public Cart getCart() {
		return cart;
	}

	public void buy(GroceryProduct product) throws NotEnoughProduct {
		
		
		int index = products.indexOf(product);
		//System.out.print(productsCount[index]);
		if (productsCount.get(index)==0)
			throw new NotEnoughProduct();
		productsCount.set(index,productsCount.get(index) - 1);
		this.getCart().getProducts().add(product);
	}

	

	public static ArrayList<Integer> getProductsCount() {
		return productsCount;
	}

	/**
	 * Returns a randomly generated {@link GroceryProduct} to be added to the {@link Supermarket}'s list of products
	 * 
	 * @param index
	 *            a number indicating the index of the product being generated, to be used in its name
	 * @return the generated {@link GroceryProduct}
	 */
	private GroceryProduct someRandomProduct(int index) {
		char productType = new char[] { 'D', 'B' }[new Random().nextInt(2)];
		double price = new Random().nextDouble() * 20;
		int discount = new Random().nextInt(6) * 10;

		switch (productType) {
		case 'D':
			FatType fatType = FatType.values()[new Random().nextInt(FatType.values().length)];
			return new DairyProduct("Dairy " + index, price, discount, fatType);
		case 'B':
			SugarLevel sugar = SugarLevel.values()[new Random().nextInt(SugarLevel.values().length)];
			return new Beverage("Beverage " + index, price, discount, sugar);
		}

		return null;
	}


}
