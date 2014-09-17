package com.matlab.functions;

import java.io.IOException;

import com.mathworks.toolbox.javabuilder.MWException;

public interface MatlabAPI {

	public Object[] getFFT(String imagePath, double samplFrequency,
			double numberSpectrLines) throws MWException;

	public Object[] getStatisticalFeatures(String imagePath);
	
	public void writeXLS(String path,Object[] matrix,String sheet,String cell) throws MWException ;

	public Object[] getSpectralFeatures(String imagePath) throws MWException;
	
	public void getSpectralFeaturesWindow(String imagePath,int window_size) throws MWException,IOException;
}
