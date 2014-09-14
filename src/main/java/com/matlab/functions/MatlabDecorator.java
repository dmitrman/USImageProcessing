package com.matlab.functions;

import org.springframework.beans.factory.annotation.Autowired;

import com.mathworks.toolbox.javabuilder.MWException;
import com.matlab.NativeAPI;

/*
 * http://www.javapractices.com/references/ReferencesAction.do;jsessionid=3874BFDEE6542D4B11574E03FBD344D7
 */

public class MatlabDecorator implements MatlabAPI{
	@Autowired
	NativeAPI matlab;
	
	public Object[] getFFT(String imagePath, double samplFrequency,
			double numberSpectrLines) throws MWException {		
		return matlab.getFFT(2, imagePath, samplFrequency,numberSpectrLines);		
	}

	@Override
	public Object[] getStatisticalFeatures(String imagePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeXLS(String path, Object[] matrix, String sheet, String cell) throws MWException {
		matlab.writeToXls(path,matrix,sheet,cell);		
	}

	@Override
	public Object[] classifyImage(String imagePath) {
	/*	try {
			Object[] res=null;
			//res=matlab.processImage(1, imagePath);
			return res;
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
		
	}
	
}
