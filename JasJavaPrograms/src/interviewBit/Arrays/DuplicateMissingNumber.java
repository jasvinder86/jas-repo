package interviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class DuplicateMissingNumber {

	public ArrayList<Integer> repeatedNumber(final List<Integer> A) {

		long sum = 0, sqSum = 0, actualSum = 0, actualSqSum = 0, diffSqSum = 0, diffSum = 0;

		for (int i = 0; i < A.size(); i++) {
			sum = sum + A.get(i);
			sqSum = sqSum + (A.get(i) * A.get(i));
		}

		for (int i = 1; i <= A.size(); i++) {
			actualSum = actualSum + i;
			actualSqSum = actualSqSum + (i * i);
		}

		diffSqSum = Math.abs(sqSum - actualSqSum);
		diffSum = Math.abs(sum - actualSum);

		long sumOfNos = diffSqSum / diffSum;
		long diffOfNos = diffSum;

		long n1 = (sumOfNos + diffOfNos) / 2;
		long n2 = Math.abs((sumOfNos - diffOfNos) / 2);

		ArrayList<Integer> list = new ArrayList<Integer>();
		// if (n1 > n2) {
		// list.add(n2);
		// list.add(n1);
		// } else {
		// list.add(n1);
		// list.add(n2);
		// }

		Boolean flag = false;
		for (int i = 0; i < A.size(); i++) {
			if (n1 == A.get(i))
				flag = true;
		}

		if (flag) {
			list.add((int) n1);
			list.add((int) n2);
		} else {
			list.add((int) n2);
			list.add((int) n1);
		}

		return list;
	}

	public static void main(String[] args) {
		DuplicateMissingNumber object = new DuplicateMissingNumber();

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(4);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(6);
		A.add(1);

		System.out.println(object.repeatedNumber(A));
	}

}
