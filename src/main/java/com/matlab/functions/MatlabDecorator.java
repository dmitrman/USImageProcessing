package com.matlab.functions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;

import com.mathworks.toolbox.javabuilder.MWException;
import com.matlab.NativeAPI;

/*
 * http://www.javapractices.com/references/ReferencesAction.do;jsessionid=3874BFDEE6542D4B11574E03FBD344D7
 */

public class MatlabDecorator implements MatlabAPI {
	@Autowired
	NativeAPI matlab;

	public Object[] getFFT(String imagePath, double samplFrequency,
			double numberSpectrLines) throws MWException {
		return matlab.getFFT(2, imagePath, samplFrequency, numberSpectrLines);
	}

	@Override
	public Object[] getStatisticalFeatures(String imagePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeXLS(String path, Object[] matrix, String sheet, String cell)
			throws MWException {
		matlab.writeToXls(path, matrix, sheet, cell);
	}

	@Override
	public Object[] getSpectralFeatures(String imagePath) throws MWException {
		//return matlab.processImage(3, imagePath);
		return matlab.processImageMatrix(3, matlab.getMedianFiltered(1, imagePath));
	}

	@Override
	public void getSpectralFeaturesFromImages(String[] images)
			throws MWException {
		final String xlsx_path = "C:\\out.xlsx";
		int start = 2;
		for (int i = 0; i < images.length; i++) {
			Object[] res = getSpectralFeatures(images[i]);
			writeXLS(xlsx_path, new Object[] { res[0], res[1] }, "spectral",
					"A" + String.valueOf(start + i + 3));
		}

	}

	@Override
	public void getSpectralFeaturesWindow(String imagePath, int window_size)
			throws MWException, IOException {
		double[][] img=(double[][]) matlab.getMedianFiltered(1, imagePath);
		int iw = img.length;
		int ih = img[0].length;
		
		for (int i = 0; i < ih; i+=window_size) {
			for (int j = 0; j < iw; j+=window_size) {
				double pixel=img[i][j];
				getWindowImage(img,i,j,window_size);
				int a = (int) (((c & 16711680) >> 16) * 0.3
						+ ((c & 65280) >> 8) * 0.59 + ((c & 255)) * 0.11);
				img1.setRGB(j, i, GetColorFromRGB(a, a, a));

			}
		}
*/
	}

	private void getWindowImage(double[][] img, int i_start, int j_start,int window_size) {
		for (int i=0;i<i+window_size;i++){
			for (int j=0;j<j+window_size;j++) {
				
			}
		}
		
	}

}
