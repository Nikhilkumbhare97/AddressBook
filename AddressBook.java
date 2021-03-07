import java.util.*;

class ContactDetails{

	private String firstName;
	private String lastName;
	private String area;
	private String city;
	private String state;
	private int zip;
	private int phoneNumber;
	private String email;

	public ContactDetails(String firstName, String lastName, String area, String city , String state, int zip, int phoneNumber, String email){

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

	public void setFirstName(String fname) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

   public void setLastName(String lname) {
      this.lastName = lastName;
   }

	public String getArea() {
		return this.area;
	}

	public void setArea(String ar) {
		this.area = area;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String cty) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String st) {
		this.state = state;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zp) {
		this.zip = zip;
	}

	public int getPhoneNumber() {
	return this.phoneNumber;
	}

	public void setPhoneNumber(int phn) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String eml) {
		this.email = email;
	}

	public String toString(){

		return "Details of: "+ firstName+ " "+lastName+"\n"
									+"Area: "+area+"\n"
									+"City: "+city+"\n"
									+"State: "+state+"\n"
									+"Zip: "+zip+"\n"
									+"Phone Number: "+phoneNumber+"\n"
									+"Email: "+email;
	}
}


class AddressBookDetails {

	public String addressBookName;
	public String firstName;
	public String lastName;
	public String area, city, state, email;
	public int zip, phoneNumber;
	public static int indexNum;

	public AddressBookDetails(String addressBookName) {
		this.addressBookName = addressBookName;
	}


	public static ArrayList<ContactDetails> list = new ArrayList<ContactDetails>();

	public Scanner sc = new Scanner(System.in);

	public boolean checkName(){

		System.out.println("Enter First Name");
		firstName=sc.next();
		System.out.println("Enter Last Name");
		lastName=sc.next();

		for(indexNum=0; indexNum<list.size(); indexNum++) {
			if(firstName.equals(list.get(indexNum).getFirstName()) && lastName.equals(list.get(indexNum).getLastName())) {
				System.out.println("Contact Name Exists");
				return true;
			}
		}
		return false;
	}

	public void addDetails(){

			if(!checkName()) {

				System.out.println("Enter Area");
				area=sc.next();
				System.out.println("Enter CityName");
				city=sc.next();
				System.out.println("Enter StateName");
				state=sc.next();
				System.out.println("Enter ZipCode");
				zip=sc.nextInt();
				System.out.println("Enter PhoneNumber");
				phoneNumber=sc.nextInt();
				System.out.println("Enter Email");
				email=sc.next();
			}
			list.add( new ContactDetails(firstName, lastName, area, city, state, zip, phoneNumber, email));
	}


	public String editDetails() {

		Scanner sc= new Scanner(System.in);
		System.out.println("Details to be Edited: ");

			if(checkName()) {
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
		if(checkName()) {
				list.remove(indexNum);
         	return "Deleted";
		}
		return "Name Not Available in List";
	}


	public void displayDetails() {

		for (int i=0; i<list.size(); i++) {
			System.out.println();
			System.out.println(list.get(i));
		}
	}

	@Override
	public String toString() {
		return addressBookName;
	}
}


public class AddressBook {

	private static int bookNumber=0;
	private static String firstName;
	private static String lastName;
	private static String area;
	private static String city;
	private static String state;
	private static int zip;
	private static int phoneNumber;
	private static String email;

	public static Scanner sc=new Scanner(System.in);

	public static Map<String, String> dictionaryCity=new HashMap<>();
	public static Map<String, String> dictionaryState=new HashMap<>();

	public static ArrayList<AddressBookDetails> addressBook=new ArrayList<>();

	public static void addAdressBookDetails() {

		System.out.println("Enter Name of Address Book");
		String name=sc.next();
		addressBook.add( new AddressBookDetails(name));
	}

	public static void pickAddressBook() {

		System.out.println("You are Currently in "+addressBook.get(bookNumber)+" AddressBook");
		if(addressBook.size() > 1) {
			for(int i=0; i<addressBook.size(); i++)
				System.out.println(i +". "+addressBook.get(i));
				System.out.println("Pick Address Book Number");
				bookNumber=Integer.parseInt(sc.next());
		}
	}

	public static void personByState() {

		System.out.println("Enter State Name");
		state = sc.next();
			for (int i = 0; i < addressBook.size(); i++)
				for (int j = 0; j < addressBook.get(i).list.size(); j++)
					if (addressBook.get(i).list.get(j).getState().equals(state))
						System.out.println(addressBook.get(i).list.get(j));
	}

	public static void personByCity() {

		System.out.println("Enter City Name");
		city = sc.next();
			for (int i = 0; i < addressBook.size(); i++)
				for (int j = 0; j < addressBook.get(i).list.size(); j++)
					if (addressBook.get(i).list.get(j).getCity().equals(city))
						System.out.println(addressBook.get(i).list.get(j));
	}

	private static void cityPersonDict() {
		for (AddressBookDetails address: addressBook)
			for (ContactDetails contact: address.list) {
				String name = contact.getFirstName() + " " + contact.getLastName();
					dictionaryCity.put(name, contact.getCity());
			}

			System.out.println("Enter City");
			city= sc.next();
			for (Map.Entry<String, String> ls : dictionaryCity.entrySet())
				if (city.equals(ls.getValue()))
					System.out.println("Name " + ls.getKey());
	}

	private static void statePersonDict() {
      for (AddressBookDetails address: addressBook)
         for (ContactDetails contact: address.list) {
            String name = contact.getFirstName() + " " + contact.getLastName();
               dictionaryCity.put(name, contact.getState());
         }

         System.out.println("Enter State");
         state= sc.next();
         for (Map.Entry<String, String> ls : dictionaryCity.entrySet())
            if (state.equals(ls.getValue()))
               System.out.println("Name " + ls.getKey());
   }

	public static void option() {

		Scanner sc = new Scanner(System.in);

		String check = "Y";
		while((check.equals("Y")) || (check.equals("y"))) {

		System.out.println("Choose Below Option");
		System.out.println("1: Add Contact");
		System.out.println("2: Edit Contact");
		System.out.println("3: Delete Contact");
		System.out.println("4: Display Contact");
		System.out.println("5: Exit");

		String choose=sc.next();
		switch(choose) {

			case "1" :
				addressBook.get(bookNumber).addDetails();
				break;
			case "2" :
				pickAddressBook();
				System.out.println(addressBook.get(bookNumber).editDetails());
				break;
			case "3" :
				pickAddressBook();
				System.out.println(addressBook.get(bookNumber).deleteDetails());
				break;
			case "4" :
				pickAddressBook();
				addressBook.get(bookNumber).displayDetails();
				break;
			default:
				System.out.println("Exit");

			System.out.println("Want to Make More Changes in This Address Book? (y/n)");
			check=sc.next();
		}

		}
	}

	public static void search() {

		System.out.println("Choose Option");
		System.out.println("1: By City Name" );
		System.out.println("2: By State Name");
		System.out.println("3: View Person in City");
		System.out.println("4: View Person in State");

		String choose=sc.next();
		switch (choose) {

			case "1" :
				personByCity();
				break;
			case "2":
				personByState();
				break;
			case "3" :
				cityPersonDict();
				break;
			case "4" :
				statePersonDict();
				break;
			default :
				System.out.println("Wrong Input");
		}
	}

	public static void main(String[] args) {

			System.out.println("Welcome to Address Book Program");

			String check = "Y";
			while((check.equals("Y")) || (check.equals("y"))) {

				addAdressBookDetails();
				option();

				System.out.println("Do You Want to Search or View Contacts By Certain Details Like by City, State, etc?");
				System.out.println("Press y if You Want to Search");
				String num=sc.next();
				if (num.equals("Y") || num.equals("y")) {
					search();
				}else{
					System.out.println("You Can Proceed Further");
				}

				System.out.println("Want to Add More Address Book (y/n)");
				check=sc.next();
			}

	}
}


