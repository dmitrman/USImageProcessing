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

	@Override
	public Object[] getStatisticalFeatures(String image_path, int window) {
		try {
			return matlab.getStatisticFeatures(1,matlab.readImage(1, image_path)[0],window);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object[] readImage(String image_path) {
		try {
			return matlab.readImage(1, image_path);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object[] getHomomorphicFilter(String image_path,double sigma) {
		try {
			return matlab.getHomomorphicFilter(1, readImage(image_path)[0],sigma);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object[] getHomomorphicFilter(int[][] image,double sigma) {
		try {
			return matlab.getHomomorphicFilterFromArray(1, image,sigma);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Object[] getFCMClustrering(Object features, int num_clusters) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
