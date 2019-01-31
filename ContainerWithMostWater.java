/* First I would try to solve the problem by brute force, which enumerate all possible 2 lines combinations.
Then we can get the maximum area of container by comparison.
So there are two pointers, i and j, both of them iterate n integers. The time complexity will be O(N^2) with no extra space.

But is there any method that we can improve the time complexity?

If i and j both start from the front, we can't skip any potential lines.

Because the container area is min(height(line1),height(line2))*(line2 - line1).

We can easily see that with line2 move forward, (line2 - line1) gets larger, but height is not fixed, it can go up or go down. So each position would be a potential answer.

Since it's hard to move forward, can we think of another direction, like i start from the front and j start from the end.

For example:

[1,1,4,2,2,2,1]

    height  4
            |
            |  2  2  2
      1  1  |  |  |  |  1
    __|__|__|__|__|__|__|___
      1  2  3  4  5  6  7
      i                 j

here nums[1] == nums[7], area = 1*(7-1) = 6. max = 6. There is no difference we move i or j, because no matter i++ or j--, the height of container won't be larger, j-i will go down which makes next container won't be larger then previous container.

This is the condition of nums[i] == nums[j], we move left pointer go right.
Since nums[2] == nums[1], we can skip this container until we meet a larger height. the i will stop at line 3.

Then in the condition of nums[i] > nums[j], we would try to move the pointer with smaller height. Because with j-i going down, we can only make height bigger to reach a larger container. Then we decrease j by 1, it stops at line 6. Here, area = 2*(6-3) = 6, no need update maximum container.

Similarly we continue move j pointer to line5, line4, line3. Then two pointers meet, we end up searching.

Observation from above, using front pointer and end pointer can reduce the time complexity to linear time. Just follow the rule of how to move pointer.

1. if the heights of two pointer is same, then we can move left pointer.
2. always move the pointer with a smaller height, and the pointer will stop at a height which is larger then previous height.

So this method will cost O(N) running time with no extra space. */

class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = Integer.MIN_VALUE;
        int area = 0;
        int line = 0;
        while(i < j){
            if(height[i] <= height[j]){
                line1 = height[i];
                area = line1 * (j-i);
                max = Math.max(max,area);
                i++;
                while(i < j && line1 >= height[i]){
                    i++;
                }
            } else {
                line2 = height[j];
                area = line2 * (j-i);
                max = Math.max(max,area);
                j--;
                while(i < j && height[j] <= line2){
                    j--;
                }
            }
        }
        return max;
    }
}
