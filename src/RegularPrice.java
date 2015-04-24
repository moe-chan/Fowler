/**
 * Created with IntelliJ IDEA. User: Berkling Date: 14.05.14 Time: 12:49 To
 * change this template use File | Settings | File Templates.
 */
class RegularPrice extends Price {
	int getPriceCode() {
		return Movie.REGULAR;
	}
	
	double getCharge(int daysRented){
		double result = 2; if (daysRented > 2)
		result += (daysRented - 2) * 1.5; return result;
		}
}
