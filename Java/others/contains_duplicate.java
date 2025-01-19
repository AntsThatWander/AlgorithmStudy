package Java.others;
import java.util.HashSet;

public class contains_duplicate {

    public boolean cotainsDuplicate(int[] nums){
        HashSet<Integer> checker = new HashSet<>();
        
        for(int num : nums) {
            if(checker.contains(num))
                return true;
            checker.add(num);
        }

        return false;
    }
    
}
