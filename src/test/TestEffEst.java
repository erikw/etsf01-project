package test;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.ArrayList;

import model.*;
import java.util.*;


public class TestEffEst {
	Project current;
	Project ret1;
	Project ret2;
	Map<Double, Project> similarProjects;
		
	public TestEffEst() {

	}

	@Before
	public void setUp() {
		current = new Project(0, 150);
		ret1 = new Project(1000, 200);
		ret2 = new Project(950, 175);

		similarProjects = new HashMap<Double, Project>();
		similarProjects.put(0.9, ret1);
		similarProjects.put(0.5, ret2);
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testSimple() {
		assertEquals(773, current.calculateEffort(similarProjects), 0.5);
	}
}
