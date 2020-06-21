import java.util.HashSet;

class LC5442_Sol2 {
    public int[] avoidFlood(int[] rains) {
        HashSet<Integer> fullLake = new HashSet<>();
        Queue<Integer> dryDayToBeUsed = new LinkedList<>();
        int[] result = new int[rains.length];
        for(int i = 0; i < result.length; i++){
            result[i]=-2;
        }
        for(int i = 0; i < rains.length; i++){
            if(rains[i]==0){
                dryDayToBeUsed.add(i);
            }
            else if(fullLake.contains(rains[i]) && dryDayToBeUsed.isEmpty()){
                return new int[0];
            }
            else if(fullLake.contains(rains[i])){
                int dryDay = dryDayToBeUsed.remove();
                result[dryDay]=rains[i];
                result[i]=-1;
            }
            else{
                result[i]=-1;
                fullLake.add(rains[i]);
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
        int[] input = {69,0,0,0,69};
        System.out.println(avoidFlood(input).length);
    }
}