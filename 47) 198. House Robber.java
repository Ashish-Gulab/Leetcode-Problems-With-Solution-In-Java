/*****************************************************************    Problem Statement      ***************************************************************************/


You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
  
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
  
  
  
/*****************************************************************    Solution     ***************************************************************************/
// TC:O(N), Space:O(1)
// Dynamic Programming Approach Tabulation with Space Optimization

class Solution {
    public int rob(int[] nums) {
        int prev=nums[0];
        int prev2=0;
        if(nums.length==0)
        {
            return 0;
        }
        if(nums.length==1)
        {
            return prev;
        }
        for(int i=1;i<nums.length;i++)
        {
            int pick=nums[i];
            if(i>1)
            {
                pick+=prev2;
            }
            int notPick=0+prev;
            int curr=Math.max(pick,notPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
