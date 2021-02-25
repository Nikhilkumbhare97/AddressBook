interface iContactDetails{
	public void details(String firstName, String LastName, String area, String city, String state, int zip, int phoneNumber, String email);
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

public class AddressBook implements iContactDetails {

	private int numOfPerson = 0;
	private ContactDetails[] contactDetails;

	public AddressBook(){
		contactDetails = new ContactDetails[3];
	}

	public void details(String firstName, String lastName, String area, String city , String state, int zip, int phoneNumber1, String email){
		contactDetails [ numOfPerson ] = new ContactDetails(firstName, lastName, area, city, state, zip, phoneNumber1, email);
		numOfPerson++;
	}

	private void computeDetails(){
		for (int i=0; i<numOfPerson; i++){
			System.out.println(contactDetails[i]);
		}
	}

	public static void main(String[] args){

		System.out.println("Welcome To Address Book Problem");

		AddressBook address = new AddressBook();
		address.details("Nikhil", "Kumbhare", "Manewada", "Nagpur", "Maharashtra", 440034, 987564, "nikhil@gmail.com");
		address.computeDetails();
	}
}
