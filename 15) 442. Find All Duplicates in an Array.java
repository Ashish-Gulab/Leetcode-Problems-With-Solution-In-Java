/****************************************************************  Problem Statement   **********************************************************/
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Example 2:

Input: nums = [1,1,2]
Output: [1]

Example 3:

Input: nums = [1]
Output: []
 
Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.
  
  
/****************************************************************   Solution    ***********************************************************************/
  
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
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
                list.add(nums[k]);
            }
        }
        return list;
    }
}
