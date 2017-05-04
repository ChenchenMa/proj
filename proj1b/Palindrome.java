/**
 * Created by Administrator on 2017/5/3.
 */
public class Palindrome {

    /*build a Deque where the characters in the deque appear in the same order as in the word.*/
    public static Deque<Character> wordToDeque(String word){
        ArrayDequeSolution<Character> wordDeque = new ArrayDequeSolution<>();
        for(int i=0; i < word.length(); i+=1){
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /*return true if the given word is a palindrome, and false otherwise.*/
    public static boolean isPalindrome(String word){
        if(word.length() == 1 || word.isEmpty()){
            return true;
        }else if(wordToDeque(word).removeFirst() != wordToDeque(word).removeLast()){
            return false;
        }else {
            String sub = word.substring(1, word.length()-1);
            return isPalindrome(sub);
        }
    }

    /*The method will return true if the word is a palindrome according to the character
     *comparison test provided by the CharacterComparator passed in as argument cc
     * */
    public static boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length() == 1 || word.isEmpty()){
            return true;
        }else if(!cc.equalChars(wordToDeque(word).removeFirst(), wordToDeque(word).removeLast())){
            return false;
        }else {
            String sub = word.substring(1, word.length()-1);
            return isPalindrome(sub,cc);
        }
    }



    /*public static void main (String[] args){
       // ArrayDequeSolution word = (ArrayDequeSolution) Palindrome.wordToDeque("word");
        //word.printDeque();
        if(isPalindrome("word")){System.out.print("word is");}
        if(isPalindrome("abba")){System.out.print("abba is");}
        if(isPalindrome("abeba")){System.out.print("abeba is");}
    }
    */

}
