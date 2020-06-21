import java.util.HashSet;

class LC1044 {
    public static String duplicateOfLength(String S, int length){
        HashSet<String> hs = new HashSet<>();
        for(int j = 0; j <= S.length() - length; j++){
            String subStr = S.substring(j, j+length);
            if(hs.contains(subStr)){
                return subStr;
            }
            hs.add(subStr);
        }
        return "";
    }
    public static String longestDupSubstring(String S) {
        if(S.length()  <= 0){
            return "";
        }
        int len = (S.length()-1) / 2;
        int increment = len / 2;
        if(len <= 0){
            len = 1;
        }
        if(increment <= 0){
            increment = 1;
        }
        String[] results = new String[S.length()];
        while(len > 0){
            if(results[len] != null  && results[len].length()>0 && (len+1 >= S.length() || results[len+1].length() <= 0)){
                return results[len];
            }
            if(results[len] != null){
                continue;
            }
            String result = duplicateOfLength(S, len);
            results[len]=result;
            if(result.length() > 0 && (len + 1 >= S.length() || (results[len+1]!= null && results[len+1].length()<= 0))){
                return result;
            }
            else if(result.length() > 0){
                len += increment;
                increment /= 2;
                if(len >= S.length()){
                    len=S.length() - 1;
                }
                if(increment <= 0){
                    increment = 1;
                }
            }
            else{
                len -= increment;
                increment /= 2;
                if(increment <= 0){
                    increment = 1;
                }
            }
        }
        
        return "";
    }
    public static void main(String args[]){
        String str = "banana";
        System.out.print(longestDupSubstring(str));
    }
}