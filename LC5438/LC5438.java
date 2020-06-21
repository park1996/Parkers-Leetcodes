import java.util.Collections;
import java.util.Arrays;
import java.util.HashSet;
class LC5438 {
    public static int calcMinDays(int[] bloomDay, HashSet<Integer> picked, int m, int k){
        if(m <= 0){
            return 0;
        }
        Integer [] result = new Integer[bloomDay.length];
        boolean containResult = false;
        for(int i = 0; i < result.length; i++){
            if(picked.contains(i)){
                result[i]=2147483647;
            }
            else{
                HashSet<Integer> newPicked = new HashSet<>(picked);
                for(int j = 0;j < k; j++){
                    if(i-j >= 0){
                        newPicked.add(i-j);
                    }
                    if(i+j < bloomDay.length){
                        newPicked.add(i+j);
                    }
                }
                if(newPicked.size() >= bloomDay.length + m - 1){
                    result[i]=2147483647;
                    continue;
                }
                int wait = calcMinDays(bloomDay, newPicked, m-1, k);
                if(wait != -1){
                    containResult = true;
                    result[i]=Math.max(wait, bloomDay[i]);
                }
                else{
                    result[i]=2147483647;
                }
            }
        }
        if(!containResult){
            return -1;
        }
        return Collections.min(Arrays.asList(result));
        
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length){
            return -1;
        }
        int[] waitFor = new int[bloomDay.length - k + 1];
        for(int i = 0; i < waitFor.length; i++){
            int maxCost = 0;
            for(int j = 0; j < k; j++){
                if(bloomDay[j+i] > maxCost){
                    maxCost = bloomDay[j+i];
                }
            }
            waitFor[i]=maxCost;
        }
        HashSet<Integer> picked = new HashSet<Integer>();
        return calcMinDays(waitFor, picked, m, k);
    }
    public static void main(String args[]){
        int[] input = {7,7,7,7,12,7,7};
        minDays(input, 2, 3);
    }
}