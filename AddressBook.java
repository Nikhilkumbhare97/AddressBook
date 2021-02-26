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

	static Scanner sc = new Scanner(System.in);
	public static String check = "Y";

	public static void addDetails(){

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

			list.add( new ContactDetails(firstName, lastName, area, city, state, zip, phoneNumber, email));
			System.out.println(list);
	}

	public static String editDetails() {

		String name1;
		System.out.println("Enter First Name of Details to be Edited: ");
		name1 = sc.next();

				if (name1.equals(list.get(0).getFirstName())) {

					System.out.println("Enter FirstName");
					list.get(0).setFirstName(sc.next());
					System.out.println("Enter LastName");
					list.get(0).setLastName(sc.next());
					System.out.println("Enter Area");
					list.get(0).setArea(sc.next());
					System.out.println("Enter CityName");
					list.get(0).setCity(sc.next());
					System.out.println("Enter StateName");
					list.get(0).setState(sc.next());
					System.out.println("Enter ZipCode");
					list.get(0).setZip(sc.nextInt());
					System.out.println("Enter PhoneNumber");
					list.get(0).setPhoneNumber(sc.nextInt());
					System.out.println("Enter Email");
					list.get(0).setEmail(sc.next());

					System.out.println(list.get(0));
					return "Edited";
				}else{
					return "Name Not Available in List";
				}
	}

	public static String deleteDetails() {
		String name1;
		System.out.print("Enter FirstName");
		name1 =sc.next();

		if (name1.equals(list.get(0).getFirstName())) {
			list.remove(0);
         return "Deleted";
		}else{
			return "Name Not Available in List";
   	}
	}

	public static void main(String[] args){
		System.out.println("Welcome To Address Book Problem");

		addDetails();
		System.out.print("Do you want to Edit That Contact ? (y/n)");
		check=sc.next();
		if (check.equals("y") || check.equals("Y")) {
			System.out.println(editDetails());
		}else{
			System.out.println("Done");
		}
		System.out.print("Do you want to Delete That Contact ? (y/n)");
		check=sc.next();
		if (check.equals("y") || check.equals("Y")) {
			System.out.println(deleteDetails());
		}else{
			System.out.println("Done");
		}

		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}
}
