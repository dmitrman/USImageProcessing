package com.matlab.functions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;

import com.mathworks.toolbox.javabuilder.*;
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
		// return matlab.processImage(3, imagePath);
		return matlab.processImageMatrix(3,
				matlab.getMedianFiltered(1, imagePath));
	}

	@Override
	public void getSpectralFeaturesWindow(String imagePath, int window_size)
			throws MWException, IOException {
		MWNumericArray filt = (MWNumericArray) (matlab.getMedianFiltered(1,
				imagePath)[0]);
		double[][] img = toTwoDimensionalArray(filt);
		//printArray(img);
		//System.out.println(filt);
	//	System.out.println("---------------------------");
		//printArray(getWindowImage(img, 0, window_size, window_size));
		window_size=128;
		int iw = img.length;
		int ih = img[0].length;
		for (int i = 0; i <= ih - window_size; i += window_size) {
			for (int j = 0; j <= iw - window_size; j += window_size) {
				Object[] res = matlab.processImageMatrix(3,
						getWindowImage(img, i, j, window_size));
				System.out.println("-- " + res[0] + "  " + res[1]);

			}
		}

	}

	private double[][] getWindowImage(double[][] img, int i_start, int j_start,
			int window_size) {
		double[][] w = new double[window_size][window_size];
		/* формирование массива изображения в окне */
		for (int i = i_start; i < i_start + window_size; i++) {
			for (int j = j_start; j < j_start + window_size; j++) {
				//System.out.println(" " + i);
			//	System.out.println(" " + j);
				w[i - i_start][j - j_start] = img[i][j];
			}
		}
		return w;
	}

	private double[][] toTwoDimensionalArray(MWNumericArray mas) {		
		int x = 0;
		int y = 0;		
		int[] d=mas.getDimensions();
		double[][] res = new double[d[0]][d[1]];
		int s=0;
		for (int i = 0; i < d[0]*d[1]; i++)
		{			
			res[y][x]=mas.getDouble(i+1);
			y++;
			s++;
			if(y==d[1]) {y=0;x++;}			
		}
	
		return res;
	}

	private void printArray(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
