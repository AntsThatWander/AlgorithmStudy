package others;
import java.util.HashMap;

public class two_sum {
    // public int[] twoSum(int[] nums, int target) {
    //     if(nums.length == 2){
    //         return new int[]{0, 1};
    //     }
        
    //     for(int i = 0; i < nums.length; ++i){
    //         for(int j = 0; j < nums.length; ++j){
    //             if(i != j && nums[i] + nums[j] == target)
    //                 return new int[]{i, j};
    //         }
    //     }

    //     return new int[]{0, 1};
    // }

    // public int[] twoSum(int[] nums, int target) {
        
    // }
    
    public static void main(String[] args){
        HashMap<Integer, Integer> hash = new HashMap<>();

        hash.put(1, 3);
        hash.put(1, 5);

        System.out.println(hash.get(1));
    }


    
    
}
