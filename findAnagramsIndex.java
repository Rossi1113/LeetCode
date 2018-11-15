import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagramsIndex {
    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";
        findAnagrams2(s,p);
    }
    //This is typical brute force solution.
    //Because I numerate all potential substrings which could be the anagram of p
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null)
            return res;
        int diff = p.length();
        int[] count = new int[26];
        for(char c : p.toCharArray()){
            count[c -'a']++;
        }
        int end = 0;
        for(int start = 0; start <= s.length() - p.length(); start ++){
            end = start + p.length();
            if(ifAnagram(s.substring(start,end), count)){
                res.add(start);
            }
        }
        return res;
    }

    public static boolean ifAnagram(String a, int[] count){
        int[] p = Arrays.copyOf(count,26);
       // p = Arrays.copyOf(count,26);
        for(char c : a.toCharArray()){
            if(--p[c - 'a'] < 0)
                return false;
        }
        return true;
    }
    // solve with sliding window.
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null)
            return res;
        int diff = p.length();
        int[] count = new int[26];
        for(char c : p.toCharArray()){
            count[c -'a']++;
        }
        int start = 0;
        int end = 0;
        while(end < p.length()){
            if(--count[s.charAt(end++) - 'a'] >= 0)
                if(--diff == 0){
                    res.add(start);
                }
        }
        while(end < s.length()){
            if(++count[s.charAt(start) - 'a'] > 0){
                diff++;
            }
            if(--count[s.charAt(end) - 'a'] >= 0){
                diff--;
            }
            if(diff == 0){
                res.add(start+1);
            }
            start++;
            end++;
        }
        return res;
    }

}
