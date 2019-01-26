import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static void main(String[] args){
        String s = "ABCDE";
        System.out.println(convert(s,2));
    }
    public static String convert(String s, int numRows){
        StringBuilder[] sb = new StringBuilder[numRows];
        int row = 0;
        while(row != numRows){
            sb[row++] = new StringBuilder();
        }
        boolean godown = true;
        int line = 0;
        for(int i = 0; i < s.length(); i ++){
            if(godown){
                sb[line++].append(s.charAt(i));
                if(line == numRows){
                    godown = false;
                    line = line - 2;
                }
            }
            else {
                sb[line--].append(s.charAt(i));
                if(line < 0){
                    godown = true;
                    line = line + 2;
                }
            }
        }
        String res = "";
        for(StringBuilder each : sb){
            res = res + each.toString();
        }
        return res;
    }
}
