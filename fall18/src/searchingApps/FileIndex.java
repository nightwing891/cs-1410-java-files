package searchingApps;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

public class FileIndex {
	private FileIndex(){ }
	
	public static void main(String[] args) {
		ST<String, SET<File>> st = new ST<String, SET<File>>();

		StdOut.println("Indexing files"); 
		for(String filename : args) { 
			StdOut.println("  " + filename);
			File file = new File(filename);
			In in = new In(file);
			while(!in.isEmpty()) {
				String word = in.readString();
				if (!st.contains(word)) st.put(word, new SET<File>());
				SET<File>set = st.get(word);
				set.add(file);
			}
		}
		
		while(!StdIn.isEmpty()) {
			String query = StdIn.readString();
			if(st.contains(query)) {
				SET<File>set = st.get(query);
				
				for(File file : set) {
					StdOut.println("  " + file.getName());
				}
			}
		}
	}
}
