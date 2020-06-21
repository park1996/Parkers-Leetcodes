import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class LC5442_Sol2 {
    public static int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> fullLake = new HashMap<>();
        Queue<Integer> dryDayToBeUsed = new LinkedList<>();
        int[] result = new int[rains.length];
        for(int i = 0; i < result.length; i++){
            result[i]=-2;
        }
        for(int i = 0; i < rains.length; i++){
            if(rains[i]==0){
                dryDayToBeUsed.add(i);
            }
            else if(fullLake.containsKey(rains[i]) && dryDayToBeUsed.isEmpty()){
                return new int[0];
            }
            else if(fullLake.containsKey(rains[i])){
                int dryDay = dryDayToBeUsed.remove();
                int initDryDay = dryDay;
                int dryTarget = fullLake.get(rains[i]);
                while(dryTarget > dryDay){
                    dryDayToBeUsed.add(dryDay);
                    dryDay=dryDayToBeUsed.remove();
                    if(dryDay==initDryDay){
                        return new int[0];
                    }
                }
                result[dryDay]=rains[i];
                result[i]=-1;
                fullLake.put(rains[i], i);
            }
            else{
                result[i]=-1;
                fullLake.put(rains[i], i);
            }
        }
        for(int i = 0; i < result.length; i++){
            if(result[i]==-2){
                result[i]=1;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] input = {2,3,0,0,3,1,0,1,0,2,2};
        System.out.println(avoidFlood(input).length);
    }
}