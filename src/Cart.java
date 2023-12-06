public class Cart {

    private int subTotalPencils;
    private int subTotalErasers;
    private int subTotalPrinterP;
    private int numPencils;
    private int numErasers;
    private int numPrinterP;
    private double tax;
    private int fees;
    private double total;

    public Cart() {
        subTotalPencils = 0;
        subTotalErasers = 0;
        subTotalPrinterP = 0;
        tax = 0;
        fees = 0;
    }

    public Cart(double tax) {
        subTotalPencils = 0;
        subTotalErasers = 0;
        subTotalPrinterP = 0;
        this.tax = tax;
        fees = 0;
    }

    public Cart(double tax, int fees) {
        subTotalPencils = 0;
        subTotalErasers = 0;
        subTotalPrinterP = 0;
        this.tax = tax;
        this.fees = fees;
    }

    public double getTotal() {
        return total;
    }

    public void calculateSubTotal(String items, int numOfItems) {
        if (items.equals("Pencils")) {
            for (int i = 1; i <= numOfItems; i++) {
                subTotalPencils += 4;
                numPencils++;
            }
        } else if (items.equals("Printer Paper")) {
            for (int i = 1; i <= numOfItems; i++) {
                subTotalPrinterP += 8;
                numPrinterP++;
            }
        } else {
            for (int i = 1; i <= numOfItems; i++) {
                subTotalErasers += 2;
                numErasers++;
            }
        }
    }

    public String receipt() {
        String receipt = numPencils + " Pencils: $" + subTotalPencils + "\n";
        receipt += numErasers + " Erasers: $" + subTotalErasers + "\n";
        receipt += numPrinterP + " Printer Paper: $" + subTotalPrinterP + "\n";
        int subTotal = subTotalPencils + subTotalErasers + subTotalPrinterP;
        receipt += "Subtotal: $" + subTotal + "\n";
        double totalTax = round(subTotal * tax);
        receipt += "Taxes: $" + totalTax + "\n";
        receipt += "Fees: $" + fees + "\n";
        total = round(subTotal + totalTax + fees);
        receipt += "Total: $" + total;
        return receipt;
    }

    private double round(double num) {
        return Math.round(num * 100.0) / 100.0;
    }

}