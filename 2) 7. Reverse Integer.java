/**************************************************************   Problem Statement   *****************************************************************************/ 

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
  
Example 2:

Input: x = -123
Output: -321
  
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1
  
  
  
  /**********************************************************************    Solution    *****************************************************************/
  
  class Solution {
    public int reverse(int x) {
        if(x>=0 && x<=9)
        {
            return x;
        }
        int count=0;
        if(x<0)
        {
            x=x*(-1);
            count=1;
        }
        long reverse=0;
        while(x>0)
        {
            int number=x%10;
            reverse=reverse*10+number;
            x=x/10;
        }
        if(count==1)
        {
            reverse=reverse*(-1);
        }
        int rev=0;
        if(reverse<=2147483647 && reverse>=(-2147483648))
        {
            rev=(int)reverse;
            return rev;
        }
        return 0;
    }
}
