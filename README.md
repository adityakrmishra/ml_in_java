# ML_in_Java

# This project is in progress (I created only a structure of this project and planned what is in project see below)
if you want you can contribute according to project described below by opening a pull request
on the time of contributing also erdit contribute.md


This project is a collection of machine learning algorithms and utilities implemented in Java. It includes various models, evaluation metrics, and cross-validation techniques to help you build and evaluate machine learning models efficiently.

## Overview

The project is organized into the following components:

- DataLoader: Utility class for loading and preprocessing data.
- MathUtils: Contains mathematical utility functions.
- LinearRegression: Implementation of linear regression.
- DecisionTree: Implementation of a decision tree classifier.
- GradientDescent: Gradient descent optimization algorithm.
- KMeansClustering: Implementation of the k-means clustering algorithm.
- CrossValidation: Cross-validation utilities for model evaluation.
- Metrics: Evaluation metrics for regression, classification, and clustering.


## Features

- DataLoader:
  - `loadCSV(String filePath)`: Loads data from a CSV file.

- MathUtils:
  - `mean(double[] values)`: Calculates the mean of an array of doubles.
  - `standardDeviation(double[] values)`: Calculates the standard deviation of an array of doubles.

- LinearRegression:
  - `fit(double[][] X, double[] y)`: Fits the linear regression model.
  - `predict(double[][] X)`: Predicts target values using the fitted model.

- DecisionTree:
  - `fit(double[][] X, double[] y)`: Fits the decision tree classifier.
  - `predict(double[][] X)`: Predicts target values using the fitted classifier.
  - `prune(int maxDepth)`: Prunes the decision tree to the specified maximum depth.

- GradientDescent:
  - `fit(double[][] X, double[] y)`: Fits the model using gradient descent.
  - `predict(double[][] X)`: Predicts target values using the fitted model.
  - `fitPolynomial(double[][] X, double[] y, int degree)`: Performs polynomial regression.

- KMeansClustering:
  - `fit(double[][] X)`: Fits the k-means clustering model.
  - `predict(double[][] X)`: Predicts cluster labels for the input features.
  - `getCentroids()`: Returns the centroids of the clusters.
  - `calculateSSE()`: Calculates the sum of squared errors for the clusters.

- CrossValidation:
  - `kFoldCrossValidation(Model model, double[][] X, double[] y, int k)`: Performs k-fold cross-validation.
  - `stratifiedKFoldCrossValidation(Model model, double[][] X, double[] y, int k)`: Performs stratified k-fold cross-validation.
  - `leaveOneOutCrossValidation(Model model, double[][] X, double[] y)`: Performs leave-one-out cross-validation.
  - `randomSplitCrossValidation(Model model, double[][] X, double[] y, double testSize)`: Performs random split cross-validation.
  - `monteCarloCrossValidation(Model model, double[][] X, double[] y, int numSplits, double testSize)`: Performs Monte Carlo cross-validation.
  - `bootstrapCrossValidation(Model model, double[][] X, double[] y, int numSamples)`: Performs bootstrap cross-validation.

- Metrics:
  - `meanSquaredError(double[] yTrue, double[] yPred)`: Calculates mean squared error for regression problems.
  - `rootMeanSquaredError(double[] yTrue, double[] yPred)`: Calculates root mean squared error for regression problems.
  - `meanAbsoluteError(double[] yTrue, double[] yPred)`: Calculates mean absolute error for regression problems.
  - `rSquared(double[] yTrue, double[] yPred)`: Calculates R-squared for regression problems.
  - `accuracy(double[] yTrue, double[] yPred)`: Calculates accuracy for classification problems.
  - `precision(double[] yTrue, double[] yPred)`: Calculates precision for classification problems.
  - `recall(double[] yTrue, double[] yPred)`: Calculates recall for classification problems.
  - `f1Score(double[] yTrue, double[] yPred)`: Calculates F1 score for classification problems.
  - `confusionMatrix(double[] yTrue, double[] yPred)`: Calculates the confusion matrix for classification problems.
  - `aucRoc(double[] yTrue, double[] yPred)`: Calculates the AUC-ROC score for binary classification problems.
  - `matthewsCorrelationCoefficient(double[] yTrue, double[] yPred)`: Calculates the Matthews correlation coefficient for binary classification problems.
  - `precisionRecallF1MultiClass(double[] yTrue, double[] yPred)`: Calculates precision, recall, and F1 score for each class in a multi-class classification problem.
  - `adjustedRandIndex(double[] labelsTrue, double[] labelsPred)`: Computes the Adjusted Rand Index for clustering evaluation.
  - `silhouetteScore(double[][] X, double[] labels)`: Computes the Silhouette Score for clustering evaluation.
  - `homogeneityScore(double[] labelsTrue, double[] labelsPred)`: Computes the Homogeneity score for clustering evaluation.
  - `completenessScore(double[] labelsTrue, double[] labelsPred)`: Computes the Completeness score for clustering evaluation.
  - `vMeasureScore(double[] labelsTrue, double[] labelsPred)`: Computes the V-Measure score for clustering evaluation.
  - `mutualInformationScore(double[] labelsTrue, double[] labelsPred)`: Computes the Mutual Information score for clustering evaluation.
  - `normalizedMutualInformationScore(double[] labelsTrue, double[] labelsPred)`: Computes the Normalized Mutual Information score for clustering evaluation.
  - `randIndex(double[] labelsTrue, double[] labelsPred)`: Computes the Rand Index for clustering evaluation.
  - `fowlkesMallowsIndex(double[] labelsTrue, double[] labelsPred)`: Computes the Fowlkes-Mallows Index for clustering evaluation.
  - `jaccardIndex(double[] labelsTrue, double[] labelsPred)`: Computes the Jaccard Index for clustering evaluation.
  - `meanSquaredLogarithmicError(double[] yTrue, double[] yPred)`: Computes the Mean Squared Logarithmic Error for regression problems.
  - `explainedVariance(double[] yTrue, double[] yPred)`: Computes the Explained Variance Score for regression problems.
  - `medianAbsoluteError(double[] yTrue, double[] yPred)`: Computes the Median Absolute Error for regression problems.
  - `hammingLoss(double[] yTrue, double[] yPred)`: Computes the Hamming Loss for classification problems.

## Usage

To use these classes and methods, you can import the respective classes into your Java code and create instances of the models or call the utility methods as needed.

