/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m-1>=0 || n-1>=0) {
            if (m-1>=0 && n-1>=0) {
                nums1[m+n-1] = Math.max(nums1[m-1], nums2[n-1]);
                if (nums1[m-1] >= nums2[n-1])
                    m--;
                else
                    n--;   
            } else if(m-1>=0){
                nums1[m+n-1] = nums1[--m];
            } else if(n-1>=0){
                nums1[m+n-1] = nums2[--n];
            }
        }

    }

}
// @lc code=end

