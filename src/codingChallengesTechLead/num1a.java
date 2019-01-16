package codingChallengesTechLead;

import java.util.TreeSet;

public class num1a {
    /*
    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

    Bonus: Can you do this in one pass?
    */

    public static void main(String[] args){
        try {
            new num1a().run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void run(){
        int[] numbers;
        int k;
        boolean expect;

        numbers = new int[]{10,3,3,7,2};
        k=17;
        expect=true;

        check(1, numbers,k,expect);

        numbers = new int[]{10,3,3,7,2};
        k=7;
        expect=false;

        check(2, numbers,k,expect);

        numbers = new int[]{10,3,3,7,2};
        k=9;
        expect=true;

        check(3, numbers,k,expect);

        numbers = new int[]{10,3,3,7,2};
        k=12;
        expect=true;

        check(4, numbers,k,expect);

        numbers = new int[]{10,3};
        k=12;
        expect=false;

        check(5, numbers,k,expect);

        numbers = new int[]{10,3,3,7,2};
        k=8;
        expect=false;

        check(6, numbers,k,expect);

        try {
            numbers = new int[]{10};
            k = 8;
            expect = false;

            check(6, numbers, k, expect);
        }catch (Exception e){
            check(6,e,e.getMessage().contains("long"));
        }

        try {
            numbers = new int[]{10,8};
            k = -1;
            expect = false;

            check(7, numbers, k, expect);
        }catch (Exception e){
            check(7,e,e.getMessage().contains("k must be positive"));
        }

        try {
            numbers = new int[]{10,-8};
            k = 8;
            expect = false;

            check(8, numbers, k, expect);
        }catch (Exception e){
            check(8,e,e.getMessage().contains("numbers")&e.getMessage().contains("positive"));
        }

        try {
            numbers = new int[]{-10,8};
            k = 8;
            expect = false;

            check(9, numbers, k, expect);
        }catch (Exception e){
            check(9,e,e.getMessage().contains("numbers")&e.getMessage().contains("positive"));
        }

        numbers = new int[]{10,13,13,17,12};
        k=12;
        expect=false;

        check(10, numbers,k,expect);

        numbers = new int[]{-10,8};
        k = -2;
        expect = true;

        check(11, numbers, k, expect);

//        numbers = new int[]{10,3,3,7,2};
//        k=12;
//        expect=true;
//
//        check(8, numbers,k,expect);
//
//        numbers = new int[]{10,3,3,7,2};
//        k=12;
//        expect=true;
//
//        check(9, numbers,k,expect);


    }

    void check(int ex, Exception e, Boolean check){
        System.out.println(
                String.format("Example %s: %s, (result=%s)",ex,check?"PASS":"FAIL", e.getMessage())
        );
    }

    void check(int ex, int[] numbers, int k, boolean expect){

        boolean result = doTwoAddtoGetK(numbers, k);
        System.out.println(
                String.format("Example %s: %s, (result=%s)",ex,expect==result?"PASS":"FAIL", result)
        );
    }

    /**
     * O(n*log(n)) solution allowing positive and negative numbers
     * O(n) storage ?
     *
     * @param numbers
     * @param k
     * @return
     */
    boolean doTwoAddtoGetK(int[] numbers, int k){
        if (numbers.length < 2) throw new RuntimeException("numbers array must be at least 2 elements long");

        TreeSet<Integer> foundSet = new TreeSet<>();

        foundSet.add(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {

            if (foundSet.contains(compliment(numbers[i], k))) {
                return true;
            }
            foundSet.add(numbers[i]);

        }
        return false;
    }
    int compliment(int num,int of){
        return of-num;
    }
}
