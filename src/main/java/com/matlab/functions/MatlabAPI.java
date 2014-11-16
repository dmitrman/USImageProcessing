package com.matlab.functions;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.mathworks.toolbox.javabuilder.MWException;

public interface MatlabAPI {	
	/* Returns 4 statistic featues: mean, variance, skewness, kurtosis */
	Object[] getStatisticalFeatures(String image_path, int window);	
	/* Read an image from file */
	Object[] readImage(String image_path);
	/* Applies homomorphic filtering */
	Object[] getHomomorphicFilter(String image_path, double sigma);
	/* Cluster feature vector */
	Object[] getFCMClustrering(Object features, int num_clusters);
	Object[] getHomomorphicFilter(int[][] image,double sigma);
}
