package others;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class group_anagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            char[] sample = str.toCharArray();
            Arrays.sort(sample);
            String sorted = String.valueOf(sample);

            if(!map.containsKey(sorted)){
                map.put(str, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){


        
    }
}
