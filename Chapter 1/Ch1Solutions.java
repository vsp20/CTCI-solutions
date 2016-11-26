
public class Ch1Solutions {
 //Question 1
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
 
 
 /*Question 1.2
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
 
 
 public String URLify(String s, int length){
   StringBuilder sb = new StringBuilder();
   
   return sb.toString();
 }
 
 
 
 
 public String reverseString(String s){
  StringBuilder sb = new StringBuilder();
  for (int i = s.length()-1; i >= 0; i--){
   sb.append(s.charAt(i));
   
  }
  System.out.println(sb.toString());
  
 return sb.toString();
 }
 
 public void function(double C, double R){
   double L = 0.468;
   double wprime, w;
   wprime = 1/(L*C);
   System.out.println(wprime);
 }
 
 
 
 
 
 public static void main(String [] args){
 Ch1Solutions a = new Ch1Solutions();
 a.reverseString("hello");
 a.uniqueChars("!!");
 a.isPermutation("hello", "helol");
 a.function(.0047,1.011);
 }       
}
