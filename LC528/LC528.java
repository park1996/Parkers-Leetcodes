import java.util.Random;
import java.lang.Math;


class Solution {
    private int[] arr;
    private int totalWeight;
    private int[][] lookup;
    public Solution(int[] w) {
        arr = w;
        totalWeight = 0;
        int j = 0;
        lookup = new int[arr.length][2];
        for(int i = 0; i < w.length; i++){
            int currentWht = w[i];
            totalWeight+=currentWht;
            lookup[i][0]=j;
            while(currentWht > 0){
                j++;
                currentWht--;
            }
            lookup[i][1]=j-1;
            
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int number = rand.nextInt(totalWeight);
        int ind = lookup.length / 2;
        if(ind < 0){
            ind = 0;
        }
        else if(ind >= arr.length){
            ind = arr.length-1;
        }
        int lowerBound = lookup[ind][0];
        int upperBound = lookup[ind][1];
        int step = ind/2;
        if(step <= 0){
            step = 1;
        }
        while(!(lowerBound <= number && number <= upperBound)){
            if(number > upperBound){
                ind -= step;
            }
            else if(number < lowerBound){
                ind += step;
            }
            if(ind < 0){
                ind = 0;
            }
            else if(ind >= arr.length){
                ind = arr.length-1;
            }
            step /= 2;
            if(step <= 0){
                step = 1;
            }
            lowerBound = lookup[ind][0];
            upperBound = lookup[ind][1];
        }
        return ind;
    }
}

class LC528{
    public static void main(String args[]){
        int []w = {1, 3};
        Solution obj = new Solution(w);
        int param_1 = obj.pickIndex();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */