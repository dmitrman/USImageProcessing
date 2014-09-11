package com.matlab.functions;

import com.mathworks.toolbox.javabuilder.MWException;

public interface MatlabAPI {

	public Object[] getFFT(String imagePath, double samplFrequency,
			double numberSpectrLines) throws MWException;

	public Object[] getStatisticalFeatures(String imagePath);
	
	public void writeXLS(String path,Object[] matrix,String sheet,String cell) throws MWException ;
}
