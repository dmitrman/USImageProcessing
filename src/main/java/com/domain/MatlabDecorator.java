package com.domain;

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
	public Object[] getStatisticalFeatures(Object[] image, int window) {
		try {
			return matlab.getStatisticFeatures(1,image[0],window);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object[] getDFTFeatures(Object[] image, int window) {
		try {
			return matlab.getDFTFeatures(1,image[0],window);
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

	public Object[] getHomomorphicFilter(Object[] image,double sigma) {
		try {
			return matlab.getHomomorphicFilter(1, image[0],sigma);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Object[] getFCMClustrering(Object[] features, int mask,int w,int h) {
		try {
			return matlab.getFCMClustrering(4,features[0],mask,w,h);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
