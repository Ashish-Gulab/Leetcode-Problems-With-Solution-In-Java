/*******************************************************************  Problem Statement   ************************************************************************/


You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Example 2:

Input: nums = [1,1]
Output: [1,2]
 
Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
 
  
/*******************************************************************    Solution     ************************************************************************/
  
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n)
        {
            int cor_position=nums[i]-1;
            if(nums[cor_position]!=nums[i])
            {
                int temp=nums[i];
                nums[i]=nums[cor_position];
                nums[cor_position]=temp;
            }
            else
            {
                i++;
            }
        }
        for(int k=0;k<n;k++)
        {
            if(nums[k]!=k+1)
            {
                return new int[]{nums[k],k+1};
            }
        }
        return new int[]{n,n};
    }
}
