package interviewBit.Arrays;

import java.util.ArrayList;

public class PlusOne {
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

		// approach 1

		// A.set(A.size() - 1, A.get(A.size() - 1) + 1);
		//
		// int n = 0;
		// for (int i = A.size() - 1; i >= 0; i--) {
		// if (A.get(i) == 10) {
		// A.set(i, 0);
		// n++;
		// A.set(i - n, A.get(i - n) + 1);
		// }
		// }

		// approach 2

		// int carry = 1;
		//
		// int index = A.size() - 1;
		// while (carry == 1 && index > -1) {
		// A.set(index, A.get(index) + 1);
		// if (A.get(index) == 10) {
		// A.set(index, 0);
		// carry = 1;
		// }
		//
		// if (carry == 1 && index < 0) {
		// A.add(0);
		// A.set(0, 1);
		// }
		//
		// else
		// carry = 0;
		// index--;
		//
		// }

		// approach 3

		// remove all leading zeroes
		int i = 0;
		while (A.get(i) == 0 && i < A.size() - 1) {
			A.remove(i);
			// i--;
		}

		// add 1 to the LSB
		int carry = 1;

		int index = A.size() - 1;
		while (carry == 1 && index > -1) {
			A.set(index, A.get(index) + 1);

			if (A.get(index) == 10) {
				A.set(index, 0);
				carry = 1;
				index--;
			}

			else
				carry = 0;

		}

		if (index == -1 && carry == 1) {
			A.add(0);
			A.set(0, 1);
		}

		return A;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);

		PlusOne plusOne = new PlusOne();
		System.out.println(plusOne.plusOne(list));
	}
}
