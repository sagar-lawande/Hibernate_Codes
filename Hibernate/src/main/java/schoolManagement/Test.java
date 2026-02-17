package schoolManagement;
public class Test{
	public static void main(String[]args) {
		
		Students std=new Students();
		Cleark ck=new Cleark();
		std.setName("sagar");
		std.setAddress("Bhusawal");
		std.setStandard(10);
		
		Students std1=new Students();
		std1.setName("rahul");
		std1.setAddress("Nashik");
		std1.setStandard(12);
		
		ck.insertData(std);
		ck.insertData(std1);
		
		System.out.println("------------------------------------------------------");
		
		ck.readData();
		

		System.out.println("------------------------------------------------------");
		
		
		
		ck.updateData(1,"Rajasthan","Rohit");

		System.out.println("------------------------------------------------------");
		
		ck.deleteData(std);

		
		
	}
}