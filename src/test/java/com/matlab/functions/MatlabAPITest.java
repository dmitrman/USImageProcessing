package com.matlab.functions;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mathworks.toolbox.javabuilder.MWException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "ApplicationContext.xml" }, loader = ContextLoader.class)
public class MatlabAPITest {

	@Autowired
	MatlabDecorator MatlabAPI;
	Logger  logger = Logger.getLogger(this.getClass());
	
	@Test
	public void testFFT() throws MWException {
		String imagePath="C:\\Models\\sick\\2014-09-03_204814.png";
		double samplFrequency=512.0;
		double numberSpectrLines=1024;				
		Object[] res=MatlabAPI.getFFT(imagePath, samplFrequency, numberSpectrLines);
		//assertEquals(2, res.length());		
		logger.info("testFFT(): OK");
	}
	
	@Test
	public void testWriteXLS() throws MWException {
		Object[] input={1,33,4,5};
		String sheetName="name";
		String xls_path="C:\\sample.xls";
		String cell_name="A2";
		MatlabAPI.writeXLS(xls_path,input,sheetName,cell_name);
		logger.info("testWriteXLS(): OK");
	}
}
