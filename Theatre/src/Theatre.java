import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Theatre {
    // 2D array representing the seating area
    static int[][] seats = new int[3][]; // 3 rows
    static int row1Seats = 12;// number of seats in row 1
    static int row2Seats = 16;// number of seats in row 2
    static int row3Seats = 20;// number of seats in row 3

    // ArrayList to store Ticket objects
    public static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

    // Scanner to read user input
    static Scanner input = new Scanner(System.in);



    public static void main(String[] args) {
        seats[0] = new int[row1Seats];
        seats[1] = new int[row2Seats];
        seats[2] = new int[row3Seats];
        initializeSeats();
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("\t\t\t\t\tWelcome to the New Theatre");
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println();
        int option;
        do {
            displayMenu();
            System.out.println();
            System.out.print("Please Select An Option : ");

            option = input.nextInt();
            switch (option) {
                case 1:
                    buyticket();
                    break;
                case 2:
                    print_seating_area( );

                    break;
                case 3:
                    cancel_ticket();

                    break;
                case 4:
                    show_available();

                    break;
                case 5:
                    save();

                    break;
                case 6:
                    load();
                    break;
                case 7:
                    ticket_info();
                    break;
                case 8:
                    sort_info();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Thank you for visiting the New Theatre. Have a nice day!");
                    System.out.println();
                    System.out.println("////////////////////////////////////////////////////////////////////////");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        } while (option != 0);
    }

    // Method to initialize the seats array to 0
    public static void initializeSeats() {
        for (int i = 0; i < row1Seats; i++) {
            seats[0][i] = 0;
        }
        for (int i = 0; i < row2Seats; i++) {
            seats[1][i] = 0;
        }
        for (int i = 0; i < row3Seats; i++) {
            seats[2][i] = 0;
        }
    }

    // Method to display the menu options
    public static void displayMenu() {
        System.out.println();
        System.out.println("1) Buy a ticket");
        System.out.println("2) Print seating area");
        System.out.println("3) Cancel ticket");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file");
        System.out.println("6) Load from file");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price");
        System.out.println("0) Quit");
        System.out.println();
        System.out.println("///////////////////////////////////////////////////////////////////////");
    }
    // Method to allow the user to purchase a ticket
    public static void buyticket(){
        boolean running = true;

        // Prompt the user for their personal information

        System.out.print("Please enter name: ");
        String FirstName = input.next();
        System.out.print("Please enter surname: ");
        String SecondName = input.next();
        System.out.print("Please enter email: ");
        String Email = input.next();
        System.out.print("Please enter the price: ");
        double price = input.nextDouble();

        // Create a Person object with the user's personal information

        Person person = new Person(FirstName, SecondName, Email);

        // Loop until the user successfully selects an available seat

        while (running) {
            System.out.print("Enter row number: ");
            int row = input.nextInt();
            if (row < 1 || row >= 4) { // Validate row number
                System.out.println("Invalid row number! Please try again.");
                continue; // Go back to the beginning of the loop
            }
            System.out.print("Enter seat number: ");
            int seat = input.nextInt();
            if (!((row==1 && seat <= row1Seats)||(row==2 && seat<=row2Seats)||(row==3&& seat<=row3Seats)|| seat<1)) { // Validate seat number
                System.out.println("Invalid seat number! Please try again.");
                continue; // Go back to the beginning of the loop
            }
            switch (row){
                case 1:
                    if (seats[0][seat - 1] == 0) { // Check if seat is available
                        System.out.print("This seat is available! Confirm purchase? (Y/N): ");
                        String confirm = input.next();
                        if (confirm.equalsIgnoreCase("Y")) {  // Confirm purchase
                            seats[0][seat - 1] = 1; // Mark seat as occupied
                            System.out.print("Purchase confirmed. Enjoy the show!");
                            System.out.println();
                            Ticket tickets = new Ticket(row, seats, price, person);
                            ticketList.add(tickets); // Add ticket to list of purchased tickets
                            running = false; // Exit the loop
                        } else { // Cancel purchase
                            System.out.print("Purchase cancelled!");
                        }
                    } else { // Seat is already taken
                        System.out.print("This seat is already taken. Please choose another seat!");
                    }
                    break;
                case 2:
                    if (seats[1][seat - 1] == 0) { // Check if seat is available
                        System.out.print("This seat is available! Confirm purchase? (Y/N)");
                        String confirm = input.next();
                        if (confirm.equalsIgnoreCase("Y")) { // Confirm purchase
                            seats[1][seat - 1] = 1; // Mark seat as occupied
                            System.out.println("Purchase confirmed. Enjoy the show!");
                            System.out.println();
                            Ticket tickets = new Ticket(row, seats, price, person);
                            ticketList.add(tickets); // Add ticket to list of purchased tickets
                            running = false; // Exit the loop
                        } else { // Cancel purchase
                            System.out.println("Purchase cancelled!");
                        }
                    } else { // Seat is already taken
                        System.out.println("This seat is already taken. Please choose another seat!");
                    }
                    break;
                case 3:
                    if (seats[2][seat - 1] == 0) { // Check if seat is available
                        System.out.print("This seat is available! Confirm purchase? (Y/N)");
                        String confirm = input.next();
                        if (confirm.equalsIgnoreCase("Y")) { // Confirm purchase
                            seats[2][seat - 1] = 1; // Mark seat as occupied
                            System.out.println("Purchase confirmed. Enjoy the show!");
                            System.out.println();
                            Ticket tickets = new Ticket(row, seats, price, person);
                            ticketList.add(tickets); // Add ticket to list of purchased tickets
                            running = false; // Exit the loop
                        } else { // Cancel purchase
                            System.out.println("Purchase cancelled!");
                        }
                    } else { // Seat is already taken
                        System.out.println("This seat is already taken. Please choose another!");
                    }
                    break;
                default: // Out of range
                    System.out.println("Out of range!");
                    break;
            }

        }

    }
    // Method to print the seating area
    public static void print_seating_area( ){
        // String representing a seat in the seating area
        int x;
        int y;
        int z;
        String ch = "*";
        // Print the top row of the seating area
        System.out.println("    " + ch.repeat(11));
        // Print the "STAGE" label in the middle row
        System.out.println("    " + ch + "  STAGE  " + ch);
        // Print the bottom row of the seating area
        System.out.println("    " + ch.repeat(11));
        System.out.println();
        System.out.print("    ");
        // Print each row of the seating area
        // Print each seat in the row
        for(x = 0; x<seats[0].length; x++) {
            if(seats[0][x] == 1){
                System.out.print("X");

            }else{
                System.out.print("O");
            }

        }
        System.out.println();
        System.out.print("  ");
        for(y = 0; y<seats[1].length; y++) {
            if(seats[1][y] == 1){
                System.out.print("X");

            }else{

                System.out.print("O");
            }

        }
        System.out.println();
        for(z= 0; z<seats[2].length; z++) {
            if(seats[2][z] == 1){
                System.out.print("X");

            }else{
                System.out.print("O");
            }

        }
        System.out.println();


    }
    // Method to cancel a purchased ticket
    public static void cancel_ticket() {
        // Print the list of purchased tickets
        System.out.println(ticketList);
        // Prompt the user to enter the row number of the ticket they want to cancel
        System.out.print("Enter row number : ");
        int row = input.nextInt();
        if (row < 1 || row >= 4) {
            System.out.println("Invalid row number! Please try again.");
            return;
        }
        // Prompt the user to enter the seat number of the ticket they want to cancel
        System.out.print("Enter seat number : ");
        int seat = input.nextInt();
        int seatIndex = seat - 1;
        int[] rowArray = seats[row - 1];
        if (seatIndex < 0 || seatIndex >= rowArray.length) {
            System.out.println("Invalid seat number! Please try again.");
            return;
        }
        if (rowArray[seatIndex] == 0) {
            System.out.println("Seat is already available!");
            return;
        }
        rowArray[seatIndex] = 0; // Mark the seat as unoccupied
        System.out.println("Ticket cancelled successfully");
        // Search for the canceled ticket in the ticket list and remove it
        boolean found = false;
        int i = 0;
        while (i < ticketList.size()) {
            Ticket ticket = ticketList.get(i);
            if (ticket.getRow() == row && ticket.getSeat() == seat) {
                ticketList.remove(i);
                System.out.println(ticketList);
                System.out.println("Ticket removed from the list!");
                found = true;
                break;
            }
            i++;
        }
        if (!found) {
            System.out.println("Ticket not found!");
        }
    }


    public static void show_available() {
        System.out.println("\nAvailable seats :");
        // Loop through each row of the seats array
        for (int row = 0; row < seats.length; row++) {
            System.out.print("Row " + (row+1) + ": ");
            // Loop through each seat of the current row
            for (int seat = 0; seat < seats[row].length; seat++) {
                // If the seat is available, print its number
                if (seats[row][seat] == 0) {
                    System.out.print((seat+1) + " ");
                }
            }
            System.out.println();
        }
    }
    public static void save() {
        try {
            FileWriter writer = new FileWriter("seats.txt");
            // Loop through each row of the seats array
            for (int i = 0; i < seats.length; i++) {
                // Loop through each seat of the current row
                for (int j = 0; j < seats[i].length; j++) {
                    // Write the seat number to the file
                    writer.write(seats[i][j] + " ");
                }
                // Write a new line to separate each row
                writer.write("\n");
            }
            writer.close();
            System.out.println("Seats saved to file 'seats.txt'!");
        } catch (IOException e) {
            System.out.println("Error saving seats to file: " + e.getMessage());
        }
    }
    public static void load() {
        try {
            File file = new File("seats.txt");
            Scanner scanner = new Scanner(file);

            // Read the seating information from the file and update the arrays
            for (int i = 0; i < 3; i++) {
                String[] line = scanner.nextLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    seats[i][j] = Integer.parseInt(line[j]);  // Convert seat number from string to integer
                }
            }
            scanner.close();
            System.out.println("Seats successfully loaded from file!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static void ticket_info(){
        double total = 0.0;
        int ticketNumber = 1;
        // Loop through each ticket in the ticketList and print its information
        for (Ticket tickets : ticketList) {
            System.out.println("Ticket " + ticketNumber++ + ":"); // Print the ticket information using the Ticket class's print() method
            tickets.print();
            System.out.println();
            total += tickets.getPrice(); // Add the ticket price to the running total

        }
        // Print the total price of all tickets
        System.out.printf("Total price of all tickets: LKR %.2f\n", total);


    }
    public static ArrayList<Ticket> sort_info(){
        ArrayList<Ticket> sortedTickets = new ArrayList<>(ticketList);
        int n = sortedTickets.size();
        // Sort the tickets in ascending order of price using a bubble sort algorithm0

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (sortedTickets.get(j).getPrice() > sortedTickets.get(j+1).getPrice()) {
                    // Swap the current and next tickets in the list
                    Ticket temp = sortedTickets.get(j);
                    sortedTickets.set(j, sortedTickets.get(j+1));
                    sortedTickets.set(j+1, temp);
                }
            }
        }
        System.out.println("Tickets sorted by price (ascending):");
        for (Ticket ticket : sortedTickets) {
            ticket.print();
            System.out.println();
        }
        return sortedTickets;

    }

}

