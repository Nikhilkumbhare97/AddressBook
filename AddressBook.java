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
		this.firstName = fname;
	}

	public String getLastName() {
		return this.lastName;
	}

   public void setLastName(String lname) {
      this.lastName = lname;
   }

	public String getArea() {
		return this.area;
	}

	public void setArea(String ar) {
		this.area = ar;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String cty) {
		this.city = cty;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String st) {
		this.state = st;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zp) {
		this.zip = zp;
	}

	public int getPhoneNumber() {
	return this.phoneNumber;
	}

	public void setPhoneNumber(int phn) {
		this.phoneNumber = phn;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String eml) {
		this.email = eml;
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

public class AddressBook {

	static ArrayList<ContactDetails> list = new ArrayList<ContactDetails>();
	static Map<String,AddressBook> map = new HashMap<>();
	static int number=0;
	static int a;

	static Scanner sc = new Scanner(System.in);
	public static String check = "Y";

	public static void addDetails(){

		check = "Y";
		while((check.equals("Y")) || (check.equals("y"))) {

			System.out.println("Enter FirstName");
			String firstName=sc.next();
			System.out.println("Enter LastName");
			String lastName=sc.next();
			System.out.println("Enter Area");
			String area=sc.next();
			System.out.println("Enter CityName");
			String city=sc.next();
			System.out.println("Enter StateName");
			String state=sc.next();
			System.out.println("Enter ZipCode");
			int zip=sc.nextInt();
			System.out.println("Enter PhoneNumber");
			int phoneNumber=sc.nextInt();
			System.out.println("Enter Email");
			String email=sc.next();

			System.out.println("Want To Add Another Contact ? Yes(y)/No(n)");
			check=sc.next();

			list.add( new ContactDetails(firstName, lastName, area, city, state, zip, phoneNumber, email));
		}
	}

	public static String editDetails() {

		String name1;
		System.out.println("Enter First Name of Details to be Edited: ");
		name1 = sc.next();

			for(int i=0; i<list.size(); i++) {

				if (name1.equals(list.get(i).getFirstName())) {

					System.out.println("Enter FirstName");
					list.get(i).setFirstName(sc.next());
					System.out.println("Enter LastName");
					list.get(i).setLastName(sc.next());
					System.out.println("Enter Area");
					list.get(i).setArea(sc.next());
					System.out.println("Enter CityName");
					list.get(i).setCity(sc.next());
					System.out.println("Enter StateName");
					list.get(i).setState(sc.next());
					System.out.println("Enter ZipCode");
					list.get(i).setZip(sc.nextInt());
					System.out.println("Enter PhoneNumber");
					list.get(i).setPhoneNumber(sc.nextInt());
					System.out.println("Enter Email");
					list.get(i).setEmail(sc.next());

					System.out.println(list.get(i));
					return "Edited";
				}
			}
			return "Name Not Available in List";
	}

	public static String deleteDetails() {
		String name1;
		System.out.print("Enter FirstName");
		name1 =sc.next();

		for(int i=0; i<list.size(); i++) {
			if (name1.equals(list.get(0).getFirstName())) {
				list.remove(0);
         	return "Deleted";
			}
		}
		return "Name Not Available in List";
	}

	public static String multipleAddressBook() {

		System.out.println("Enter Name of Address Book");
		String name=sc.next();
		AddressBook addressBook = new AddressBook();
		map.put(name, addressBook);
		System.out.println("New Address Book: " +name);
		return name;
	}

	public static void main(String[] args){
		System.out.println("Welcome To Address Book Problem");

		AddressBook addressBook = new AddressBook();
		check = "Y";
		while((check.equals("Y")) || (check.equals("y"))) {

			String name=multipleAddressBook();

			addDetails();
			System.out.print("Do you want to Edit Contact ? (y/n)");
			check=sc.next();
			if (check.equals("y") || check.equals("Y")) {
				System.out.println(editDetails());
			}else{
				System.out.println("Done");
			}
			System.out.print("Do you want to Delete Contact ? (y/n)");
			check=sc.next();
			if (check.equals("y") || check.equals("Y")) {
				System.out.println(deleteDetails());
			}else{
				System.out.println("Done");
			}

			System.out.println("Contacts in "+name+" AddressBook are: ");
			for(a=number; a<list.size(); a++) {
				System.out.println(list.get(a));
				a++;
			}
			number=list.size();

			System.out.println("Do You Want to Add More Address Book? (y/n)");
			check=sc.next();
	   }

	}
}
