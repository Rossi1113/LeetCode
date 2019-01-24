public class myAtoi {
    public static void main(String[] args){
        String str = "-91283472332";
        System.out.println(myAtoi(str));
    }
    public static int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int index = 0;
        int sign = 1;
        long num = 0;

        while(str.charAt(index) == ' '){
            index++;
            if(index == str.length()){
                return 0;
            }
        }
        if(str.charAt(index) == '+'){
            index++;
        } else if (str.charAt(index) == '-'){
            sign = -1;
            index++;
        }


        for(int i = index; i < str.length(); i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                break;
            }
            num = num*10 + str.charAt(i) - '0';
            if(num*sign >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(num*sign <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }

//        for(int i = index; i < str.length(); i++){
//            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
//                num = num*10 + Character.getNumericValue(str.charAt(i));
//                if(num*sign >= Integer.MAX_VALUE){
//                    return Integer.MAX_VALUE;
//                }
//                if(num*sign <= Integer.MIN_VALUE){
//                    return Integer.MIN_VALUE;
//                }
//            } else break;
//        }

        return (int)num*sign;
    }
}
