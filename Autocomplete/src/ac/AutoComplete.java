package ac;

import java.util.Arrays;

/*
 * An immutable data type that provides auto complete functionality for a 
 * given set of string and weights, using Term and BinarySearchDeluxe.
 * 
 * @author Henry Doan
 * @version October 13, 2018
 */
public class AutoComplete {
	public Term[] termsArr;
	
	/*
	 * Initialize the data structure from the 
	 * given array of terms.
	 * 
	 * @param terms -- an incoming array to have initialize.
	 */
	public AutoComplete(Term[] terms) {
		// corner case if terms are null
		if ( terms == null ) {
			throw new java.lang.NullPointerException();
		}
		
		termsArr = terms;
		
		// sort the array
		Arrays.sort(termsArr);
	}
	
	/*
	 * Return all terms that start with the 
	 * given prefix, in descending order of weight.
	 * 
	 * @param prefix -- a given prefix that the terms will match with.
	 * @return  -- a term[] that starts with the prefix in descending order of weight.
	 */
	public Term[] allMatches(String prefix) {
		// corner case for if the prefix is null
		if ( prefix == null ) {
			throw new java.lang.NullPointerException();
		}
		
		// number of times of occurrence 
		int numOfMatch = numberOfMatches(prefix);
		
		// new array to hold the results
		Term[] results = new Term[numOfMatch];
		
		// term being searched
    	Term prefixTerm = new Term(prefix, 0);

    	// search the array for the prefix
		int firstSearch = BinarySearchDeluxe.firstIndexOf( termsArr, prefixTerm, Term.byPrefixOrder(prefix.length()));
    	int lastSearch = BinarySearchDeluxe.lastIndexOf( termsArr, prefixTerm, Term.byPrefixOrder(prefix.length()));
    	
    	// if there is no results in the array
    	if (firstSearch == -1 || lastSearch == -1) {
    		System.out.println("No matches");
    	}
    	
    	// copy all matches 
    	for (int i = 0; i < numOfMatch; i++) {
    		results[i] = termsArr[firstSearch + i];
    	}
    	
    	// sort in reverse order by weight
		Arrays.sort(results, Term.byReverseWeightOrder());
		
		// return the array of the search terms in a new array sorted by reverse weight
		return results;	
	}
	
	/*
	 * Return the number of terms that start 
	 * with the given prefix.
	 * 
	 * @param prefix -- a given prefix that the terms will match with.
	 * @return numOfMatches -- number of terms that start with the prefix.
	 */
    public int numberOfMatches(String prefix) {
    	// corner case of if the prefix is null
    	if ( prefix == null ) {
			throw new java.lang.NullPointerException();
		}
    	
    	// makes a new term with the prefix and weight
    	Term prefixTerm = new Term(prefix, 0);
    	
    	// find the number of occurrence of the prefix in the terms array.
    	int firstSearch = BinarySearchDeluxe.firstIndexOf( termsArr, prefixTerm, Term.byPrefixOrder(prefix.length()));
    	int lastSearch = BinarySearchDeluxe.lastIndexOf( termsArr, prefixTerm, Term.byPrefixOrder(prefix.length()));

    	// calculate the number of occurrence
    	int numOfMatches = lastSearch - firstSearch + 1;
    	
    	// return the number
		return numOfMatches;
    }
    
    public static void main(String[] args) {

//        // read in the terms from a file
//        String filename = args[0];
//        In in = new In(filename);
//        int N = in.readInt();
//        Term[] terms = new Term[N];
//        for (int i = 0; i < N; i++) {
//            double weight = in.readDouble();       // read the next weight
//            in.readChar();                         // scan past the tab
//            String query = in.readLine();          // read the next query
//            terms[i] = new Term(query, weight);    // construct the term
//        }
//
//        // read in queries from standard input and print out the top k matching terms
//        int k = Integer.parseInt(args[1]);
//        AutoComplete autocomplete = new AutoComplete(terms);
//        while (StdIn.hasNextLine()) {
//            String prefix = StdIn.readLine();
//            Term[] results = autocomplete.allMatches(prefix);
//            for (int i = 0; i < Math.min(k, results.length); i++)
//                StdOut.println(results[i]);
//        }
    	// create random test terms
    	Term[] testTermArr = {
    			new Term("Abc", 1), 
    			new Term("Acb", 2), 
    			new Term("Bac", 3), 
    			new Term("Bca", 4), 
    			new Term("Cab", 5),
				new Term("Cba", 6)
		};
    	
		AutoComplete autocompleteTest = new AutoComplete(testTermArr);
		
		// test the number of matches with a prefix
		int numMatches = autocompleteTest.numberOfMatches("A");
		System.out.println("Number of items that start with prefix 'A': " + numMatches);

		// array for testing the all matches with a prefix
		Term[] testTermArr2 = autocompleteTest.allMatches("A");

		// display all the info for the matches
		for (Term term : testTermArr2) {
			System.out.println(term);
		}
    }

}
