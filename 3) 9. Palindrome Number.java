/********************************************************************   Problem Statement   ***********************************************************************/

Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
  
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
  
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:
-231 <= x <= 231 - 1
  
  
  /********************************************************************  Solution  ***********************************************************************************/
  
  class Solution {
    public boolean isPalindrome(int x) {
        int num=x;
        if(num<0)
        {
            return false;
        }
        if(num<=9 && num>=0)
        {
            return true;
        }
        int reverse=0;
        while(x>0)
        {
            int number=x%10;
            reverse=reverse*10+number;
            x=x/10;
        }
        if(num==reverse)
        {
            return true;
        }return false;
    }
}
