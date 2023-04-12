public class HolidayBonus {

    /**
     * Calculates the holiday bonus for each store.
     * 
     * @param data  The two-dimensional array of store sales.
     * @param high  Bonus for the highest store in a category.
     * @param low   Bonus for the lowest store in a category.
     * @param other Bonus for all other stores in a category.
     * @return An array of the bonus for each store.
     */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
double[] holidayBonuses = new double[data.length];
for(int i = 0; i < data.length; i++) {
	for(int k = 0; k<data[i].length; k++) {
		if (data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k))
			holidayBonuses[i] += high;
		else if(data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k) )
			holidayBonuses[i]+= low;
		else
			holidayBonuses[i] += other;
	}	
}
	    return holidayBonuses;
	}
    /**
     * Calculates the total holiday bonuses.
     * 
     * @param data  The two-dimensional array of store sales.
     * @param high  Bonus for the highest store in a category.
     * @param low   Bonus for the lowest store in a category.
     * @param other Bonus for all other stores in a category.
     * @return The total of all holiday bonuses.
     */
    public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
        double[] holidayBonuses = new double[data.length];
        double totalHolidayBounuses=0;

        for (int i=0; i<data.length; i++) {
            for (int k=0; k<data[i].length; k++) {
            	if (data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k))
        			holidayBonuses[i] += high;
        		else if(data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k) )
        			holidayBonuses[i]+= low;
        		else
        			holidayBonuses[i] += other;
            }
            	
        }
        for(int i =0;i<holidayBonuses.length;i++)
        	totalHolidayBounuses+=holidayBonuses[i];
        
        return totalHolidayBounuses;
    }

    /**
     * Returns the highest value in the given array.
     * 
     * @param array The array of doubles.
     * @return The highest value in the array.
     */



}