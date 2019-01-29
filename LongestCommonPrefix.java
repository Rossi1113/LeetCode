//kind of brute force solution:
//Time complexity: O(N*M),N is the length of strs,M is the length of common prefix.
//get the common prefix of firt two string as s,then keep tracking the common prefix
// of s and next string in the array.
//early termination will happen on current common prefix is "".
public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null)
            return "";
        if(strs.length == 1){
            return strs[0];
        }
        String s = CommonPrefix(strs[0],strs[1]);
        int index = 2;
        while(index < strs.length){
            s = CommonPrefix(s,strs[index++]);
            if(s.equals("")){
                return "";
            }
        }
        return s;
    }

    public String CommonPrefix(String s1, String s2){
        int index = 0;
        String res = "";
        while(index < s1.length() && index < s2.length()){
            if(s1.charAt(index) == s2.charAt(index)){
                res = res + s1.charAt(index++);
            }else break;
        }
        return res;
    }
