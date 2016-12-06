
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


 /* Question 1.5
 * Here i made three base cases, one if s1 == s2, one if s1 > s2, and one if s2 < s1
 * if s1 == s2, i checked if they were the same string or had only one difference
 * if s1 > s2, i first checked if s1 was more than 2 characters greater, (oneAway = false)
 * then i checked if is s1 == s2 by character, if so increment i and j, else i increments and j stays the same
 * if s2 > s1 then i called the same function where s2 was now s1 and vise versa.
  */
 public boolean oneAway(String s1, String s2){

     boolean oneAway = true;
     boolean oneFalse = false;
     if (s1.length() == s2.length()){
         for (int i = 0; i < s1.length(); i++){
             if (s1.charAt(i) != s2.charAt(i)){
                 if (!oneFalse){
                     oneFalse = true;
                 }
                 else{
                     oneAway = false;
                 }
             }
         }
     }
     if (s1.length() > s2.length()){
         if (s1.length() > s2.length()+1){
             oneAway = false;
         }
         else{
             int i = 0;
             int j = 0;
             while(i < s1.length()-1 || j < s2.length()){
                 if (s1.charAt(i) == s2.charAt(j)){
                     i++;
                     j++;
                 }
                 else{
                     if(!oneFalse){
                         oneFalse = true;
                         i++;
                     }
                     else{
                         oneAway = false;
                         break;
                     }
                 }
             }
         }
     }
     if (s1.length() < s2.length()){
         return oneAway(s2,s1);
     }
     System.out.println(oneAway);
     return oneAway;
 }


 /* Question 1.6
  * First I declared isOriginal for the case that there are no character repeats;
  * becomes false when a repeat is found;
  * Next the loop iterates through the string, stopping at s.length()-1 because we look at the next character too
  * I have a counter counting the amount of same characters in a row, when it hits an end it resets the counter to 1
  * and appends to the string builder.
  * String builder is used because it allows us to build the string as we go.
  */
 public String stringCompression(String s){
     boolean isOriginal = true;
     StringBuilder sb = new StringBuilder();
     int counter = 1;
     for (int i = 0; i < s.length()-1; i++){
         if (i+1  == s.length() - 1 )
             counter++;
         if (s.charAt(i) == s.charAt(i+1) && (i+1) != (s.length() - 1)){
             counter++;
             isOriginal = false;
         }
         else{
             sb.append(s.charAt(i));
             sb.append(counter);
             counter = 1;
         }

     }
     if (isOriginal){
         System.out.println(s);
         return s;

     }
     else {
         System.out.println(sb.toString());
         return sb.toString();

     }
 }


 
 public String reverseString(String s){
  StringBuilder sb = new StringBuilder();
  for (int i = s.length()-1; i >= 0; i--){
   sb.append(s.charAt(i));
   
  }
  System.out.println(sb.toString());
  
 return sb.toString();
 }

 /* Question 1.9
  * This question has no code because it uses a method we don't have access to
  * however, the way to solve this is, isRotation checks if its a rotation, so we create
  * a new string s1s1 = s1 + s1; because s2 will then have to be a substring of that if it is
  * indeed a rotation of that. Then you just call isSubstring and check just that.
  */



 
 
 
 
 public static void main(String [] args){
 Ch1Solutions a = new Ch1Solutions();
 a.reverseString("hello");
 a.uniqueChars("!!");
 a.isPermutation("hello", "helol");
 a.URLify("vsp vish ");
 a.isPermutationOfPalindrome("tactcoa");
 a.oneAway("pales","pale");
 a.stringCompression("aabcccccaaa");
 }
}
