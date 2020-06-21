class LC406 {
    public static int findMin(int[][] people, int largerThan){
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
    public static void swap(int[][] people, int pos1, int pos2){
        int tempHgt = people[pos1][0];
        int tempPpl = people[pos1][1];
        people[pos1][0]=people[pos2][0];
        people[pos1][1]=people[pos2][1];
        people[pos2][0]=tempHgt;
        people[pos2][1]=tempPpl;
    }
    public static int[][] reconstructQueue(int[][] people) {
        int currentMinHgt = -1;
        currentMinHgt = findMin(people, currentMinHgt);
        boolean[] filled = new boolean[people.length];
        while(currentMinHgt >= 0){
            boolean[] touched = new boolean[people.length];
            boolean[] newFilled = new boolean[people.length];

            for(int i = 0; i < people.length; i++){
                if(touched[i]){
                    continue;
                }
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
                    newFilled[dstn]=true;
                    touched[i]=true;
                    touched[dstn]=true;
                    swap(people, i, dstn);
                }
            }
            for(int i = 0; i < people.length; i++){
                if(newFilled[i]){
                    filled[i]=true;
                }
            }
            currentMinHgt = findMin(people, currentMinHgt);
        }
        return people;
    }
    public static void main(String args[]){
        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = reconstructQueue(input);
        for(int i = 0; i < result.length; i++){
            System.out.println(Integer.toString(result[i][0]) +" "+Integer.toString(result[i][1]));
        }
    }
}