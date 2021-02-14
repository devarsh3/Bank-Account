
/**
 * @author Daunte
 * Description: Create a customer profile that has a name, address and phone number
 *
 */
public class Customer {
	private String address;
	private String name;
	private String phoneNumber;

	// class data (only some is here, you may need more)
	// first and last name, address, phone.

	public Customer() // default constructor to initialize data
	{
		this.address = null;
		this.name = null;
		this.phoneNumber = null;
		// intializes the data
	}

	// Overloaded Constructor initializes the client information with specific
	// information.
	public Customer(String address, String name, String phoneNumber) {
		super();
		this.address = address;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	// Getters and setters for the class data
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// other methods to update and/or retrieve all data
	public void processCustomer(String owner) {
		String word[];
		word = owner.split("/");
		this.name = word[0];
		this.address = word[1];
		this.phoneNumber = (word[2]);
	}

	// for the customer
	// toString method
	public String toString() {
		return "Name: " + getName() + "\nAddress: " + getAddress() + "\nPhone Number: " + getPhoneNumber();
	}
	
	public String processString() {
		return getName() + "/" + getAddress() + "/" + getPhoneNumber();
	}

	public static void main(String args[]) {
		String owner = "Your Name/123 Street/911";
		Customer s = new Customer();
		System.out.println(s.toString());//testing toString and getter methods should output null for each
		System.out.println(s.getAddress());
		System.out.println(s.getName());
		System.out.println(s.getPhoneNumber());

		s.processCustomer(owner);//testing processCustomer method 
		System.out.println(s.toString());
		System.out.println(s.getAddress());//expected output:123 Street
		System.out.println(s.getName());//expected output:Your Name
		System.out.println(s.getPhoneNumber());//expected output:911

		s.setAddress("Randon Street 123");//testing setters
		s.setName("Random Name");
		s.setPhoneNumber("905-127-1029");
		System.out.println(s.toString());

		Customer y = new Customer("John Wick", "123 Anywhere Street", "123 456 7890");//testing overloaded constuctors

		
		System.out.println(y.toString());
		System.out.println(y.getAddress());// expected output:John Wick
		System.out.println(y.getName());// expected output:123 Anywhere Street
		System.out.println(y.getPhoneNumber());// expected output:123 456 7890

	}

}