import java.util.Arrays;

public class Heaters {
    public static void main(String[] args){
        int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        System.out.println(findRadius(houses,heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int min = 0;
        int distance = 0;
        for(int house: houses){
            int index = Arrays.binarySearch(heaters, house);
            if(index == -1){
                distance = heaters[index+1]- house;
            } else if(index == -heaters.length-1){
                distance = house - heaters[heaters.length-1];
            } else if(index < 0){
                index = -index - 1;
                distance = Math.min(house - heaters[index-1],heaters[index] - house);
            } else{
                distance = 0;
            }
            min = Math.max(min,distance);
        }
        return min;
    }
}
