package test;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import io.Parser;
import model.*;
import model.Project.Attribute;

public class TestQR03 {

	@Test
	public void testQR03() {
		Parser parser = new Parser();
		try {
			parser.parse("testdata/ETSF01-Data-Text.txt");
		} catch (IOException e) {
			fail("Parser failed to read test file..");
		}
		ArrayList<Project> projects = parser.giveMeProject();
		int numbergreat = 0;
		for (int i = 0; i < projects.size(); i++) {
			ProjectDB db = new CocoMoDB();
			db.setThreshold(0.35);
			Project temp = projects.remove(0);
			for (Project proj : projects) {
				db.addProject(proj);
			}
			List<Result> simProj = db.similarProjects(temp);
			double effort = temp.calculateEffort((ArrayList<Result>) simProj);
			double act_effort = temp.getAttribute(Attribute.ACT_EFFORT);
			double quota = effort / act_effort;
			if (quota >= 0.7 && quota <= 1.3){
				numbergreat++;
			} else {
				System.out.println("Found bad project not in +-30% range.");
			}
			projects.add(temp);
		}
		double passes = ((double) numbergreat)/projects.size();
		System.out.println("passes = " + passes);
		System.out.println("Numbergreat = " + numbergreat + " of " + projects.size() + " projects." );
		if ( passes < 0.8) {
			fail("QE03 not fulfilled.");
		}
	}
}
