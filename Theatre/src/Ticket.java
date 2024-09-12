public class Ticket {
    // Declare public fields for the row, seat, and price of the ticket
    public int row;
    public int seat;
    public double price;

    // Declare a private field for the person who purchased the ticket
    private Person person;

    // Constructor method for the Ticket class
    public Ticket(int row, int[][] seats, double price, Person person) {
        // Initialize the row, seat, price, and person fields with the provided values
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getter method for the row field
    public int getRow() {
        return row;
    }

    // Getter method for the seat field
    public int getSeat() {
        return seat;
    }

    // Getter method for the price field
    public double getPrice() {
        return price;
    }

    // Getter method for the person field
    public Person getPerson() {
        return person;
    }

    // Method to print out the details of the ticket
    public void print() {
        System.out.println("Name = " + person.getName());
        System.out.println("Surname = " + person.getSurname());
        System.out.println("Email = " + person.getEmail());
        System.out.println("Row =  " + row);
        System.out.println("Seat =  " + seat);
        System.out.println("Price = " + price);
    }
}

