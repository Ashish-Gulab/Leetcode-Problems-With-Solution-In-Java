Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example 1:

Input: n = 13
Output: 6
  
Example 2:

Input: n = 0
Output: 0
 
Constraints:

0 <= n <= 109
  
  
/************************************************************    Solution    **************************************************************************************/
  
 class Solution {
    public int countDigitOne(int n) {
        /* 
        dp[j] : The number of ones until j
        dp[j] = dp[j-1]+ number of i contributed by j
        O(N)
        
        f(9)=1
        f(99)=10*f(9)+10(contribution from [10-19])
        f(999)=10*f(99)+100(contribution from [100-199])
        
        f(26):
        [0-9] [10-19] [20-26]
        
        f(3467):
            [0-999] [1000-1999] [3000-3467]
            3*f(999)+1000+f(467)
        */
        
        if (n <= 0) return 0;
        int q = n, x = 1, ans = 0;
        do {
            int digit = q % 10;
            q /= 10;
            ans += q * x;
            if (digit == 1) ans += n % x + 1;
            if (digit >  1) ans += x;
            x *= 10;
        } while (q > 0);
        return ans;
        
    }
}
