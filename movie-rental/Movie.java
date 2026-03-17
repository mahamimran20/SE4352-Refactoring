public class Movie {

    public static final int CHILDRENS   = 2;
    public static final int REGULAR     = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price  price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    // setPriceCode keeps the int-based API for backward compatibility
    // but internally stores a Price strategy object
    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code: " + priceCode);
        }
    }

    public String getTitle() {
        return title;
    }

    // Moving method #2: charge calculation delegated to Price strategy
    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    // Moving method #3: frequent-renter-point bonus delegated to Price strategy
    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}