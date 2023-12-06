import java.util.Scanner;

public class Logic {

    private Scanner scan;
    private Customer customer;
    private Cart cart;

    public Logic() {
        scan = new Scanner(System.in);
        customer = new Customer();
        int constructor = (int) (Math.random() * 3) + 1;
        if (constructor == 1) {
            cart = new Cart();
        } else if (constructor == 2) {
            cart = new Cart(0.08875);
        } else {
            cart = new Cart(0.08875, 4);
        }
    }

    public void start() {
        welcome();
        selection();
        checkout();
    }

    private void welcome() {
        System.out.println("Welcome to the delivery app!");
        System.out.println("Now you can start ordering!");
        System.out.println();
    }

    private void selection() {
        System.out.println("Choose an item from our selection:");
        System.out.println("*Pencils* | $4 per pack\n*Printer Paper* | $8 per ream\n*Erasers* | $2 per pack");
        String response = "";
        while (response.length() == 0) {
            System.out.print("Choose your item: ");
            response = scan.nextLine();
        }
        customer.setItems(response);
        int purchasing = -1;
        while (purchasing < 0) {
            System.out.print("How much of this item do you want to purchase: ");
            purchasing = scan.nextInt();
            scan.nextLine();
        }
        customer.setNumOfItems(purchasing);
        cart.calculateSubTotal(customer.getItems(), customer.getNumOfItems());
        System.out.print("Do you want to see a receipt? y/n: ");
        String receipt = scan.nextLine();
        if (receipt.equals("y")) {
            System.out.println();
            System.out.println(cart.receipt());
        }
        System.out.print("Do you want to keep purchasing items? y/n: ");
        String keepPurchasing = scan.nextLine();
        if (keepPurchasing.equals("y")) {
            System.out.println();
            selection();
        }
    }

    private void checkout() {
        System.out.println();
        if (!customer.isPurchaseSuccessful(cart.getTotal())) {
            System.out.println("Purchase was NOT success. You did NOT have enough in your balance.");
        } else {
            String str = "Have a GREAT day!";
            for (int i = 1; i <= 4; i++) {
                int index = str.indexOf(" ");
                for (int j = 0; j <= index; j++) {
                    System.out.print(str.substring(j, j + 1));
                }
                if (i <= 3) {
                    System.out.println();
                }
                str = str.substring(index + 1);
            }
            System.out.println(str);
        }
    }

}