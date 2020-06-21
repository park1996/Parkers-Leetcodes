class WC202006132 {
    public static int minSumOfLengths(int[] arr, int target) {
        int[] result = new int[2];
        result[0]=9999999;
        result[1]=9999999;
        int[] ind = new int[2];
        ind[0]=-1;
        ind[1]=-1;
        int ptr1 = 0;
        int ptr2 = 0;
        int total = arr[0];
        while(ptr1 < arr.length && ptr2 < arr.length){
            if(total < target){
                ptr2++;
                if(ptr2 >= arr.length){
                    continue;
                }
                total+=arr[ptr2];
                
            }
            else if(total > target){
                total-= arr[ptr1];
                ptr1++;
            }
            else if(total == target){
                if(ptr2-ptr1+1 < result[0]){
                    result[0]=ptr2-ptr1+1;
                    ind[0]=ptr1;
                }
                if(result[0]<=1){
                    break;
                }
                total-= arr[ptr1];
                ptr1++;
                ptr2++;
                if(ptr2 >= arr.length){
                    continue;
                }
                total+= arr[ptr2];
            }
        }
        if(result[0] >= 9999999){
            return -1;
        }
        ptr1=0;
        ptr2=0;
        total=arr[0];
        while(ptr1 < arr.length && ptr2 < arr.length){
            if(total < target){
                ptr2++;
                if(ptr2 >= arr.length){
                    continue;
                }
                total+=arr[ptr2];
            }
            else if(total > target){
                total-= arr[ptr1];
                ptr1++;
            }
            else if(total == target){
                if( < result[1] && ( !(ptr1 <= result[0]+ind[0]-1 && ptr1 >= ind[0]) && !(ptr2 <= result[0]+ind[0]-1 && ptr2 >= ind[0]) && !(ptr1 <= ind[0] && ptr2 >= result[0]+ind[0]-1))){
                    result[1]=ptr2-ptr1+1;
                    ind[1]=ptr1;
                }
                if(result[1]<=1){
                    break;
                }
                total-= arr[ptr1];
                ptr1++;
                ptr2++;
                if(ptr2 >= arr.length){
                    continue;
                }
                total+= arr[ptr2];
            }
        }
        if(result[1] >= 9999999){
            return -1;
        }
        return result[0]+result[1];
    }
    public static void main(String args[]){
        int[] arr = {1,1,1,1,1,100,1,2,2,3,1,1};
        System.out.println(minSumOfLengths(arr, 5));//output 7 true ans: 6 [1,2,2] & [3,1,1]
    }
}