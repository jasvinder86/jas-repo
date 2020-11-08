package com.java.ds.random.arrayandstrings.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray2 {

	public int maxSubArray(final List<Integer> A) {

		int i = 0, finalSum = A.get(0), sum = 0;

		while (i < A.size()) {
			sum = A.get(i);
			System.out.println("starting over ... sum so far : " + sum);

			for (int j = i + 1; j < A.size(); j++) {
				if (sum + A.get(j) > 0) {
					sum = sum + A.get(j);
					System.out.println("i : " + i + " and its value is : " + A.get(i));
					System.out.println("j : " + j + " and its value is : " + A.get(j));
					System.out.println("sum in the loop : " + sum);

					if (sum > finalSum) {
						System.out.println("finalSum : " + finalSum);
						System.out.println("sum : " + sum);
						finalSum = sum;
					}

				}

				else
					break;
			}

			i++;

			// if (sum > finalSum) {
			// System.out.println("finalSum : " + finalSum);
			// System.out.println("sum : " + sum);
			// finalSum = sum;
			// }
		}

		System.out.println("sum to print : " + finalSum);
		return finalSum;
	}

	public static void main(String[] args) {
		MaxSubArray2 maxSubArray = new MaxSubArray2();
		List<Integer> A = new ArrayList<Integer>();
		A.add(-120);
//		A.add(-202);
//		A.add(-293);
//		A.add(-60);
//		A.add(-261);
//		A.add(-67);
//		A.add(10);
//		A.add(82);
//		A.add(-334);

		// System.out.println(maxSubArray.maxSubArray(A));
		maxSubArray.maxSubArray(A);
	}

}
