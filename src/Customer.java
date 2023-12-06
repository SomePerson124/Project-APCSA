public class Customer {
    private String items;
    private int numOfItems;
    private double balance;

    public Customer() {
        items = "";
        numOfItems = 0;
        balance = 50.0;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String response) {
        items = response;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int newNumOfItems) {
        numOfItems = newNumOfItems;
    }

    public boolean isPurchaseSuccessful(double cost) {
        if (balance >= cost) {
            return true;
        }
        return false;
    }

}