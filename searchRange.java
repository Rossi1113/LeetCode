/* Based on the requirement of O(logn), I think it can be solved by binary
search. Since we need to find a range , we need to do twice binary search,
1.find the first target location
2.find the last target location.
quite straightforward. just pay attention to the left border and right border.*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
           int left = 0;
           int right = nums.length -1;
           int mid = left + (right-left)/2;
           int[] result = {-1,-1};
           if(nums.length ==0)
               return result;

           //find first target
           while(left<right){
               mid = left+(right-left)/2;
               if(nums[mid]<target){
                   left = mid+1;
               }
               if(nums[mid]>=target){
                   right = mid;
               }
           }
           int start = left;

           //find last target
           left = 0;
           right = nums.length -1;
           while(left< right){
               mid = left+(right-left+1)/2;
               if(nums[mid]<=target){
                   left = mid;
               }
               if(nums[mid]>target){
                   right = mid-1;
               }
           }
           int end = left;
    //check if start is greater than end
    //check start number equal to target,false means no target found
           if(start<=end&&nums[start]==target){
               result[0]=start;
               result[1]=end;
           }

           return result;
       }
}
