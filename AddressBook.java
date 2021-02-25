import java.util.Scanner;

interface iContactDetails{
	public void addDetails(String firstName, String LastName, String area, String city, String state, int zip, int phoneNumber, String email);
}

class ContactDetails{

	public final String firstName;
	public final String lastName;
	public final String area;
	public final String city;
	public final String state;
	public final int zip;
	public final int phoneNumber;
	public final String email;

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

public class AddressBook implements iContactDetails{

	private static int numOfPerson;
	private ContactDetails[] contactDetails;

	public AddressBook(){
		contactDetails = new ContactDetails[5];
	}

	public void addDetails(String firstName, String lastName, String area, String city , String state, int zip, int phoneNumber, String email){
		contactDetails [ numOfPerson ] = new ContactDetails(firstName, lastName, area, city, state, zip, phoneNumber, email);
		numOfPerson++;
	}

	private void computeDetails(){
		for (int i=0; i<numOfPerson; i++){
			System.out.println(contactDetails[i]);
		}
	}

	public static void main(String[] args){

		System.out.println("Welcome To Address Book Problem");

		Scanner sc=new Scanner(System.in);

		System.out.println("Number Of Details to Add");
		int numOfPerson=sc.nextInt();
		String name=sc.nextLine();
		AddressBook address = new AddressBook();


		for (int i = 1; i <= numOfPerson; i++) {

			System.out.println("Enter no. of details of: "+i);

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

			address.addDetails(firstName, lastName, area, city, state, zip, phoneNumber, email);
			address.computeDetails();
		}
	}
}
