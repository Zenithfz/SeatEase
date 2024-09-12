public class Person {
    public String name; // The name of the person
    public String surname; // The surname of the person
    public String email; // The email address of the person

    // Constructs a new person with the given name, surname, and email address
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // Returns the name of the person
    public String getName() {
        return name;
    }

    // Returns the surname of the person
    public String getSurname() {
        return surname;
    }

    // Returns the email address of the person
    public String getEmail() {
        return email;
    }


}