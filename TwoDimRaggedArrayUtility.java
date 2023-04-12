import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {

    // Private constructor to prevent instantiation
    private TwoDimRaggedArrayUtility() {
    }

    public static double[][] readFile(File file) throws FileNotFoundException {
        // Read from file and return a ragged array of doubles
        double[][] raggedArray = null;

        // Step 1: Read the doubles from the file into a temporary array [10][10] of Strings which was initialized to nulls
        String[][] tempArray = new String[10][10];
        Scanner scanner = new Scanner(file);
        int numRows = 0;
        int numCols = 0;

        // Step 2: Find out how many rows there are
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            numCols = Math.max(numCols, elements.length);
            tempArray[numRows++] = elements;
        }
        scanner.close();

        // Step 3: Create the array based on the number of rows
        raggedArray = new double[numRows][];

        // Step 4: Determine the number of columns for the first row
        // (any element != null is a valid element)
        numCols = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < tempArray[i].length; j++) {
                if (tempArray[i][j] != null) {
                    numCols = Math.max(numCols, j + 1);
                }
            }
        }
        
        

        // Step 5: Create the first row
        raggedArray[0] = new double[numCols];

        // Step 6: Put the values from the temporary array into the row
        // (don't forget to convert from strings to doubles)
        for (int i = 0; i < numRows; i++) {
            raggedArray[i] = new double[tempArray[i].length];
            for (int j = 0; j < tempArray[i].length; j++) {
                if (tempArray[i][j] != null) {
                    raggedArray[i][j] = Double.parseDouble(tempArray[i][j]);
                }
            }
        }

        return raggedArray;
    }

    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        // Write the ragged array of doubles into the file
        PrintWriter writer = new PrintWriter(outputFile);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                writer.print(data[i][j] + " ");
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] data) {
        // Returns the total of all the elements in the two dimensional array
        double total = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }
        return total;
    }

    public static double getAverage(double[][] data) {
        // Returns the average of the elements in the two dimensional array
        double total = getTotal(data);
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            count+= data[i].length;
        }
        return total / count;
        }
    public static double getRowTotal(double[][] data, int row) {
        // Returns the total of the elements in the specified row of the two dimensional array
        double total = 0;
        if (row >= 0 && row < data.length) {
            for (int j = 0; j < data[row].length; j++) {
                total += data[row][j];
            }
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        // Returns the total of the elements in the specified column of the two dimensional array
        double total = 0;
        if (col >= 0) {
            for (int i = 0; i < data.length; i++) {
                if (col < data[i].length) {
                    total += data[i][col];
                }
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int row) {
        // Returns the highest value in the specified row of the two dimensional array
        double highest = Double.MIN_VALUE;
        if (row >= 0 && row < data.length) {
            for (int j = 0; j < data[row].length; j++) {
                highest = Math.max(highest, data[row][j]);
            }
        }
        return highest;
    }

    public static double getLowestInRow(double[][] data, int row) {
        // Returns the lowest value in the specified row of the two dimensional array
        double lowest = Double.MAX_VALUE;
        if (row >= 0 && row < data.length) {
            for (int j = 0; j < data[row].length; j++) {
                lowest = Math.min(lowest, data[row][j]);
            }
        }
        return lowest;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        // Returns the highest value in the specified column of the two dimensional array
        double highest = Double.MIN_VALUE;
        if (col >= 0) {
            for (int i = 0; i < data.length; i++) {
                if (col < data[i].length) {
                    highest = Math.max(highest, data[i][col]);
                }
            }
        }
        return highest;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        // Returns the lowest value in the specified column of the two dimensional array
        double lowest = Double.MAX_VALUE;
        if (col >= 0) {
            for (int i = 0; i < data.length; i++) {
                if (col < data[i].length) {
                    lowest = Math.min(lowest, data[i][col]);
                }
            }
        }
        return lowest;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        // Returns the index of the highest value in the specified row of the two dimensional array
        int highestIndex = -1;
        if (row >= 0 && row < data.length) {
            double highest = Double.MIN_VALUE;
            for (int j = 0; j < data[row].length; j++) {
                if (data[row][j] > highest) {
                    highest = data[row][j];
                    highestIndex = j;
                }
            }
        }
        return highestIndex;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        // Returns the index of the highest value in the specified column of the two dimensional array
        int highestIndex = -1;
        if (col >= 0) {
        	double highest = Double.MIN_VALUE;
        	for (int i = 0; i < data.length; i++) {
        	if (col < data[i].length && data[i][col] > highest) {
        	highest = data[i][col];
        	highestIndex = i;
        	}
        }
   	}
        	return highestIndex;
        }

        	public static int getLowestInRowIndex(double[][] data, int row) {
        	// Returns the index of the lowest value in the specified row of the two dimensional array
        	int lowestIndex = -1;
        	if (row >= 0 && row < data.length) {
        	double lowest = Double.MAX_VALUE;
        	for (int j = 0; j < data[row].length; j++) {
        	if (data[row][j] < lowest) {
        	lowest = data[row][j];
        	lowestIndex = j;
        	}
        }
      }
        	return lowestIndex;
        }

        	public static int getLowestInColumnIndex(double[][] data, int col) {
        	// Returns the index of the lowest value in the specified column of the two dimensional array
        	int lowestIndex = -1;
        	if (col >= 0) {
        	double lowest = Double.MAX_VALUE;
        	for (int i = 0; i < data.length; i++) {
        	if (col < data[i].length && data[i][col] < lowest) {
        	lowest = data[i][col];
        	lowestIndex = i;
        	}
        }
     }
        	return lowestIndex;
       	}

        	public static double getAverageForRow(double[][] data, int row) {
        	// Returns the average of the elements in the specified row of the two dimensional array
        	double average = 0;
        	if (row >= 0 && row < data.length) {
        	double total = 0;
        	int count = 0;
        	for (int j = 0; j < data[row].length; j++) {
        	total += data[row][j];
        	count++;
        	}
        	if (count > 0) {
        	average = total / count;
        	}
        }
        	return average;
   	}

        	public static double getAverageForColumn(double[][] data, int col) {
        	// Returns the average of the elements in the specified column of the two dimensional array
        	double average = 0;
        	if (col >= 0) {
        	double total = 0;
        	int count = 0;
        	for (int i = 0; i < data.length; i++) {
        	if (col < data[i].length) {
        	total += data[i][col];
        	count++;
        	}
        }
        	if (count > 0) {
        	average = total / count;
        	}
      }
        	return average;
   }
        	public static double getLowestInArray(double[][] data) {
        		if (data == null || data.length == 0) {
        			throw new IllegalArgumentException("Input array is null or empty");
        		}

        		double lowest = data[0][0];

        		for (int row = 0; row < data.length; row++) {
        			for (int col = 0; col < data[row].length; col++) {
        				if (data[row][col] < lowest) {
        					lowest = data[row][col];
        				}
        			}
        		}

        		return lowest;
        	}
        	public static double getHighestInArray(double[][] data) {
        		if (data == null || data.length == 0) {
        			throw new IllegalArgumentException("Input array is null or empty");
        		}

        		double highest = data[0][0];

        		for (int row = 0; row < data.length; row++) {
        			for (int col = 0; col < data[row].length; col++) {
        				if (data[row][col] > highest) {
        					highest = data[row][col];
        				}
        			}
        		}

        		return highest;
        	}
}