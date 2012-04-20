package test;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.ArrayList;

import io.Parser;
import model.*;

public class TestParser {

	public TestParser() {

	}

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {

	}

	@Test
	public void testSimple() {
		File file = null;
		try {
			file = new File("simple_test.txt");
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fileWriter);
			output(out, "% dkfjkdfjkd");
			output(out, "% dkfjkdfjkd");
			output(out, "");
			output(out, "");
			output(out, "");
			output(out, "% ");
			output(out, "% ");
			output(out, "% dkfjkdfjkd");
			output(out, "Nominal,High,Very_High,Nominal,Nominal,Low,Nominal,High,Nominal,Very_High,Low,Nominal,High,Nominal,Low,70,278,                           %      instance number:        1,");
			output(out, "Very_High,High,High,Very_High,Very_High,Nominal,Nominal,Very_High,Very_High,Very_High,Nominal,High,High,High,Low,227,1181,               %      instance number:        2,");
			out.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		ArrayList<String> expectedEntries1 = new ArrayList();
		expectedEntries1.add("Nominal");
		expectedEntries1.add("High");
		expectedEntries1.add("Very_High");
		expectedEntries1.add("Nominal");
		expectedEntries1.add("Nominal");
		expectedEntries1.add("Low");
		expectedEntries1.add("Nominal");
		expectedEntries1.add("High");
		expectedEntries1.add("Nominal");
		expectedEntries1.add("Very_High");
		expectedEntries1.add("Low");
		expectedEntries1.add("Nominal");
		expectedEntries1.add("High");
		expectedEntries1.add("Nominal");
		expectedEntries1.add("Low");
		expectedEntries1.add("70");
		expectedEntries1.add("278");

		ArrayList<String> expectedEntries2 = new ArrayList();
		expectedEntries2.add("Very_High");
		expectedEntries2.add("High");
		expectedEntries2.add("High");
		expectedEntries2.add("Very_High");
		expectedEntries2.add("Very_High");
		expectedEntries2.add("Nominal");
		expectedEntries2.add("Nominal");
		expectedEntries2.add("Very_High");
		expectedEntries2.add("Very_High");
		expectedEntries2.add("Very_High");
		expectedEntries2.add("Nominal");
		expectedEntries2.add("High");
		expectedEntries2.add("High");
		expectedEntries2.add("High");
		expectedEntries2.add("Low");
		expectedEntries2.add("227");
		expectedEntries2.add("1181");

		Parser parser = new Parser(new MockDB());
		try{
		parser.parse("simple_test.txt");
		} catch(IOException e){
			fail("Caught IOException");
		}
		ArrayList<String> realEntries1 = parser.getEntries(0);	
		ArrayList<String> realEntries2 = parser.getEntries(1);
		assertEquals(expectedEntries1.size(), realEntries1.size());	
		assertEquals(expectedEntries2.size(), realEntries2.size());

		for(int i = 0; i < realEntries1.size(); i++){
			assertEquals(expectedEntries1.get(i), realEntries1.get(i));
		}
		for(int i = 0; i < realEntries2.size(); i++){
			assertEquals(expectedEntries2.get(i), realEntries2.get(i));
		}
		file.delete();
	}

	private void output(BufferedWriter out, String text)throws IOException {
		out.write(text);
		out.newLine();
	}
}
