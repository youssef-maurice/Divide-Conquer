import java.math.BigInteger;
import java.util.ArrayList;

public class A2_Q4 {

    //method that produces the nth fibonacci number
    //(copied from lecture slides with some modifications)
    public static BigInteger fib(int n, ArrayList<BigInteger> nums) {
        //base cases because they are already stored in the arraylist
        if(n<=2) {
            return nums.get(n-1);
        }
        //if n-2 is not in the arraylist
        if(nums.size()<(n-2)){
            //call function recursively to produce n-2
            fib(n-2, nums);
        }
        //if n-1 is not in the arraylist
        if(nums.size()<(n-1)){
            //call function recursively to produce n-1
            fib(n - 1, nums);
        }
        //generate the nth fibonacci number
        BigInteger num =nums.get(n-3).add(nums.get(n-2));
        //add the nth fibonacci number to the arraylist
        nums.add(num);
        //return the nth fibonacci number we just added
        return nums.get(n-1);
    }

    public static String letter(int N, BigInteger K, ArrayList<BigInteger> nums) {
        //if the arraylist nums does not store the length of the    Nth string
        if(nums.size()<N){
            //generate the length of the Nth string
            fib(N, nums);
        }
        //from the assignment pdf we know that N=1=X & N=2=Y
        //Base cases for recursion
        if(N==1){
            return "X";
        }
        if(N==2){
            return "Y";
        }
        //we can divide the Nth string in 2: the first half
        //is the N-2 string, the second one is the N-1 string.
        //Get the first part from the arraylist
        BigInteger part1= nums.get(N-3);
        //if K is less or equal to the first part, that means
        //that K is also in the N-2 string
        if (K.compareTo(part1)<=0){
            N=N-2;
            //call the function recursively with parameters: N-2, K
            return letter(N,K, nums);
        }
        //if K is bigger than first part, that means
        //that K is in the N-1 string
        if(K.compareTo(part1)>0){
            //subtract from K the length of the first part
            K=K.subtract(part1);
            N=N-1;
            //call the function recursively with parameters:
            //N-1, K (the new K)
            return letter(N,K, nums);
        }
        return "Z";
    }
    public static String mod_fibonacci(int N, BigInteger K) {
        //initialize arraylist to store the fibonacci numbers
        ArrayList<BigInteger> nums = new ArrayList<BigInteger>(){{
            this.add(0, BigInteger.valueOf(1));
            this.add(1, BigInteger.valueOf(1));
        }};
        //get the letter stored at index K in the Nth string
        String letter= letter(N, K, nums);
        //return the letter
        return letter;
    }
}
