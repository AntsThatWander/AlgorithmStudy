package others;
import java.util.HashMap;

public class valid_anagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> foreString = new HashMap<>();
        HashMap<Character, Integer> backString = new HashMap<>(foreString);

        countCharacter(foreString, s);
        countCharacter(backString, t);

        if(foreString.entrySet().equals(backString.entrySet()))
            return true;
        else
            return false;
    }

    private void countCharacter(HashMap<Character, Integer> hashmap, String str){
        for(char c : str.toCharArray()){
            if(hashmap.get(c) == null)
                hashmap.put(c, 1);
            else{
                int count = hashmap.get(c);
                hashmap.replace(c, ++count);
            }
        }

    }

    public static void main(String[] args){
        valid_anagram solution = new valid_anagram();

        System.out.println(solution.isAnagram("anagram", "nagaram"));
    }
    
}
