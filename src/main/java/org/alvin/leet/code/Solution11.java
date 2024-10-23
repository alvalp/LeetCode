package org.alvin.leet.code;

public class Solution11 {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length-1;
        int ans = Integer.MIN_VALUE;
        while(left< right){
            ans = Math.max(ans, (right-left) * Math.min(height[left], height[right]));
            // 左边低, 只能左边向右边移动。 因为移动之后x向值变小，如果左边低，则相乘结果只会更小
            // 所以这种情况下， 只能是左边向右边移动。
            if(height[left] <=height[right]){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution11().maxArea(heights));
    }
}
