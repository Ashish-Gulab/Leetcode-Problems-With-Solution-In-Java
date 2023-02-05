/********************************************************************  Problem Statement   *************************************************************************/

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]
 
Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n


/*****************************************************************   Solution     *********************************************************************************/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
                list.add(k+1);
            }
        }
        return list;
    }
}
