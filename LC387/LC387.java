import java.util.Map;
import Java.util.HashMap;
import Java.util.HashSet;
class LC387 {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), 1);
            }
            else{
                hm.put(s.charAt(i), hm.get(s.charAt(i)+1));
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(hm.get(s.charAt(i)) > 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        firstUniqChar("leetcode");
    }
}