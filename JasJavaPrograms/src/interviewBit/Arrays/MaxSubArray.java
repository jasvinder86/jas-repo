package interviewBit.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {

	public int maxSubArray(final List<Integer> A) {

		int Ref = 0;
		int i = 0, j = 0;

		int size = A.size();

		while (j < size - 1) {
			Ref = A.get(j);
			i = j;
			while (((i + 1) < size ) && (Ref + A.get(i + 1) >= Ref)) {
				Ref = Ref + A.get(i + 1);
				i++;
			}
			j++;
		}

		return Ref;
	}

	public static void main(String[] args) {
		MaxSubArray maxSubArray = new MaxSubArray();
		List<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		
		System.out.println(maxSubArray.maxSubArray(A));
		
	}

}
