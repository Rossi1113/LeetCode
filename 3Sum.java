/*  Break the problem to three parts:

1.sort the nums array.

2.create three pointers, current will go through the elements in nums,and left
pointer point to the next element after current,and right pointer point to the
last element.When we find the triplets,put into the result,and continue move
both left pointer and right pointer.

3.There can be duplicate triplets in the result. So after moving the left and
right,we need to check whether the new elements is equals to the former one,if
they are same,keep moving pointer. */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int cur = 0; cur < nums.length - 2; cur++){
            if(cur == 0 || (cur > 0 && nums[cur] != nums[cur-1])){
                int l = cur + 1;
                int r = nums.length-1;

                while(l < r){
                    int sum = nums[cur] + nums[l] + nums[r];
                    if(sum == 0){
                        res.add(Arrays.asList(nums[cur],nums[l],nums[r]));
                        while(l < r && nums[l] == nums[l+1]){
                            l++;
                        }
                        l++;
                        while(l < r && nums[r] == nums[r-1]){
                            r--;
                        }
                        r--;
                    } else if(sum < 0){
                        l++;
                    } else if(sum > 0){
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
