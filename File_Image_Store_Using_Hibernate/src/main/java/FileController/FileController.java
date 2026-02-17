package FileController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.hibernate.Session;
import org.hibernate.Transaction;

import FileInsert.ImageInsert;
import HibernateUtil.HibernateUtil;


public class FileController {
	
	public void insertImage(ImageInsert ii) throws Exception {
	Session session=HibernateUtil.getSessionFactory().openSession();
	Transaction transaction =session.beginTransaction();
	FileInputStream fis=new FileInputStream("src/main/java/java.jpg");
	byte[]data=new byte[fis.available()];
	fis.read(data);
	
	 ii.setFileData(data);
	session.save(ii);
	transaction.commit();
	
	System.out.println("Image insert Sucessfully");

}
}
