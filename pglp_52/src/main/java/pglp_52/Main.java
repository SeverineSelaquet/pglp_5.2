import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		
		try {
			Personnel p1 = new Personnel
					.Builder("Toto", "Tata", 2)
					.addFunction("Directeur")
					.build();
			
			Personnel p2 = new Personnel
					.Builder("Tato", "Tota", 1)
					.addFunction("Employe")
					.build();
			
			PersonnelGroup pg1 = new PersonnelGroup("PG1");
			
			pg1.add(p1);
			pg1.add(p2);
			
			System.out.println(pg1.getDescription());
			
			FileOutputStream fos = new FileOutputStream("personnelgroup.serial");

			ObjectOutputStream oos= new ObjectOutputStream(fos);
			try {
				oos.writeObject(pg1); 
				oos.flush();
				System.out.println(pg1 + " a ete serialise");
			} finally {
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
