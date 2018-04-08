/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
        } else {
            Toast.makeText(getApplicationContext(), "You have ordered the maximum number of coffees in this order.",
                    Toast.LENGTH_SHORT).show();
        }
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
        } else {
            Toast.makeText(getApplicationContext(), "Order quantity cannot go below 1.",
                    Toast.LENGTH_SHORT).show();
        }
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // inputs name for order
        EditText nameInput = (EditText) findViewById(R.id.enter_name);
        String nameField = nameInput.getText().toString();
        // checks if user wants whipped cream
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        //checks if user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        //calculates total price of order and creates complete order summary
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, nameField);

        //creates intent and sends the order summary to an email app
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject) + nameField);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            }

//        displayMessage(priceMessage); (NO LONGER NEEDED - REPLACED BY INTENT)
    }

    /**
     * Calculates the price of the order.
     *
     * @param hasWhippedCream is boolean input that stores state of WC checkbox
     * @param hasChocolate is boolean input that stores state of Chocolate checkbox
     * @return total price
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int totalPrice = 5;
        if (hasWhippedCream) {
            totalPrice = totalPrice + 1;
        }
        if (hasChocolate) {
            totalPrice = totalPrice + 2;
        }
        return totalPrice * quantity;
    }

    /**
     * Creates summary of order.
     *@param nameField is name of customer
     * @param price of the order
     * @param hasWhippedCream stores whether or not user wants to add whipped cream
     * @param hasChocolate stores whether or not the user wants to add chocolate
     * @return text summary
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String nameField) {
        String priceMessage = getString(R.string.order_summary_name) + nameField;
        priceMessage += "\n" + getString(R.string.order_summary_whipped_cream) + hasWhippedCream;
        priceMessage += "\n" + getString(R.string.order_summary_chocolate) + hasChocolate;
        priceMessage += "\n" + getString(R.string.order_summary_quantity) + quantity;
        priceMessage += "\n" + getString(R.string.order_summary_price, NumberFormat.getCurrencyInstance().format(price));
        priceMessage += "\n" + getString(R.string.thank_you);
        return (priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

//    /**
//     * This method displays the given text on the screen. (METHOD NO LONGER NEEDED)
//     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }
}
