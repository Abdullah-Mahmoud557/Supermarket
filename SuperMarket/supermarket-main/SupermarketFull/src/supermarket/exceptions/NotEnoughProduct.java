package supermarket.exceptions;

public class NotEnoughProduct extends Exception {
	
	public NotEnoughProduct() {
		super();
	}

	public NotEnoughProduct(String msg) {
		super(msg);
	}
}
