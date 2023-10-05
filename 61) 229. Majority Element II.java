/****************************************************************************       Problem Statement    **************************************************************************************************/

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:

Input: nums = [3,2,3]
Output: [3]
  
Example 2:

Input: nums = [1]
Output: [1]
  
Example 3:

Input: nums = [1,2]
Output: [1,2]
 
Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109


/****************************************************************************         Solution       *********************************************************************************************************/

import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
       List<Integer> list=new ArrayList<>();
       int n=nums.length;
       int num=n/3;
       if(num<1)
       {
           if(n>1 && nums[0]==nums[1])
           {
               list.add(nums[0]);
           }
           else
           {
                for(int a:nums)
                {
                    list.add(a);
                }
           }
           
           return list;
       } 
       else
       {
           int count=1;
           Arrays.sort(nums);
           for(int i=0;i<n-1;i++)
           {
               if(nums[i]==nums[i+1])
               {
                   count++;
                   if(i==n-2)
                    {
                        if(count>num)
                        {
                            list.add(nums[i]);
                        }
                    }
               }
               else
               {
                   if(count>num)
                   {
                       list.add(nums[i]);
                   }
                   count=1;
               }
           }
       }
       return list;
    }
}
