import java.util.Arrays;

public class mergeSortedArray {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1;
        int p2 = n - 1;
        int index = nums1.length - 1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] >= nums2[p2]){
                nums1[index--] = nums1[p1--];
            } else nums1[index--] = nums2[p2--];
        }
        while(p2 >= 0){
            nums1[index--] = nums2[p2--];
        }
    }
}
