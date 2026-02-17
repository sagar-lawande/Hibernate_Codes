package Test;

import java.io.File;
import java.nio.file.Files;

import FileController.FileController;
import FileInsert.ImageInsert;

public class Test {
	
	public static void main(String[]args) throws Exception {
		
		ImageInsert ii=new ImageInsert();
		ii.setImageName("Java");
		FileController fl=new FileController();
		fl.insertImage(ii);
		
		
	}

}
