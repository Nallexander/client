/*
 * Class representing a lab group
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

class LabGroup implements Serializable {

	private static final long serialVersionUID = 1L;

    private ArrayList<Person> members;

    public LabGroup() {
	members = new ArrayList<Person>();
    }

    /**
     * Method used to add a member to the lab group
     * @param firstName First name of group member
     * @param lastName Last name of group member
     * @param personalNumber Personal number of group member
     */
    public void addMember(String firstName, String lastName, String personalNumber) {
		members.add(new Person(firstName, lastName, personalNumber));
    }

    public String toString() {
		/* Output the lab group in a nice format, i.e.
		   as a comma separated list of names */
		String retStr = "";
		Iterator<Person> it = members.iterator();

		while (it.hasNext()) {
		    retStr += (it.next()).toString() +
			(it.hasNext()?", ":"");
		}

		return retStr;
    }

    /*
     * Class representing a person
     */
    class Person implements Serializable {
    private static final long serialVersionUID = 1L;
	private String firstName = "";
	private String lastName = "";
	private String personalNumber = "";

	public Person(String firstName, String lastName, String personalNumber) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.personalNumber = personalNumber;
	}

	public String toString() {
	    /* Output the person in a nice format */
	    return firstName + " " + lastName + "(" +
		personalNumber + ")";
	}
    }
}
