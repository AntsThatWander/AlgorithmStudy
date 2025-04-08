import java.util.Arrays;

class Solution {
    private int[] diffs;
    private int[] times;
    private long limit;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int level_low = 1;
        int level_high = Arrays.stream(diffs).max().getAsInt();
        int level_mid = 0;
        
        while(level_low <= level_high) {
            level_mid = (level_low + level_high) / 2;
            
            if(checkTimeOver(level_mid)) {
                level_low = level_mid + 1;
            }
            else {
                level_high = level_mid - 1;
            }
        }
        
        answer = level_low;
        
        
        return answer;
    }
    
    boolean checkTimeOver(int level) {
        long time = times[0];
        
        for(int i=1; i<diffs.length; ++i) {
                time += (diffs[i]>level?(diffs[i]-level):0)*(times[i-1]+times[i]) + times[i];
            }

        return time > limit;
    }
    
    
}