package com.adityakrmishra.ml.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataLoader {

    private List<String[]> data;

    public DataLoader() {
        data = new ArrayList<>();
    }

    /**
     * Loads data from a CSV file
     *
     * @param filePath the path to the CSV file
     * @throws IOException if the file cannot be read
     */
    public void loadCSV(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            data.add(values);
        }
        br.close();
    }

    /**
     * Returns the data loaded from the CSV file
     *
     * @return a list of string arrays representing the data
     */
    public List<String[]> getData() {
        return data;
    }

    /**
     * Prints the loaded data to the console
     */
    public void printData() {
        for (String[] row : data) {
            for (String value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Converts a column of data to a double array
     *
     * @param columnIndex the index of the column to convert
     * @return an array of doubles representing the column data
     */
    public double[] getColumnAsDoubleArray(int columnIndex) {
        double[] columnData = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            columnData[i] = Double.parseDouble(data.get(i)[columnIndex]);
        }
        return columnData;
    }

    /**
     * Converts a column of data to a string array
     *
     * @param columnIndex the index of the column to convert
     * @return an array of strings representing the column data
     */
    public String[] getColumnAsStringArray(int columnIndex) {
        String[] columnData = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            columnData[i] = data.get(i)[columnIndex];
        }
        return columnData;
    }

    /**
     * Normalizes the data in a specified column
     *
     * @param columnIndex the index of the column to normalize
     * @return an array of doubles representing the normalized column data
     */
    public double[] normalizeColumn(int columnIndex) {
        double[] columnData = getColumnAsDoubleArray(columnIndex);
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double value : columnData) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        for (int i = 0; i < columnData.length; i++) {
            columnData[i] = (columnData[i] - min) / (max - min);
        }
        return columnData;
    }

    /**
     * Normalizes all columns of the dataset
     */
    public void normalizeData() {
        int numColumns = data.get(0).length;
        for (int i = 0; i < numColumns; i++) {
            double[] normalizedColumn = normalizeColumn(i);
            for (int j = 0; j < data.size(); j++) {
                data.get(j)[i] = String.valueOf(normalizedColumn[j]);
            }
        }
    }

    /**
     * Splits the dataset into training and test sets
     *
     * @param trainRatio the ratio of training data (e.g., 0.8 for 80% training data)
     * @return a pair of lists representing the training and test sets
     */
    public List<String[]>[] splitData(double trainRatio) {
        int trainSize = (int) (data.size() * trainRatio);
        List<String[]> trainData = new ArrayList<>(data.subList(0, trainSize));
        List<String[]> testData = new ArrayList<>(data.subList(trainSize, data.size()));
        List<String[]>[] splitData = new ArrayList[2];
        splitData[0] = trainData;
        splitData[1] = testData;
        return splitData;
    }

    /**
     * Saves the dataset to a new CSV file
     *
     * @param filePath the path to the new CSV file
     * @throws IOException if the file cannot be written
     */
    public void saveCSV(String filePath) throws IOException {
        // Placeholder for CSV saving logic
    }

    // Additional methods and functionalities can be added here
    
    /**
     * Shuffles the rows of the dataset
     */
    public void shuffleData() {
        Collections.shuffle(data);
    }

    /**
     * Imputes missing values in the dataset with the column mean
     */
    public void imputeMissingValues() {
        int numColumns = data.get(0).length;
        for (int i = 0; i < numColumns; i++) {
            double[] columnData = getColumnAsDoubleArray(i);
            double sum = 0.0;
            int count = 0;
            for (double value : columnData) {
                if (!Double.isNaN(value)) {
                    sum += value;
                    count++;
                }
            }
            double mean = sum / count;
            for (int j = 0; j < data.size(); j++) {
                if (Double.isNaN(columnData[j])) {
                    data.get(j)[i] = String.valueOf(mean);
                }
            }
        }
    }

    /**
     * Scales the data to a specified range
     *
     * @param min the minimum value of the range
     * @param max the maximum value of the range
     */
    public void scaleData(double min, double max) {
        int numColumns = data.get(0).length;
        for (int i = 0; i < numColumns; i++) {
            double[] columnData = getColumnAsDoubleArray(i);
            double colMin = Double.MAX_VALUE;
            double colMax = Double.MIN_VALUE;
            for (double value : columnData) {
                if (value < colMin) {
                    colMin = value;
                }
                if (value > colMax) {
                    colMax = value;
                }
            }
            for (int j = 0; j < columnData.length; j++) {
                columnData[j] = min + (columnData[j] - colMin) * (max - min) / (colMax - colMin);
                data.get(j)[i] = String.valueOf(columnData[j]);
            }
        }
    }

    /**
     * Encodes categorical data as one-hot vectors
     *
     * @param columnIndex the index of the column to encode
     * @return a list of one-hot encoded vectors
     */
    public List<double[]> oneHotEncodeColumn(int columnIndex) {
        List<double[]> encodedData = new ArrayList<>();
        List<String> uniqueValues = new ArrayList<>();
        for (String[] row : data) {
            if (!uniqueValues.contains(row[columnIndex])) {
                uniqueValues.add(row[columnIndex]);
            }
        }
        for (String[] row : data) {
            double[] oneHotVector = new double[uniqueValues.size()];
            int index = uniqueValues.indexOf(row[columnIndex]);
            oneHotVector[index] = 1.0;
            encodedData.add(oneHotVector);
        }
        return encodedData;
    }

    /**
     * Extracts unique values from a specified column
     *
     * @param columnIndex the index of the column to extract unique values from
     * @return a list of unique values
     */
    public List<String> getUniqueValues(int columnIndex) {
        List<String> uniqueValues = new ArrayList<>();
        for (String[] row : data) {
            if (!uniqueValues.contains(row[columnIndex])) {
                uniqueValues.add(row[columnIndex]);
            }
        }
        return uniqueValues;
    }

    /**
     * Filters rows based on a specified condition
     *
     * @param columnIndex the index of the column to filter by
     * @param value the value to filter for
     * @return a list of rows that match the condition
     */
    public List<String[]> filterRows(int columnIndex, String value) {
        List<String[]> filteredData = new ArrayList<>();
        for (String[] row : data) {
            if (row[columnIndex].equals(value)) {
                filteredData.add(row);
            }
        }
        return filteredData;
    }

    /**
     * Merges this dataset with another dataset
     *
     * @param otherData the other dataset to merge with
     */
    public void mergeData(List<String[]> otherData) {
        data.addAll(otherData);
    }

    /**
     * Returns a transposed version of the dataset
     *
     * @return a transposed list of string arrays
     */
    public List<String[]> transposeData() {
        int numRows = data.size();
        int numCols = data.get(0).length;
        List<String[]> transposedData = new ArrayList<>();
       for (int i = 0; i < numCols; i++) {
    String[] transposedRow = new String[numRows];
    for (int j = 0; j < numRows; j++) {
        transposedRow[j] = data.get(j)[i];
    }
    transposedData.add(transposedRow);
}
return transposedData;
