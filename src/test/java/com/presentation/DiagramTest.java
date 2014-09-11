package com.presentation;

import javafx.scene.chart.XYChart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.matlab.functions.MatlabDecorator;
import com.presentation.charts.LineChartSample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "ApplicationContext.xml" }, loader = ContextLoader.class)
public class DiagramTest {

	//@Autowired
	LineChartSample lineDiafram=new LineChartSample();
	@Autowired
	MatlabDecorator MatlabAPI;
	
	@Test
	public void testFFTDiagram() throws MWException {
		String imagePath="C:\\Models\\sick\\2014-09-03_204814.png";
		double samplFrequency=512.0;
		double numberSpectrLines=1024;				
		Object[] res=MatlabAPI.getFFT(imagePath, samplFrequency, numberSpectrLines);
		double[] f = ((MWNumericArray) res[0]).getDoubleData();
		double[] r = ((MWNumericArray) res[1]).getDoubleData();
		XYChart.Series series = new XYChart.Series();
		for (int i=0;i<f.length;i++){
			series.getData().add(new XYChart.Data(f[i], r[i]));
		}
		lineDiafram.showLineChart(series);
		lineDiafram.main((java.lang.String[])null);
		
	}
}
