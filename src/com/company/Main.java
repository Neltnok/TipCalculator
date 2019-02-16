// You are going to create a tip calculator program.
// You will have the user enter the cost of items, and keep entering items
// until the user enters 0.  At that point, you will display the total cost,
// taxes (assume 2.5 percent or .025), total with taxes, and recommend
// a 17.5% tip. Display appropriately for currency,
// with dollar signs and rounding to two decimal places.


// Pseudo code in source
// set up a loop to collect the line item amounts on the bill
// prompt the user for input and add the input to a running total
// terminate the loop when the user enters 0

// initialize the NumberFormat object
// set format to include commas every 3 digits
// set format to limit to two places past the decimal
// set format to extend fractional digits to always be two places past decimal

// calculate the tax as 2.5% of the running total
// add the tax to the total as the grand total
// calculate the tip amount as 17.5% of the grand total.
// create the strings using the NumberFormat object for total, tax, grand total and tip
// display the total, tax, grand total and tip amount to the user



package com.company;
// import for the scanner package
import java.sql.SQLOutput;
import java.util.Scanner;

// import for formatting package
import java.text.NumberFormat;



public class Main {

    // create an object of type Scanner to manage user input
    static Scanner scanner = new Scanner(System.in);

// helper method
// method getInput
// requirements: caller must accept a double return type
// results: displays a prompt string and accepts a double as a response

    private static double getInputDouble(String prompt){
        // local variable to return
        double doubleReturn = 0.0;

        System.out.print(prompt + " ");
        doubleReturn = scanner.nextDouble();

        return doubleReturn;
    }
//*****************************************************************************


    // create a variable to handle individual items on the resturant bill
    static double billItem = 0.0;

    // create a variable to handle total amount in the resturant bill
    static double totalAmount = 0.0;



    public static void main(String[] args) {
    // define a local variable to keep track of the number of items
    int noOfItems = 0;

    // create a variable for the tax amount
        double taxAmount = 0.0;

    // add a welcome message
        System.out.println("Welcome to Tipcalc");
        System.out.println("Enter the item amounts on your bill below and hit 0 when done");
	// set up a loop to allow the operator to enter amounts

        do {
            // get the user to enter the line items on the bill
            billItem = getInputDouble("Amount for Item # " + noOfItems + " $");
            // increment the line item count
            noOfItems++;

            // add the billItem to the running total
            totalAmount+= billItem;
        }
        while(billItem != 0);

        // initialize numberFormat
        NumberFormat nf = NumberFormat.getNumberInstance();
        // set format to include commas every 3 digits
        nf.setGroupingUsed(true);
        // set format to limit to two places past the decimal
        nf.setMaximumFractionDigits(2);
        // set format to extend fractional digits to always be two places past decimal
        nf.setMinimumFractionDigits(2);

        // skip a line here to make the output more readable
        System.out.println();

        // format the total amount
        String total = nf.format(totalAmount);
        // print out the line item total for the user
        System.out.println("Your line item total is $" + total);

        // calculate the tax amount
        taxAmount = totalAmount * 0.025;
        // format the tax amount
        String tax  = nf.format(taxAmount);
        // print out the tax amount
        System.out.println("Your tax amount is $" + tax);

        // format the grand total
        String grandTotal = nf.format(totalAmount + taxAmount);

        // print out the grand total
        System.out.println("Your total bill amount is $" + grandTotal);


        // format the recommended tip
        String tip = nf.format( 0.175 * ( totalAmount + taxAmount));


        // print out the recommended tip
        System.out.println("Your recommended tip is $" + tip );



    }
}
