package com.lomasity.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static List<Integer> findNextPermutation(final List<Integer> currentPerm) {

		List<Integer> nextPerm = new ArrayList<>();

		int indexOfFirstNotIncreasing = getIndexOfFirstNotIncreasing(currentPerm);

		if (indexOfFirstNotIncreasing >= 0) {

			int indexOfNumberToSwap = getIndexOfNumberToSwap(currentPerm, indexOfFirstNotIncreasing);

			// Add the left section that is not changing
			for (int i = 0; i < indexOfFirstNotIncreasing; i++) {
				nextPerm.add(currentPerm.get(i));
			}

			// Add the first of the numbers that we have swapped
			nextPerm.add(currentPerm.get(indexOfNumberToSwap));

			// Add the rest of the numbers in reverse order, swapping in the
			// number where required
			for (int i = currentPerm.size() - 1; i > indexOfFirstNotIncreasing; i--) {
				if (i == indexOfNumberToSwap) {
					nextPerm.add(currentPerm.get(indexOfFirstNotIncreasing));
				} else {
					nextPerm.add(currentPerm.get(i));
				}
			}
		}

		return nextPerm;
	}

	private static int getIndexOfNumberToSwap(final List<Integer> currentPerm, final int indexOfFirstNotDecreasing) {
		
		int indexOfNumberToSwap = -1;
		int lowestFound = Integer.MAX_VALUE;
		
		for (int i = currentPerm.size() - 1; i >= indexOfFirstNotDecreasing; i--) {
			if (currentPerm.get(i) > currentPerm.get(indexOfFirstNotDecreasing) && currentPerm.get(i) < lowestFound) {
				lowestFound = currentPerm.get(i);
				indexOfNumberToSwap = i;
			}
		}
		
		if (indexOfNumberToSwap == -1) {
			throw new RuntimeException("Something has gone wrong.  We should have found a number to swap");
		}
		
		return indexOfNumberToSwap;
	}

	private static int getIndexOfFirstNotIncreasing(final List<Integer> currentPermutation) {

		for (int i = currentPermutation.size() - 1; i > 0; i--) {
			if (i > 0 && currentPermutation.get(i) > currentPermutation.get(i - 1)) {
				return i - 1;
			}
		}
		
		// This means that all numbers are increasing
		return -1;
	}
}
