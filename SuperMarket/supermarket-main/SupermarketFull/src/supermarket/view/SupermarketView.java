package supermarket.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class SupermarketView{

    private GridPane productsGrid;
    private TextArea txtCart;
    //only front end no launching 

    public SupermarketView() {
        // Set the title of the window (not applicable in JavaFX)
        // Set the size and location of the window (not applicable in JavaFX)

        // Create a grid pane to hold the products buy buttons
    	productsGrid = new GridPane();
    	productsGrid.setPadding(new Insets(10));
    	//gaps between the buttons on grid
    	productsGrid.setHgap(10);
    	productsGrid.setVgap(10);

        // Create a text area to hold the text of the cart
        txtCart = new TextArea("Cart:\n\n");
        txtCart.setEditable(false);
       //fixed width
        txtCart.setPrefWidth(200);
    }
    
    //to help us update el front end
    public HBox placeUIComponents(){
    	HBox view = new HBox();
    	view.getChildren().addAll(productsGrid,txtCart);
    	return view;
    }

    public Button addProduct(String btnText) {
    	
    	Button btn = new Button(btnText);
    	btn.setPrefWidth(250);
    	btn.setPrefHeight(250);
    	// Get the next row and col this button must be placed at
    	//location of buttons not hard coded
    	//creating  a 3 by x grid
    	int row = productsGrid.getChildren().size()/3;
    	int col = productsGrid.getChildren().size()%3;
        // Add the product button to the grid pane
        productsGrid.add(btn, col, row);
        return btn;
    }
    
    public void updateButton(Button btn, String btnText){
    	btn.setText(btnText);
    }

    public void updateCart(ArrayList<String> products, double total) {
        // Update the text of the cart
        StringBuilder cartText = new StringBuilder();
        cartText.append("Cart:\n");
        cartText.append("'''''\n");
        for (String product : products) {
            cartText.append("- ").append(product).append("\n");
        }
        if (!products.isEmpty()) {
            cartText.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        }
        cartText.append(String.format("\nTotal: $%.2f", total));
        txtCart.setText(cartText.toString());
    }
}
