import java.lang.*;
import java.util.*;

class Customer {
	private String _name;
	private Vector _rentals = new Vector();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			thisAmount = amountFor(each);
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++; // show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

	// It is worth stopping to think a bit about the last refactoring. Most
	// refactorings reduce the amount
	// of code, but this one increases it. That's because Java 1.1 requires a
	// lot of statements to set up a
	// summing loop. Even a simple summing loop with one line of code per
	// element needs six lines of
	// support around it. It's an idiom that is obvious to any programmer but is
	// a lot of lines all the same.
	// The other concern with this refactoring lies in performance. The old code
	// executed the "while"
	// loop once, the new code executes it three times. A while loop that takes
	// a long time might impair
	// performance. Many programmers would not do this refactoring simply for
	// this reason. But note
	// the words if and might. Until I profile I cannot tell how much time is
	// needed for the loop to
	// calculate or whether the loop is called often enough for it to affect the
	// overall performance of the
	// system. Don't worry about this while refactoring. When you optimize you
	// will have to worry about
	// it, but you will then be in a much better position to do something about
	// it, and you will have more
	// options to optimize effectively (see the discussion on page 69).

	private double getTotalCharge() {
		double result = 0;
		Enumeration enum_rentals = _rentals.elements();
		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration enum_rentals = _rentals.elements();
		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

	private double amountFor(Rental aRental) {
		return aRental.getCharge();
	}

}
