package codingChallengesTechLead;

import java.util.Arrays;

public class num2 {
    /*
    Given an array of integers, return a new array such that
    each element at index i of the new array is the product
    of all the numbers in the original array except the one at i.

    For example, if our input was [1, 2, 3, 4, 5], the
    expected output would be [120, 60, 40, 30, 24]. If our
    input was [3, 2, 1], the expected output would be [2, 3, 6].

    Follow-up: what if you can't use division?
     */


    public static void main(String[] args){
        new num2().run();
    }

    void run(){

        System.out.println(
                Arrays.equals(
                        getProducts(new int[]{1, 2, 3, 4, 5}),
                        new int[]{120, 60, 40, 30, 24}
                ) ? "PASS" : "FAIL"
        );

        System.out.println(
                Arrays.equals(
                        getProducts(new int[]{3, 2, 1}),
                        new int[]{2, 3, 6}
                ) ? "PASS" : "FAIL"
        );
    }

    int[] getProducts(int[] nums){

        int[] products = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int val = 1;
            for(int j=0;j<nums.length;j++){
                if (i!=j) val*=nums[j];
            }
            products[i]=val;

        }

        return products;
    }

}
