/**
 * Created with IntelliJ IDEA. User: Berkling Date: 14.05.14 Time: 12:48 To
 * change this template use File | Settings | File Templates.
 */
abstract class Price {
	abstract int getPriceCode();

	abstract double getCharge(int daysRented);

	int getFrequentRenterPoints(int daysRented) {
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			return 2;
		else
			return 1;
	}

}
