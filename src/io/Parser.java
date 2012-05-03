package io;

import java.util.ArrayList;
import java.io.*;
import model.*;

public class Parser {

	ArrayList<ArrayList<String>> lines;
	ArrayList<Project> p;

	ProjectDB db;

	public Parser(ProjectDB db) {
		this.db = db;
		lines = new ArrayList<ArrayList<String>>();

	}

	public Parser() {
		this(null);
		p = new ArrayList<Project>();
	}

	public void parse(String fileName) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = in.readLine()) != null) {
			if (!line.matches("^\\s*(%.*$|@.*$|$)")) {
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
				if (db != null) {
					db.addProject(new Project(lineArray));
				}
				else{
					p.add(new Project(lineArray));
				}
			}
		}
	}

	public ArrayList<String> getEntries(int index) {
		return lines.get(index);
	}
	public ArrayList<Project> giveMeProject(){
		return p;
	}
}
