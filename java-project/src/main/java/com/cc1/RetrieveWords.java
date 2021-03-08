package com.cc1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RetrieveWords {

// Set to true to show outputs
static boolean printOutput = true;	
	
public static void main(String[] args) {
		// Take in an input
		Scanner scannerIn = new Scanner(System.in);
		System.out.println("Enter a Word:");
		String input = scannerIn.nextLine();
		List<String> output = GetWords(input);
		System.out.println("The output for " + input + ";");
		System.out.println(output);
		scannerIn.close();
	}
	
public static List<String> GetWords(String input) {
		
		List<String> subStringList = new ArrayList<String>();
		List<String> currentPermutationList = new ArrayList<String>();
		List<String> permutationList = new ArrayList<String>();
		List<String> finalList = new ArrayList<String>();
		
		// This method produces all different letter combinations
		if (isAlpha(input) && input.length() > 0)
		{
			subStringList = GetCombinations(input);
		}
		else
		{
			return finalList;
		}
		
        // Create an iterator for the list using iterator() method 
        Iterator<String> subStringiter 
            = subStringList.iterator(); 
        
        // Get the permutations for each of the combinations
        while(subStringiter.hasNext())
        {
        	currentPermutationList = GetPermutation(subStringiter.next());
        	permutationList.addAll(currentPermutationList);
        }
		
        if(printOutput)
          System.out.println(permutationList);
        
        // Create an iterator for the list 
        // using iterator() method 
        Iterator<String> permutationIter 
            = permutationList.iterator(); 
		
        while(permutationIter.hasNext())
        {
        	String dictionaryInput = permutationIter.next();
        	if (IsDictionary(dictionaryInput))
        	{
        		if (!finalList.contains(dictionaryInput))
        		{
        			finalList.add(dictionaryInput);
        		}
        		
        	}
        }
        
        if(printOutput)
           System.out.println(finalList);
        
        return finalList;
        
	}

// This method gets all the combinations of letters
public static List<String> GetCombinations(String str) {
	List<String> output = new ArrayList<String>();
	List<String> tmp = new ArrayList<String>();

	if (str.length() == 1) {
		output.add(str);
	} else {
		String firstPart = str.substring(0, 1);
		
		// Use Recursion
		tmp = GetCombinations(str.substring(1));
		
		output.addAll(tmp);
		
		//Every item in the List will be duplicated with the First Character appended
		int outputSize = output.size();
		for (int i=0; i < outputSize; i++)
		{
			String stringItem = String.format(firstPart + output.get(i));
			output.add(stringItem);
		}
		//Finally add the First Character by itself
		output.add(firstPart);
	}
	
	if (printOutput)
		System.out.println(output); 
	
	return output;
}

// This method determines if the string is purely alphabetic
public static boolean isAlpha(String s) {
    if (s == null) {
        return false;
    }

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
            return false;
        }
    }
    return true;
}

/**
 * List permutations of a string.
 * 
 * @param s the input string
 * @return  the list of permutations
 */
public static ArrayList<String> GetPermutation(String s) {
    // The result
    ArrayList<String> res = new ArrayList<String>();
    // If input string's length is 1, return {s}
    if (s.length() == 1) {
        res.add(s);
    } else if (s.length() > 1) {
        int lastIndex = s.length() - 1;
        // Find out the last character
        String last = s.substring(lastIndex);
        // Rest of the string
        String rest = s.substring(0, lastIndex);
        // Perform permutation on the rest string and
        // merge with the last character
        res = merge(GetPermutation(rest), last);
    }
    return res;   
    
}

/**
 * @param list a result of permutation, e.g. {"ab", "ba"}
 * @param c    the last character
 * @return     a merged new list, e.g. {"cab", "acb" ... }
 */
public static ArrayList<String> merge(ArrayList<String> list, String c) {
    ArrayList<String> res = new ArrayList<>();
    // Loop through all the string in the list
    for (String s : list) {
        // For each string, insert the last character to all possible positions
        // and add them to the new list
        for (int i = 0; i <= s.length(); ++i) {
            String ps = new StringBuffer(s).insert(i, c).toString();
            res.add(ps);
        }
    }
    return res;
}

//Small Dictionary Implementation to support tests
public static Boolean IsDictionary(String input)
{
	List<String> unsortedList=new ArrayList<>(Arrays.asList("meats", "meat", "team", "same", "teams", "mates", "mat", "mats", "pep"));
	
	if (unsortedList.contains(input))
	{
		return true;
	}
	else {
		return false;
	}
		
	
}



}
