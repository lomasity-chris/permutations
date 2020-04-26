package com.lomasity.permutation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PermutationTest {

	@Test
	public void testWhereFirstNumberIsFirstNotIncreasing() {

		List<Integer> currentPermutation = createPermutation("16432");
		List<Integer> nextPermutation = Permutation.findNextPermutation(currentPermutation);

		assertThat(getStringFromPermutation(nextPermutation), equalTo("21346"));
	}

	@Test
	public void testEmptyListReturnedForFinalPerm() {

		List<Integer> currentPermutation = createPermutation("864321");
		List<Integer> nextPermutation = Permutation.findNextPermutation(currentPermutation);

		assertThat(nextPermutation.size(), equalTo(0));
	}

	@Test
	public void testPenultimatePerm() {

		List<Integer> currentPermutation = createPermutation("954312");
		List<Integer> nextPermutation = Permutation.findNextPermutation(currentPermutation);

		assertThat(getStringFromPermutation(nextPermutation), equalTo("954321"));
	}

	@Test
	public void testSecondPerm() {

		List<Integer> currentPermutation = createPermutation("123458");
		List<Integer> nextPermutation = Permutation.findNextPermutation(currentPermutation);

		assertThat(getStringFromPermutation(nextPermutation), equalTo("123485"));
	}

	@Test
	public void testAnyOldPerm() {

		List<Integer> currentPermutation = createPermutation("68271");
		List<Integer> nextPermutation = Permutation.findNextPermutation(currentPermutation);

		assertThat(getStringFromPermutation(nextPermutation), equalTo("68712"));
	}

	private List<Integer> createPermutation(String number) {

		List<Integer> permutation = new ArrayList<Integer>();
		for (int i = 0; i < number.length(); i++) {
			permutation.add(Character.getNumericValue(number.charAt(i)));
		}
		return permutation;
	}

	private String getStringFromPermutation(List<Integer> permutation) {

		StringBuilder permString = new StringBuilder();
		for (Integer item : permutation) {
			permString.append(item.toString());
		}
		return permString.toString();
	}

}
