package io;

import java.util.ArrayList;
import java.io.*;

public class Parser {

	ArrayList<ArrayList<String>> lines;

	public Parser() {
		lines = new ArrayList<ArrayList<String>>();
		
	}

	public void parse(String fileName){
		try {
			BufferedReader in  = new BufferedReader(new FileReader(fileName));
			System.out.println("correct file");
			String line;
			while((line = in.readLine()) != null) {
				System.out.println("line read");
				if(!line.matches("^\\s*(%.*$|@.*$|$)")) {
					System.out.println("if entered");
					ArrayList<String> lineArray = new ArrayList<String>();
					String[] parts = line.split(",");
					boolean commentFound = false;
					int i = 0;
					while (!commentFound && i < parts.length) {
						if (parts[i].matches("^\\s*%.*")) {
							commentFound = true;
						} else {
							++i;
						}
					}

					int end = parts.length;

					if (commentFound) {
						end = i;
					} 
					
						for (int j = 0; j < end; ++j) {
						lineArray.add(parts[j]);
					}
					
					lines.add(lineArray);

				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public ArrayList<String> getEntries(int index){
		return lines.get(index);		
	}
}
