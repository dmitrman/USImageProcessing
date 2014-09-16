import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import javax.imageio.ImageIO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.mathworks.toolbox.javabuilder.MWException;
import com.matlab.NativeAPI;
import com.matlab.functions.MatlabAPI;
import com.matlab.functions.MatlabDecorator;

public class MainClass extends Application {

	public static void main(String[] args) throws MWException, IOException {
					
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		NativeAPI a=(NativeAPI) applicationContext.getBean("NativeAPI");
	//	Application.launch(MainClass.class, (java.lang.String[])null);
		Object[] input={1.0,33.0,4.0,5.0};
		Object[] res=null;
		/* median filtration must be done before */
		res=a.processImage(3, "C:\\2.bmp");		
		System.out.println("\nVar="+res[0]);
		System.out.println("Max="+res[1]);	
		
		
	
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource(
				"fxmls/MainView.fxml"));
		Scene scene = new Scene(root, 300, 275);
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}
	
	/*
     * Automatically sets the path to java library
     */
  /*  private static void setJavaLibraryPath() throws NoSuchFieldException,
	    SecurityException, IllegalArgumentException, IllegalAccessException {

	String[] parts = System.getProperty("java.class.path").split(";");
	System.setProperty("java.library.path", parts[0]);
	Field fieldSysPath;
	fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
	fieldSysPath.setAccessible(true);
	fieldSysPath.set(null, null);
	System.out.println(System.getProperty("java.library.path"));
    }

    // trick to set Java library path in runtime
    static {
	try {
	    setJavaLibraryPath();
	} catch (NoSuchFieldException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SecurityException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	System.loadLibrary("NNetwork"); /* (2) */
    //}
}
