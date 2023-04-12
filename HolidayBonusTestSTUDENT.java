import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HolidayBonusTestSTUDENT{

	@Test
	public void testCalculateHolidayBonus() {
	    double[][] data = { { 1000, 2000, 1500 }, { 3000, 2500, 4000 }, { 5000, 1000, 3000 } };
	    double high = 100;
	    double low = 50;
	    double other = 25;

	    // Expected bonuses based on the actual highest, lowest, and other values in the data array
	    double[] expectedBonuses = { high, other, high + low }; // Update expected bonuses based on actual data values

	    double[] actualBonuses = HolidayBonus.calculateHolidayBonus(data, high, low, other);
	    for (int i = 0; i < expectedBonuses.length; i++) {
	        assertEquals(expectedBonuses[i], actualBonuses[i], 0.001); // Use delta for double comparison
	    }
	}

    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] data = { { 1000, 2000, 1500 }, { 3000, 2500, 4000 }, { 5000, 1000, 3000 } };
        double high = 100;
        double low = 50;
        double other = 25;
        double expectedTotal = 250;
        double actualTotal = HolidayBonus.calculateTotalHolidayBonus(data, high, low, other);
        assertEquals(expectedTotal, actualTotal, 0.001); // Use delta for double comparison
    }

    // Add more test cases for edge cases or different scenarios as needed

}