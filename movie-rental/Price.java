// create new class #2
public abstract class Price {

    // Renaming 2: getPriceCode was previously the int constant on Movie;
    public abstract int getPriceCode();

    // Moving method 2 : charge calculation moved from Statement.determineAmount()
    // into each Price subclass so the switch statement is eliminated
    public abstract double getCharge(int daysRented);

    // Moving method 3: frequent-renter-point bonus moved from Statement.createStatement()
    // into each Price subclass; default is one point per rental
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}