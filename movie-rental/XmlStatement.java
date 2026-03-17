import java.util.List;

// create new class #6
public class XmlStatement {

    private Customer     customer;
    private List<Rental> rentals;

    public XmlStatement(Customer customer) {
        this.customer = customer;
        this.rentals  = customer.getRentals();
    }

    // Renaming operation #6: method name xmlStatement (distinct from createStatement in Statement)
    public String createXmlStatement() {
        double totalAmount          = 0;
        int    frequentRenterPoints = 0;
        StringBuilder xml = new StringBuilder();

        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<statement>\n");
        xml.append(xmlTag("customer", customer.getName(), 1));

        for (Rental rental : rentals) {
            totalAmount          += rental.getCharge();
            frequentRenterPoints += rental.getFrequentRenterPoints();

            // Method extraction #5: formatXmlRentalLine
            xml.append(formatXmlRentalEntry(rental));
        }

        // Method extraction #6: formatXmlFooter
        xml.append(formatXmlFooter(totalAmount, frequentRenterPoints));
        xml.append("</statement>");
        return xml.toString();
    }

    // Method extraction #5: produces one <rental> block in XML
    private String formatXmlRentalEntry(Rental rental) {
        StringBuilder entry = new StringBuilder();
        entry.append(indent(1)).append("<rental>\n");
        entry.append(xmlTag("title",     rental.getMovie().getTitle(),          2));
        entry.append(xmlTag("days",      String.valueOf(rental.getDaysRented()), 2));
        entry.append(xmlTag("charge",    String.valueOf(rental.getCharge()),     2));
        entry.append(indent(1)).append("</rental>\n");
        return entry.toString();
    }

    // Method extraction #6: produces the <totalAmount> and <frequentRenterPoints> footer in XML
    private String formatXmlFooter(double totalAmount, int frequentRenterPoints) {
        return xmlTag("totalAmount",          String.valueOf(totalAmount),          1)
             + xmlTag("frequentRenterPoints", String.valueOf(frequentRenterPoints), 1);
    }

    private String xmlTag(String tag, String value, int depth) {
        return indent(depth) + "<" + tag + ">" + value + "</" + tag + ">\n";
    }

    private String indent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}