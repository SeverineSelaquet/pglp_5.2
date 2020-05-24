import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AnnuaireTest {
	
	public Personnel p1;
	public PersonnelGroup pg1;

	@Before
	public void setUp() throws Exception {
		Personnel p1 = new Personnel
				.Builder("Toto", "Tata")
				.addFunction("Directeur")
				.build();
		PersonnelGroup pg1 = new PersonnelGroup("PG1");
	}

	@Test
	public void GroupTest() {
		pg1.add(p1);
		assertTrue(pg1.contains(p1));
	}

}
