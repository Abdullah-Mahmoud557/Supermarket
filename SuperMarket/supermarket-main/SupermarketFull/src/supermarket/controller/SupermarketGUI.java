package supermarket.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;









import java.util.ArrayList;

import supermarket.exceptions.NotEnoughProduct;
import supermarket.model.cart.Cart;
import supermarket.model.product.GroceryProduct;
import supermarket.model.supermarket.Supermarket;
import supermarket.view.SupermarketView;

//controller must extend application
public class SupermarketGUI extends Application {

	//back end
    private Supermarket supermarket;
    
    //front end 
    private SupermarketView supermarketView;

    @Override
    public void start(Stage primaryStage) {
        // Initialize the supermarket
        supermarket = new Supermarket();

        // Initialize the SupermarketView
        supermarketView = new SupermarketView();
        HBox view = supermarketView.placeUIComponents();

        // Create buttons for each product in the supermarket
        for (GroceryProduct product : supermarket.getProducts()) {
            int index = supermarket.getProducts().indexOf(product);
            Button productBtn = supermarketView.addProduct(product.toString() + " count: " + Supermarket.getProductsCount().get(index));
            productBtn.setOnMouseClicked(new EventHandler<Event>(){

				@Override
				public void handle(Event event) {
					try {
			            // Invoke the buy method on the product
			            supermarket.buy(product);
			            // Update the button text
			            supermarketView.updateButton(productBtn, product.toString() + " count: " + Supermarket.getProductsCount().get(index));
			            // Call the onCartUpdated method
			            onCartUpdated(supermarket.getCart());
		
			        } catch (NotEnoughProduct e) {
			            // Show a message dialog indicating the product is out of stock
			        	//need to be shown as front end not in console
			        	displayAlert("Not Enough Product!","Sorry, we ran out of this product.");
			            
			        }
					
				}
            	
            	
            	
            });
            
        }

        // Set the VBox as the root of the scene
        Scene scene = new Scene(view, 1000, 500);

        // Set the scene to the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void onCartUpdated(Cart cart) {
        // Create a list of products info
        ArrayList<String> products = new ArrayList<>();
        for (GroceryProduct product : cart.getProducts()) {
            products.add(product.toString());
        }
        // Set the list along with the total to the supermarketView's updateCart method
        supermarketView.updateCart(products, cart.getTotal());
    }
    
    // Method to display a custom alert
    private void displayAlert(String title, String message) {
        Stage alertStage = new Stage();
        alertStage.setTitle(title);

        Label label = new Label(message);
        Button closeButton = new Button("Continue Shopping");
        //closing is predefined
        closeButton.setOnAction(event -> alertStage.close());

        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(closeButton);

        Scene scene = new Scene(pane, 500, 100);
        alertStage.setScene(scene);
        alertStage.show();
    }

    public static void main(String[] args) {
        // Launch the application
        launch(args);
    }
}
