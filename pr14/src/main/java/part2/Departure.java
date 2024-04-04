package part2;

public class Departure {
    private String type;
    private String departureDate;

    public Departure(String type, String departureDate) {
        this.type = type;
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "type: " + type + ", departureDate: " + departureDate;
    }
}
