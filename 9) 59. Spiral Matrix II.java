/*************************************************************  Problem Statement   ********************************************************************************/

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
  
 1  ->  2  ->  3
               |
 8  ->  9      4
 |             |
 7  <-  6  <-  5

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
  
  
/************************************************************   Solution     *****************************************************************************************/
  
  
  // class Solution {
//     public int[][] generateMatrix(int n) {
//         int[][] arr=new int[n][n];
//         int rowTop=0,rowBottom=n-1,colStart=0,colEnd=n-1;
//         arr[0][0]=0;
//         if(n==0) return arr;
//         while(rowTop<=rowBottom && colStart<=colEnd)
//         {
//             for(int i=colStart;i<=colEnd;i++)
//             {
//                 if((i-1)<0)
//                 {
//                     arr[rowTop][i]=1;
//                 }
//                 else
//                 {
//                     arr[rowTop][i]=arr[rowTop][i-1]+1;
//                 }
//             }
//             rowTop++;
//             for(int i=rowTop;i<=rowBottom;i++)
//             {
//                 arr[i][colEnd]=arr[i-1][colEnd]+1;
//             }
//             colEnd--;
//             if(rowTop<=rowBottom)
//             {
//                 for(int i=colEnd;i>=colStart;i--)
//                 {
//                     arr[rowBottom][i]=arr[rowBottom][i+1]+1;
//                 }
//             }
//             rowBottom--;
//             if(colStart<=colEnd)
//             {
//                 for(int i=rowBottom;i>=rowTop;i--)
//                 {
//                     arr[i][colStart]=arr[i+1][colStart]+1;
//                 }
//             }
//             colStart++;
//         }
//         return arr;
//     }
// }


class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr=new int[n][n];
        int rowTop=0,rowBottom=n-1,colStart=0,colEnd=n-1;
        int count=1;
        if(n==0) return arr;
        while(rowTop<=rowBottom && colStart<=colEnd)
        {
            for(int i=colStart;i<=colEnd;i++)
            {
                arr[rowTop][i]=count++;
            }
            rowTop++;
            for(int i=rowTop;i<=rowBottom;i++)
            {
                arr[i][colEnd]=count++;
            }
            colEnd--;
            if(rowTop<=rowBottom)
            {
                for(int i=colEnd;i>=colStart;i--)
                {
                    arr[rowBottom][i]=count++;
                }
            }
            rowBottom--;
            if(colStart<=colEnd)
            {
                for(int i=rowBottom;i>=rowTop;i--)
                {
                    arr[i][colStart]=count++;
                }
            }
            colStart++;
        }
        return arr;
    }
}
