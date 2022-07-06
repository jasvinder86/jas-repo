package com.datastructures.lc.nc.arraysandhashing;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                result[i] = result[i - 1] * nums[i - 1];
            } else {
                result[i] = 1;
            }
        }

        int previousProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * previousProduct;
            previousProduct = previousProduct * nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] result = productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4}); // Expected and Actual output = 24 12 8 6
        System.out.print("Answer array elements are >> ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();
        result = productExceptSelf.productExceptSelf(new int[]{1, 0, 3, 0}); // Expected and Actual output = 0 0 0 0
        System.out.print("Answer array elements are >> ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();
        result = productExceptSelf.productExceptSelf(new int[]{-1, 0, 3, -1, -2}); // Expected and Actual output = 0 -6 0 0 0
        System.out.print("Answer array elements are >> ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
