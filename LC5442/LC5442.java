import java.util.HashSet;

class LC5442 {
    public static int[] takeAction(int[] rains, HashSet<Integer> fullLake, int today){
        if(today >= rains.length){
            return new int[rains.length];
        }
        int[] result = new int[0];
        if(rains[today]>0){
            if(fullLake.contains(rains[today])){
                return new int[0];
            }
            fullLake.add(rains[today]);
            result = takeAction(rains, fullLake, today+1);
            if(result.length > 0){
                result[today]=-1;
                
            }
            return result;
            
        }
        Integer[] fullLakeArr = fullLake.toArray(new Integer[0]);
        for(int i = 0; i < fullLakeArr.length; i++){
            HashSet<Integer> newFullLake = new HashSet<>(fullLake);
            newFullLake.remove(fullLakeArr[i]);
            int[] currentResult = takeAction(rains, newFullLake, today+1);
            if(currentResult.length > 0){
                currentResult[today]=fullLakeArr[i];
                result = currentResult;
                break;
            }
        }
        return result;
    }
    public static int[] avoidFlood(int[] rains) {
        HashSet<Integer> fullLake = new HashSet<>();
        return takeAction(rains, fullLake, 0);
    }
    public static void main(String[] args){
        int[] input = {69,0,0,0,69};
        System.out.println(avoidFlood(input).length);
    }
}