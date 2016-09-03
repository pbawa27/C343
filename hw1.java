//Inderpreet Singh

import java.util.*;

/* 1.8
 * One way one would do this is by having an input be the key word that will be used
 * to search through it. If a lot of the current element contains this key word then it
 * will be returned.
 * 
 * 2.2
 * Part A 
 * It's not an equivalence relation because for integers a and b, a + b can be 
 * even but that doesn't necessarily mean a is equivalent to b. A counter example
 * would be: a = 6 and b = 8. 6 + 8 = 14 which is even but 6 is not equivalent to 8.
 * Part D
 * Just like part A, there is a counterexample for this as well. For example, when
 * a = 9 and b = 3. 9/3 = 3 which is an integer but 9 is not equivalent to 3.  
 * 
 * 2.3
 * Part A
 * Not a partial ordering because the relation on the set of all people is not transitive,
 * i.e. (my father, me), (me, my son) are in the set but (my father, my son) is not.
 * Part B
 * It is not a partial ordering because it is not reflexive. One cannot be their own
 * ancestor.
 * Part C
 * Not a partial ordering because it also is not reflexive. You cannot be older than
 * yourself.
 * Part D
 * Not a partial ordering because you cannot be your own sister.
 * Part E
 * Not a partial ordering. It is not antisymmetric because a and b are different and
 * a is related to b and b is related to a, but a does not equal b.
 * Part F
 * It is a partial ordering since it is not antisymmetric because no two elements relate
 * to each other. 2 relates to 1 but 1 does not relate to 2, 1 relates to 3 but not 3 to 1,
 * and 2 relates to 3 but not 3 to 2. Also, it is transitive because 2 has a relation to 1,
 * 1 has a relation to 3, and 2 has a relation to 3.
 * 
 * 2.19
 * Part A
 * To prove that something is even, it must mean that some n, can be multiplied by 2 to be even.
 * P(k) = k^2 - k.
 * e.g. P(1) = 1^2 - 1 = 0.
 * P(k + 1) = (k+1)^2 - (k+1) = k^2+2k+1-k+1 = k^2+k+2
 * So, set k^2+k = 2n for some integer n
 * 2n+2 = 2(n+1) = 2 * some integer (n+1), therefore, k^2 - n is always even.
 * Part B
 * If integer k is used in the operation k^2-k, then it will always be even, this is proven by induction.
 * Part C
 * P(n) = n^3 - n
 * For n = 1, n^3 - n = 1 - 1, which is divisible by 3. 
 * So, (n+1)^3 - (n+1) = n^3 + 3n^2 + 3n + 1 - n - 1
 * which = 3(n^2 + n) + (n^3 - n).
 * We assumed that n^3-n is divisible by 3, so we can also assume that (n+1)^3 - (n+1) is also divisible by 3.
 * And of course anything multiplied by 3 (n^2 + n) will be divisible by 3, therefore, n^3 - n must be divisible by 3.
 * Part D.a
 * Yes, one can prove this by using induction similar to n^3-n. The rule stands for any natural number value n.
 * The only counterexamples for this expression would be negative numbers. If n is positive, n^5-n will always be divisible by 5.
 * Part D.b
 * When k+1 pidgeons roost in k holes, there is guaranteed to be 2 pidgeons in one hole.
 * In order to prove this, there must be at least 1 more pidgeons then there are holes.
 * So for k+1 pidgeons and k holes, if you subtract k from k+1, you will get the result 1, which suggests there is an extra pigeon or one less hole.
 */

// 2.5
class setOfInt{
	int[] set;
	SetOfInt(int[] s){
		set = s;
	}
	int size(){
		return set.length;
	}
	boolean check(int n){
		for(int i = 0; i < set.length; i++){
			if(set[i] == n)
				return true;
			}
		return false;
	}
}





public class hw1 {
	
	/* DSutil source code from "A Practical Introduction to Data Structures and Algorithm Analysis"
	 * by Clifford A. Shaffer, Prentice Hall, 1998.*/
	
	// A bunch of utility functions.
	public static class DSutil {
		
		// Swap two objects in an array
		public static void swap(int[] array, int p1, int p2) {
			int temp = array[p1];
			array[p1] = array[p2];
			array[p2] = temp;
		}

		// Randomly permute the Objects in an array
		public static void permute(int[] A) {
			for (int i = A.length; i > 0; i--)   // for each i
				swap(A, i-1, DSutil.random(i));  //   swap A[i-1] with
		}                                        //   a random element

		// Create a random number function to return values
		// uniformly distributed within the range 0 to n-1.
		private static Random value = new Random(); // Hold the Random class object

		static int random(int n) { // My own function
			return Math.abs(value.nextInt()) % n;
		}
		
	}

	// 2.15
	static void printPermutation(int[] A){
		for(int i = 0; i != helpFactorial(A.length); ++i){
			DSutil.permute(A);
			System.out.println(Arrays.toString(A));
		}
	}

	public static int helpFactorial(int n) {
	    int result = 1;
	    for (int i = 1; i <= n; i++) {
	        result *= i;
	    }
	    return result;
	}

	// 4.7
    public int[] merged(int[] one, int[] two){
        int counter1 = 0;
        int counter2 = 0;
        int max;
        if(one.length > two.length){
         max = two.length;
    }
        else{
         max = one.length;    
    }
        int[] merge = new int[max];
        int index = 0;
        while(counter1 < max || counter2 < max){
         if(one[counter1] < two[counter2]){
             merge[index] = one[counter1];
             index++;
             counter1++;
    }
         else{
             merge[index] = two[counter2];
             index++;
             counter2++;
         }
    }
        
         return merge;
   }
     
   // 4.15
   public class palindrome?{
	   public boolean palindromeTest(String s){
		   int len = s.length();
		   for (int i=0;i<(len/2);++i) {
			   if(s.charAt(i) != s.charAt(len - i - 1)){
				   return false;
			   }
		   }return true;
	   }
   }

	public static void main(String[] args){
		int[] test = { 7, 9, 5, 1, 3 };
		printPermutation(test);
	}
	
}