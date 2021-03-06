import java.util.*;
import java.util.stream.Collectors;

class ContactDetails{

    private String firstName;
    private String lastName;
    private String area;
    private String city;
    private String state;
    private int zip;
    private int phoneNumber;
    private String email;

    public ContactDetails(String firstName, String lastName, String area, String city, String state, int zip, int phoneNumber, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.area = area;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {

        return "Details of: " + firstName + " " + lastName + "\n"
                + "Area: " + area + "\n"
                + "City: " + city + "\n"
                + "State: " + state + "\n"
                + "Zip: " + zip + "\n"
                + "Phone Number: " + phoneNumber + "\n"
                + "Email: " + email;
    }
}

class AddressBookDetails {

    public static int indexNum;
    public static ArrayList<ContactDetails> list = new ArrayList<>();
    public String addressBookName;
    public String firstName;
    public String lastName;
    public String area, city, state, email;
    public int zip, phoneNumber;
    public Scanner sc = new Scanner(System.in);

    public AddressBookDetails(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public boolean checkName() {

        System.out.println("Enter First Name");
        firstName = sc.next();
        System.out.println("Enter Last Name");
        lastName = sc.next();

        for (indexNum = 0; indexNum < list.size(); indexNum++) {
            if (firstName.equals(list.get(indexNum).getFirstName()) && lastName.equals(list.get(indexNum).getLastName())) {
                System.out.println("Contact Name Exists");
                return true;
            }
        }
        return false;
    }

    public void addDetails() {

        if (!checkName()) {

            System.out.println("Enter Area");
            area = sc.next();
            System.out.println("Enter CityName");
            city = sc.next();
            System.out.println("Enter StateName");
            state = sc.next();
            System.out.println("Enter ZipCode");
            zip = sc.nextInt();
            System.out.println("Enter PhoneNumber");
            phoneNumber = sc.nextInt();
            System.out.println("Enter Email");
            email = sc.next();
        }
        list.add(new ContactDetails(firstName, lastName, area, city, state, zip, phoneNumber, email));
    }


    public String editDetails() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Details to be Edited: ");

        if (checkName()) {
            System.out.println("Enter FirstName");
            list.get(indexNum).setFirstName(sc.next());
            System.out.println("Enter LastName");
            list.get(indexNum).setLastName(sc.next());
            System.out.println("Enter Area");
            list.get(indexNum).setArea(sc.next());
            System.out.println("Enter CityName");
            list.get(indexNum).setCity(sc.next());
            System.out.println("Enter StateName");
            list.get(indexNum).setState(sc.next());
            System.out.println("Enter ZipCode");
            list.get(indexNum).setZip(sc.nextInt());
            System.out.println("Enter PhoneNumber");
            list.get(indexNum).setPhoneNumber(sc.nextInt());
            System.out.println("Enter Email");
            list.get(indexNum).setEmail(sc.next());

            return "Edited";
        }
        return "Name Not Available in List";
    }


    public String deleteDetails() {

        System.out.print("Details to be Deleted");
        if (checkName()) {
            list.remove(indexNum);
            return "Deleted";
        }
        return "Name Not Available in List";
    }


    public void displayDetails() {

        for (ContactDetails contactDetails : list) {
            System.out.println();
            System.out.println(contactDetails);
        }
    }

    @Override
    public String toString() {
        return addressBookName;
    }
}

public class AddressBook {

    public static Scanner sc = new Scanner(System.in);
    public static Map<String, String> dictionaryCity = new HashMap<>();
    public static Map<String, String> dictionaryState = new HashMap<>();
    public static List<String> allDetails = new ArrayList<>();
    public static ArrayList<AddressBookDetails> addressBook = new ArrayList<>();
    private static int bookNumber = 0;
    private static String city;
    private static String state;

    public static void addAdressBookDetails() {

        System.out.println("Enter Name of Address Book");
        String name = sc.next();
        addressBook.add(new AddressBookDetails(name));
    }

    public static void pickAddressBook() {

        System.out.println("You are Currently in " + addressBook.get(bookNumber) + " AddressBook");
        if (addressBook.size() > 1) {
            for (int i = 0; i < addressBook.size(); i++)
                System.out.println(i + ". " + addressBook.get(i));
            System.out.println("Pick Address Book Number");
            bookNumber = Integer.parseInt(sc.next());
        }
    }

    public static void personByState() {

        System.out.println("Enter State Name");
        state = sc.next();

        addressBook.forEach(address -> AddressBookDetails.list.stream()
                .filter(contact -> contact.getState().equals(state))
                .forEach(System.out::println));
    }

    public static void personByCity() {

        System.out.println("Enter City Name");
        city = sc.next();

        addressBook.forEach(address -> AddressBookDetails.list.stream()
                .filter(contact -> contact.getCity().equals(city))
                .forEach(System.out::println));
    }

    public static void cityPersonDict() {

        System.out.println("Enter City Name");
        city = sc.next();

        addressBook.forEach(address -> AddressBookDetails.list.stream()
                .filter(contact -> contact.getCity().equals(city))
                .forEach(contact -> dictionaryCity.put((contact.getFirstName() + " " + contact.getLastName()), contact.getCity())));

        dictionaryCity.forEach((key, value) -> System.out.println("Name " + key));
    }

    public static void statePersonDict() {

        System.out.println("Enter State Name");
        state = sc.next();

        addressBook.forEach(address -> AddressBookDetails.list.stream()
                .filter(contact -> contact.getState().equals(state))
                .forEach(contact -> dictionaryState.put((contact.getFirstName() + " " + contact.getLastName()), contact.getState())));

        dictionaryState.forEach((key, value) -> System.out.println("Name " + key));
    }

    public static void setCityCount() {

        addressBook.forEach(address -> AddressBookDetails.list
                .forEach(contact -> allDetails.add(contact.getCity())));

        allDetails.stream()
                .distinct()
                .forEach(placeName -> System.out.println("Number of People from " + placeName + " is : " + allDetails.stream().filter(n1 -> n1.equals(placeName)).count()));
    }

    public static void setStateCount() {

        addressBook.forEach(address -> AddressBookDetails.list
                .forEach(contact -> allDetails.add(contact.getState())));

        allDetails.stream()
                .distinct()
                .forEach(placeName -> System.out.println("Number of People from " + placeName + " is : " + allDetails.stream().filter(n1 -> n1.equals(placeName)).count()));
    }

    public static void sortByName() {

        addressBook.forEach(address -> AddressBookDetails.list
                .forEach(contact -> allDetails.add(contact.getFirstName() + " " + contact.getLastName())));

        allDetails.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void sortByAddress() {

        addressBook.forEach(address -> AddressBookDetails.list
                .forEach(contact -> allDetails.add(contact.getCity() + " " + contact.getState())));

        allDetails.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void option() {

        Scanner sc = new Scanner(System.in);

        String check = "Y";
        while (check.equals("Y")) {

            System.out.println("Choose Below Option");
            System.out.println("1: Add Contact");
            System.out.println("2: Edit Contact");
            System.out.println("3: Delete Contact");
            System.out.println("4: Display Contact");
            System.out.println("5: Exit");

            String choose = sc.next();
            switch (choose) {
                case "1" -> addressBook.get(bookNumber).addDetails();
                case "2" -> {
                    pickAddressBook();
                    System.out.println(addressBook.get(bookNumber).editDetails());
                }
                case "3" -> {
                    pickAddressBook();
                    System.out.println(addressBook.get(bookNumber).deleteDetails());
                }
                case "4" -> {
                    pickAddressBook();
                    addressBook.get(bookNumber).displayDetails();
                }
                default -> {
                    System.out.println("Exit");
                    check = "n";
                }
            }

        }
    }

    public static void search() {

        System.out.println("Choose Option");
        System.out.println("1: By City Name");
        System.out.println("2: By State Name");
        System.out.println("3: View Person in City");
        System.out.println("4: View Person in State");
        System.out.println("5: Total Persons in City");
        System.out.println("6: Total Persons in State");
        System.out.println("7: Sort By Name");
        System.out.println("8: Sort By City And State");

        String choose = sc.next();
        switch (choose) {
            case "1" -> personByCity();
            case "2" -> personByState();
            case "3" -> cityPersonDict();
            case "4" -> statePersonDict();
            case "5" -> setCityCount();
            case "6" -> setStateCount();
            case "7" -> sortByName();
            case "8" -> sortByAddress();
            default -> System.out.println("Wrong Input");
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        String check = "Y";
        while ((check.equals("Y")) || (check.equals("y"))) {
            addAdressBookDetails();
            option();

            System.out.println("Do You Want to Search or View or Count Contacts By Certain Details Like by City, State, etc?");
            System.out.println("Press y if You Want to Search");
            String num = sc.next();
            if (num.equals("Y") || num.equals("y")) {
                search();
            } else {
                System.out.println("You Can Proceed Further");
            }

            System.out.println("Want to Add More Address Book (y/n)");
            check = sc.next();
        }
        System.out.println("Thank You !!!");
    }
}


