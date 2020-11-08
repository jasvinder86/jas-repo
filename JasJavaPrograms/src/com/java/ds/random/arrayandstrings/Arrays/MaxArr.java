package interviewBit.Arrays;

import java.util.ArrayList;

public class MaxArr {

	public int maxArr(ArrayList<Integer> A) {

//		int size = A.size();
//		int sum = 0, hereSum = 0;
//
//		for (int i = 1; i <= size; i++) {
//			for (int j = 1; j <= size; j++) {
//				System.out.println("i is " + i);
//				System.out.println("j is " + j);
//				hereSum = Math.abs(A.get(i-1) - A.get(j-1)) + Math.abs(i - j);
//
//				if (hereSum > sum)
//					sum = hereSum;
//			}
//		}
//
//		return sum;
		

//        SOLUTION - takes more time = O(n^2)
//        int size = A.size();
//        int sum = 0, hereSum = 0;
//        
//        for(int i=1 ; i <= size; i++){
//            for(int j = i; j<= size; j++){
//            	
//            	System.out.println("i is " + i);
//				System.out.println("j is " + j);
//                
//                hereSum = Math.abs(A.get(i-1) - A.get(j-1)) + Math.abs(i - j);
//                
//                if(hereSum>sum)
//                sum = hereSum;
//            }
//        }
//        
//        return sum;
		
		
		int size = A.size();
		int sum = 0, hereSum = 0;
		int maxSumOfI = 0;
		int maxSumOfJ = 0;

		for (int i = 1; i <= size; i++) {
			int sumOfI = Math.abs(A.get(i - 1) - i);
			
			if (sumOfI > maxSumOfI) {
				maxSumOfI = sumOfI;
			}
		}
		
		for (int j = 1; j <= size; j++) {
			int sumOfJ = Math.abs(A.get(j - 1) - j);
			
			if (sumOfJ > maxSumOfJ) {
				maxSumOfJ = sumOfJ;
			}
		}
		
		System.out.println(" maxSumOfI : " + maxSumOfI);
		System.out.println(" maxSumOfJ : " + maxSumOfJ);
			
//			for (int j = i; j <= size; j++) {
//
//				System.out.println("i is " + i);
//				System.out.println("j is " + j);
//
//				hereSum = Math.abs(A.get(i - 1) - A.get(j - 1)) + Math.abs(i - j);
//
//				if (hereSum > sum)
//					sum = hereSum;
//			}
//		}
		sum = maxSumOfI - maxSumOfJ;
		System.out.println("total max sum : " + sum);

		return sum;	
    
	}

	public static void main(String[] args) {
		MaxArr maxArr = new MaxArr();
		ArrayList<Integer> A = new ArrayList<Integer>();
//		A.add(5);
		A.add(1);
		A.add(3);
		A.add(-1);

		System.out.println(maxArr.maxArr(A));
	}

}
