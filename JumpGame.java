public class JumpGame {
    public static void main(String[] args){
        int[] nums = {2,5,0,0};
        canJump(nums);
    }

    public static boolean canJump(int[] nums) {
        return canJump(nums,0);

    }

    private static boolean canJump(int[] nums, int start){
        if(start >= nums.length - 1)
            return true;
        int step = nums[start];
        for(int i = step; i > 0; i --){
            if(canJump(nums, start + step))
                return true;
        }
        return false;
    }
}
