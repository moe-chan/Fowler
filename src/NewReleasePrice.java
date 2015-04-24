/**
 * Created with IntelliJ IDEA. User: Berkling Date: 14.05.14 Time: 12:49 To
 * change this template use File | Settings | File Templates.
 */
class NewReleasePrice extends Price {
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	double getCharge(int daysRented) {
		return daysRented * 3;
	}

	int getFrequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}
}
