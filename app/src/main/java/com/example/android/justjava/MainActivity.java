package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        int totalPrice = calculatePrice(quantity, hasWhippedCream,hasChocolate);
        String message = createOrderSummary(totalPrice, hasWhippedCream,hasChocolate,name);
        displayMessage(message);
//      mail intent
//        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
//        emailIntent.setData(Uri.parse("mailto"));
//        emailIntent.setType("text/plain");
//        emailIntent.putExtra(Intent.EXTRA_EMAIL, "Starbucks@gmail.com");
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Just java order for" + name);
//        emailIntent.putExtra(Intent.EXTRA_TEXT,message );
//        startActivity(Intent.createChooser(emailIntent,"Download a mail app first"));
    }
    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity, boolean hasWhippedCream, boolean hasChocolate) {
        //basic price
        int price = 5;
        //add $1 if whipped cream added
        if(hasWhippedCream) price += 1;
        //add $2 if chocolate added
        if(hasChocolate)    price += 2;
        int totalPrice = quantity * price;
        return totalPrice;
    }
    /**
     * This method creates order summary
     */
    public String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name){
        String orderSummary = "Name: " + name;
        int totalPrice = calculatePrice(quantity,hasWhippedCream,hasChocolate);
        orderSummary += "\nAdd whipped Cream?  " + hasWhippedCream;
        orderSummary += "\nAdd chocolate?  " + hasChocolate;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += "\nTotal: $ " + totalPrice;
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
        if(quantity >= 100 ) {
            //show a toast message
            Toast.makeText(this,"You cannot have more than 100 cups of coffee!",Toast.LENGTH_SHORT).show();
            return;
        }
            else
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the - button is cliked
     */
    public void decrement(View View)   {
        if(quantity <= 1)   {
            Toast.makeText(this,"You cannot have less than 1 cup of coffee!",Toast.LENGTH_SHORT).show();
            return;
        }
            else
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