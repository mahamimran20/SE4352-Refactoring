import java.util.List;

// create new class #1
public class Statement {

    private Customer     customer;
    private List<Rental> rentals;

    public Statement(Customer customer) {
        this.customer = customer;
        this.rentals  = customer.getRentals();
    }

    // Moving method 1 (from Customer), Renaming 1 (statement() -> createStatement())
    public String createStatement() {
        double totalAmount          = 0;
        int    frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

        for (Rental rental : rentals) {
            frequentRenterPoints += computeFrequentRenterPoints(rental);

            // Method extraction #2: formatRentalLine
            result.append(formatRentalLine(rental));
            totalAmount += rental.getCharge();
        }

        // Method extraction #3: formatFooter
        result.append(formatFooter(totalAmount, frequentRenterPoints));
        return result.toString();
    }

    // Method extraction 1
    // Method extraction 2
    private String formatRentalLine(Rental rental) {
        return "\t" + rental.getMovie().getTitle()
                + "\t" + rental.getCharge() + "\n";
    }

    // Method extraction 3: builds the footer of the plain-text statement
    private String formatFooter(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount + "\n"
                + "You earned " + frequentRenterPoints + " frequent renter points";
    }

    // Method extraction 4: computes frequent-renter points for one rental (delegates to Rental)
    private int computeFrequentRenterPoints(Rental rental) {
        return rental.getFrequentRenterPoints();
    }
}