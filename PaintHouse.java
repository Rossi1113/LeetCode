import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaintHouse {
    public static void main(String[] args){
        int[][] costs = {{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        System.out.println(minCost(costs));
    }

    public static int minCost(int[][] costs) {
        int n = costs.length;
        int[] last = new int[3];
        int[] curr = new int[3];
        for(int i = 0; i < 3; i ++){
            last[i] = costs[0][i];
        }
        for(int i = 1; i < n; i ++){
            curr[0] = costs[i][0] + Math.min(last[1],last[2]);
            curr[1] = costs[i][1] + Math.min(last[0],last[2]);
            curr[2] = costs[i][2] + Math.min(last[0],last[1]);
            last = Arrays.copyOf(curr,3);
        }

        return Math.min(last[0],Math.min(last[1],last[2]));
    }

    public static int minCost2(int[][] costs) {
        int[] mincost = new int[1];
        mincost[0] = Integer.MAX_VALUE;
        DFS(costs,0,0,-1,mincost);
        return mincost[0];
    }

    private static void DFS(int[][] costs, int house, int cost, int color, int[] mincost){
        if(house == costs.length){
            mincost[0] = Math.min(cost,mincost[0]);
            return;
        }


        for(int i = 0; i < 3; i++){
            if(i == color)
                continue;
            DFS(costs,house+1,cost+costs[house][i],i,mincost);
        }
    }

}
