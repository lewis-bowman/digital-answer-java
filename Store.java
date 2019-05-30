/* Lewis Bowman
Answer Digital Java Programming Test */

import java.util.Scanner; //import scanner class

public class Store {

    String code;
    String desc;
    double price;

    public static void main(String args[]) {

        Store productOne;
        Store productTwo;
        Store productThree;

        productOne = new Store();
        productTwo = new Store();
        productThree = new Store();

        productOne.code = "H57";
        productOne.desc = "Tin o Beans";
        productOne.price = 1.23;

        productTwo.code = "C330";
        productTwo.desc = "Fruity Drink";
        productTwo.price = 0.54;

        productThree.code = "BR7";
        productThree.desc = "Sliced Loaf";
        productThree.price = 1.54;

        String offerOne = "Half Price";
        String offerTwo = "3 for 1.00";
        String offerThree = "BOGOF";

        System.out.println("Product Code" + "\t" + "Description" + "\t" + "Price"); //table showing initial products
        System.out.println(productOne.code + "\t" + "\t" + productOne.desc + "\t" + productOne.price + "\t" + offerOne);
        System.out.println(productTwo.code + "\t" + "\t" + productTwo.desc + "\t" + productTwo.price + "\t" + offerTwo);
        System.out.println(productThree.code + "\t" + "\t" + productThree.desc + "\t" + productThree.price + "\t" + offerThree);
        System.out.println("\n");

        System.out.println("Total Savings Per Offer"); //user input to calculate money saved in offers
        
        Scanner halfPriceOffer = new Scanner(System.in);
        try {
            System.out.println(offerOne + "\t" + "Enter number of Beans purchased: "); //user enters number of beans purchased

            int amount = halfPriceOffer.nextInt(); //entry on this line
            
            double paid = (amount * productOne.price) / 2; //calculate cost of x tins purchased at half price
            System.out.println("You have paid " + paid + "which would have normally cost you " + productOne.price * amount);
            System.out.println("You have saved " + paid); //paid value same as cost saved
        } finally {
            halfPriceOffer.close();
        }
       
        Scanner multipleOffer = new Scanner(System.in); //3 for 1.00 offer
        try {
            System.out.println(offerTwo + "\t" + "Enter number of drinks purchased: "); //user enters number of drinks purchased
            
            int amount = multipleOffer.nextInt(); //entry on this line
            
            if (amount % 3 == 0) { //if divisible by three, offer available
                int offerPrice = amount / 3;
                double saving = (amount * productTwo.price) - offerPrice; //amount saved compared to offer
                
                System.out.println("You have paid " + offerPrice + " which has saved you " + saving); //feedback to user
            } else if (amount < 3) { //if less than three drinks bought
                double belowOffer = amount * productTwo.price; //no offer available
                
                System.out.println("You have paid " + belowOffer + " which has saved you nothing."); //feedback to user
            } else { //if more than three, but not divisible by three
                int fullOffer = amount / 3; //calculates amount available for offer
                int remainder = amount % 3; //calculates amount purchased outside of offer (expect 1 or 2)
                double fullPaid = fullOffer + (remainder * productTwo.price); //total of items in offer and those excluded
                double fullSaving = (amount * productTwo.price) - fullPaid; //savings on paying for each individual item
                System.out.println("You have paid " + fullPaid + " which has saved you " + fullSaving); //feedback to user
            }
        } finally {
            multipleOffer.close();
        }

        Scanner bogOfOffer = new Scanner(System.in); //BOGOF offer
        try {
            System.out.println(offerThree + "\t" + "Enter number of loaves purchased: "); //user enters number of loaves purchased

            int amount = bogOfOffer.nextInt(); //entry on this line

            if (amount < 2) { //only one purchased, so no offer applies
                
                System.out.println("You have paid " + amount * productThree.price + " , why not buy another for free?");
            } else if (amount % 2 == 0) { //multiple of two purchased, essentially half price
                double bogofOffer = (amount / 2) * productThree.price;
                double saving = (amount * productThree.price) - bogofOffer;

                System.out.println("You have paid " + bogOfOffer + " which has saved you " + saving); //feedback to user
            } else {
                int fullOffer = amount / 2; //calculates amount available for offer
                int remainder = amount % 2; //calculates amount outside of offer (expect 1)
                double fullPaid = (fullOffer + remainder) * productThree.price; //total payable on BOGOF offer with excess
                double saving = (amount * productThree.price) - fullPaid;

                System.out.println("You have paid " + fullPaid + " which has saved you " + saving); //feedback to user
            }
        } finally {
            bogOfOffer.close();
        }

        Scanner productFour = new Scanner(System.in); //scanner to allow user input for new products
        try {
            System.out.println("Enter Product Code, Description & Price: ");
        
            String code = productFour.nextLine(); //enter product code
            String desc = productFour.nextLine(); //enter product description
            double price = productFour.nextDouble(); //enter product price

            System.out.println("New Product - " + code + "\t" + desc + "\t" + price); //feedback to user with new product
        } finally {
            productFour.close();
        }
                        
    }

}