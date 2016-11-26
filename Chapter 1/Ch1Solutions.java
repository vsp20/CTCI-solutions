
public class Ch1Solutions {
 // Question 1.1
 /* This method checks if the string is all unique chars
  * I did this by using an array of size 128 (ASCII) and setting the value to 1 once a character is used, 
  * then if the value is already 1 isUnique is false
  */ 
 public boolean uniqueChars(String s){
  boolean isUnique = true;
  int[] a = new int[128];
  for (int i = 0; i < s.length();i++){
   if (a[s.charAt(i)+0] == 0){
    a[s.charAt(i)]++;
   }
   else{
    isUnique = false;
   }
  }
  System.out.println(isUnique);
  return isUnique;
  
 }

 /* Question 1.2
  * This checks if the two input strings are permutations of eachother,
  * by incrementing by 1 for every character there is in an array of size 128 or s1 and 
  * decrementing for s2, then looping through checking if there is any value other than 0 left in the array
  * 
  */ 
 public boolean isPermutation(String s1, String s2){
   int [] a = new int[128];
   boolean permutation = true;
   if (s1.length() != s2.length()){
     permutation = false;
   }
   else{
     for (int i = 0; i< s2.length();i++){
       a[s1.charAt(i)]++;
       a[s2.charAt(i)]--;
     }
     for (int i = 0; i<128; i++){
       if(a[i] != 0)
         permutation = false;
     }
   }
   System.out.println(permutation);
   return permutation;
   
 }


 /* Question 1.3
 * Treating the string as a character array for a challenge.
 * I went about this by first counting the amount of spaces in the normal array
 * then I created a new array with the correct amount of spaces.
 * Next I started at the end of where array a was, every space i add %20, else I add the normal value.
 *Space complexity = String.length + spacecount * 2;
 * Time complexity = O(N);
  */

 public String URLify(String s){
     char [] a = s.toCharArray();
     int spaceCount = 0;
     for (int i = 0; i < a.length; i++) {
         if (a[i] == ' ') {
             spaceCount++;
         }
     }
     char[] b = new char[a.length+spaceCount*2];
     int j = b.length-1;
     for (int i = 0; i < b.length; i++){
         if (i < a.length){
             b[i] = a[i];
         }
         else {
             b[i] = ' ';
         }
     }
     for (int i = a.length-1; i != 0; i--) {
         if (b[i] == ' '){
             b[j] = '0';
             j--;
             b[j] = '2';
             j--;
             b[j] = '%';
             j--;
         }
         else{
             b[j] = a[i];
             j--;
         }
     }
     String returnString = String.valueOf(b);
     System.out.println(returnString);
     return returnString;
 }


 
 /* Question 1.4
 * This question is a little easier than normal bec all we have to check is the amount of each letter, not the order.
 * First I checked if the string was odd or even
 * if even, the number of each letter should be even
 * if odd the number of each character/letter should be even except one, that's where the boolean odd comes in.
 * Works for special characters too
  */
 public boolean isPermutationOfPalindrome(String s){
     boolean isPerm = true;
     int[] a = new int[128];
     boolean odd = false;
     if (s.length() % 2 == 0){
         //s length is even
         for (int i = 0; i < s.length(); i++){
             a[s.charAt(i)]++;
         }
         for (int i = 0; i < 128; i++){
             if (a[i] % 2 != 0){
                 isPerm = false;
             }
         }

     }
     else{
         // s length is odd
         for (int i = 0; i < s.length(); i++){
             a[s.charAt(i)]++;
         }
         for (int i = 0; i < 128; i++){
             if (a[i] % 2 != 0){
                 if (!odd){
                     odd = true;
                 }
                 else{
                     isPerm = false;
                 }
             }
         }

     }
     System.out.println(isPerm);
     return isPerm;
 }


 
 public String reverseString(String s){
  StringBuilder sb = new StringBuilder();
  for (int i = s.length()-1; i >= 0; i--){
   sb.append(s.charAt(i));
   
  }
  System.out.println(sb.toString());
  
 return sb.toString();
 }

 
 
 
 
 
 public static void main(String [] args){
 Ch1Solutions a = new Ch1Solutions();
 a.reverseString("hello");
 a.uniqueChars("!!");
 a.isPermutation("hello", "helol");
 a.URLify("vsp vish ");
 a.isPermutationOfPalindrome("tactcoa");
 }
}
