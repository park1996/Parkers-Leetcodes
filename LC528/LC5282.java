class Solution {
    public int findMin(int[][] people, int largerThan){
        int minHgt = 2147483647;
        for(int i = 0; i < people.length; i++){
            if(people[i][0] < minHgt && people[i][0] > largerThan){
                minHgt = people[i][0];
            }
        }
        if(minHgt == 2147483647){
            return -1;
        }
        return minHgt;
    }
    public void swap(int[][] people, int pos1, int pos2){
        int tempHgt = people[pos1][0];
        int tempPpl = people[pos1][1];
        people[pos1][0]=people[pos2][0];
        people[pos1][1]=people[pos2][1];
        people[pos2][0]=tempHgt;
        people[pos2][1]=tempPpl;
    }
    public int[][] reconstructQueue(int[][] people) {
        int currentMinHgt = -1;
        currentMinHgt = findMin(people, currentMinHgt);
        boolean[] filled = new boolean[people.length];
        while(currentMinHgt >= 0){
            for(int i = 0; i < people.length; i++){
                if(people[i][0]==currentMinHgt){
                    int dstn = people[i][1];
                    for(int j = 0; j <=dstn && j < people.length; j++){
                        if(filled[j]){
                            dstn++;
                        }
                    }
                    if(dstn >= people.length){
                        dstn = people.length-1;
                    }
                    filled[dstn]=true;
                    swap(people, i, dstn);
                }
            }
            currentMinHgt = findMin(people, currentMinHgt);
        }
        return people;
    }
}