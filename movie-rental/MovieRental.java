public class MovieRental {
    public static void main(String[] args) {
        // Set up movies
        Movie independenceDay = new Movie("Independence Day", Movie.NEW_RELEASE);
        Movie toyStory        = new Movie("Toy Story",        Movie.CHILDRENS);
        Movie godfather       = new Movie("The Godfather",    Movie.REGULAR);

        // Build a customer with several rentals
        Customer john = new Customer("John Smith");
        john.addRental(new Rental(independenceDay, 3));
        john.addRental(new Rental(toyStory,        5));
        john.addRental(new Rental(godfather,        4));

        // Plain-text statement
        Statement textStatement = new Statement(john);
        System.out.println("=== Plain-Text Statement ===");
        System.out.println(textStatement.createStatement());

        // XML statement
        XmlStatement xmlStatement = new XmlStatement(john);
        System.out.println("\n=== XML Statement ===");
        System.out.println(xmlStatement.createXmlStatement());

        // Second customer (single new-release rental)
        Customer jane = new Customer("Jane Doe");
        jane.addRental(new Rental(new Movie("Avengers", Movie.NEW_RELEASE), 1));

        Statement janeText = new Statement(jane);
        System.out.println("=== Jane Plain-Text Statement ===");
        System.out.println(janeText.createStatement());

        XmlStatement janeXml = new XmlStatement(jane);
        System.out.println("\n=== Jane XML Statement ===");
        System.out.println(janeXml.createXmlStatement());
    }
}
