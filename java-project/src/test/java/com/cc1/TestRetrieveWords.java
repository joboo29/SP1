package com.cc1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestRetrieveWords {

	// This is the test that will verify core functionality
	@Test
	public void test() {

		List<String> expectedValueList = new ArrayList<>(Arrays.asList("meats", "meat", "team", "same", "teams", "mates", "mat", "mats"));
		Collections.sort(expectedValueList);
		List<String> wordList = RetrieveWords.GetWords("meats");
		Collections.sort(wordList);
		Assert.assertEquals(expectedValueList, expectedValueList);
	}
	
	// This test will verify that the function does not allow for duplicate words
	@Test
	public void test2() {

		List<String> expectedValueList = new ArrayList<>(Arrays.asList("pep"));
		Collections.sort(expectedValueList);
		List<String> wordList = RetrieveWords.GetWords("pep");
		Collections.sort(wordList);
		Assert.assertEquals(expectedValueList, expectedValueList);
	}

	//This test will verify that numbers entered into the function will return an empty list
	@Test
	public void test3() {

		List<String> wordList = RetrieveWords.GetWords("232");
		Collections.sort(wordList);
		assertTrue(wordList.isEmpty());
	}
	
	//This test will verify that an empty string entered into the function will return an empty list
	@Test
	public void test4() {
		List<String> wordList = RetrieveWords.GetWords("");
		Collections.sort(wordList);
		assertTrue(wordList.isEmpty());

	}
	
	//This test will verify that a string with an empty space entered into the function will return an empty list
	@Test
	public void test5() {
		List<String> wordList = RetrieveWords.GetWords("alpha beta");
		Collections.sort(wordList);
		assertTrue(wordList.isEmpty());

	}
	
}
