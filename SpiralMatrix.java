import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        find(matrix,res,0,0,"r");

        return res;
    }
    public static void find(int[][] matrix,List<Integer> res,int x, int y, String s){
        int m = matrix.length;
        int n = matrix[0].length;
        res.add(matrix[x][y]);
        if(res.size() == m*n )
            return;
        matrix[x][y] = Integer.MIN_VALUE;
        int[] dir = new int[2];
        switch(s){
            case "r": dir[0] = 0;
                dir[1] = 1;
                break;
            case "d": dir[0] = 1;
                dir[1] = 0;
                break;
            case "l": dir[0] = 0;
                dir[1] = -1;
                break;
            case "u": dir[0] = -1;
                dir[1] = 0;
                break;
        }
        int nx = x + dir[0];
        int ny = y + dir[1];
        if(nx == m || ny == n || nx < 0 || ny < 0 || matrix[nx][ny] == Integer.MIN_VALUE){

            switch(s){
                case "r": find(matrix,res,x+1,y,"d");break;
                case "d": find(matrix,res,x,y-1,"l");break;
                case "l": find(matrix,res,x-1,y,"u");break;
                case "u": find(matrix,res,x,y+1,"r");break;
            }
        }else  find(matrix,res,nx,ny,s);
    }

}
