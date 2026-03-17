// New class #4: concrete Price strategy for a new-release movie
public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    // New releases earn an extra bonus point for rentals longer than one day
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}