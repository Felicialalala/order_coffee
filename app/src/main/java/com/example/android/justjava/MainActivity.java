package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
       // Log.v("Main Activity", "Has whipped cream: " + hasWhippedCream);
        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        EditText nameFeild = (EditText)findViewById(R.id.name_field);
        String name = nameFeild.getText().toString();

        int price = calculatePrice(quantity);
        displayMessage(createOrderSummary(price,hasWhippedCream,hasChocolate,name));

    }
    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }
    /**
     * This method creates order summary
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name){
        String orderSummary = "Name: " + name;
        orderSummary += "\nAdd whipped Cream?  " + hasWhippedCream;
        orderSummary += "\nAdd chocolate?  " + hasChocolate;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += "\nTotal: $ " + calculatePrice(quantity);
        orderSummary += "\nThank You!";
        return orderSummary;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    

    /**
     * This method is called when the + button is cliked
     */
        public void increment(View View)   {

        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the - button is cliked
     */
    public void decrement(View View)   {

        quantity = quantity - 1;
        display(quantity);

    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


}