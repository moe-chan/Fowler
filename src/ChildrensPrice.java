/**
 * Created with IntelliJ IDEA. User: Berkling Date: 14.05.14 Time: 12:48 To
 * change this template use File | Settings | File Templates.
 */
class ChildrensPrice extends Price {
	int getPriceCode() {
		return Movie.CHILDRENS;
	}
	
	double getCharge(int daysRented){
		double result = 1.5; if (daysRented > 3)
		result += (daysRented - 3) * 1.5; return result;
		}

}
