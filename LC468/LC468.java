class Solution {
    public static boolean check6(String IP){
        String[] ipByPart = IP.split(":",8);
        if(ipByPart.length != 8){
            return false;
        }
        if(ipByPart[0].length() <= 0){
            return false;
        }
        if(ipByPart[0].charAt(0) == '0'){
            return false;
        }
        for(int i = 0; i < ipByPart.length; i++){
            if(ipByPart[i].length() > 4 || ipByPart[i].length() <= 0){
                return false;
            }
            for(int j = 0; j < ipByPart[i].length(); j++){
                char currentChar = ipByPart[i].charAt(j);
                if(!((currentChar >= 'a' && currentChar <= 'f') || (currentChar >= '0' && currentChar <= '9') || (currentChar >= 'A' && currentChar <= 'Z'))){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean check4(String IP){
        String[] ipByPart = IP.split("\\.", 4);
        if(ipByPart.length != 4){
            return false;
        }
        for(int i = 0; i < ipByPart.length; i++){
            if(ipByPart[i].length() > 3 || ipByPart[i].length() <= 0){
                return false;
            }
            if(ipByPart[i].charAt(0) == '0' && ipByPart[i].length() > 1){
                return false;
            }
            int value = -1;
            try {
                    value = Integer.valueOf(ipByPart[i]);
            } catch(NumberFormatException e) {
                    return false;
            }
            if(!(value >= 0 && value <= 255)){
                return false;
            }
        }
        return true;
    }
    public static String validIPAddress(String IP) {
        if(IP.contains(".") && !IP.contains(":")){
            if(check4(IP)){
                return "IPv4";
            }
            else{
                return "Neither";
            }
        }
        else if(IP.contains(":") && !IP.contains(".")){
            if(check6(IP)){
                return "IPv6";
            }
            else{
                return "Neither";
            }
        }
        return "Neither";
    }

    public static void main (String[] args){
        String IP = "12.12.12";
        System.out.println(validIPAddress(IP));
    }
}