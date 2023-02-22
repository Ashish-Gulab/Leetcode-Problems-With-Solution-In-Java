/*****************************************************************    Problem Statement      ***************************************************************************/


You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105



/*****************************************************************    Solution      ***************************************************************************/



// Approach: In the duplicate numbers the first number be always at the even index and second number be always at the odd index. if mid is odd then we observe the next element, if next element is not equal then the missing number should be right hand side else it will be left hand side

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-2;
        int n=nums.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(mid%2==0)
            {
                if(nums[mid]==nums[mid+1])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            else
            {
                if(nums[mid]!=nums[mid+1])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return nums[low];
    }
}
