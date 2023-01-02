/*******************************************************      Problem Statement      *****************************************************************************/

Given an m x n matrix, return all elements of the matrix in spiral order.

 1  ->  2  ->  3  ->  4
                      |
 5  ->  6  ->  7      8
 |                    |
 9  <- 10  <- 11  <- 12

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100


/*******************************************************************    Solution      *****************************************************************************/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<Integer>();
        int rowTop=0, rowBottom=(matrix.length)-1, colStart=0, colEnd=(matrix[0].length)-1;
        while(rowTop<=rowBottom && colStart<=colEnd)
        {
            for(int i=colStart;i<=colEnd;i++)
            {
                list.add(matrix[rowTop][i]);
            }
            rowTop++;
            for(int i=rowTop;i<=rowBottom;i++)
            {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowTop<=rowBottom)
            {
                for(int i=colEnd;i>=colStart;i--)
                {
                    list.add(matrix[rowBottom][i]);
                }
            }
            rowBottom--;
            if(colStart<=colEnd)
            {
                for(int i=rowBottom;i>=rowTop;i--)
                {
                    list.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return list;
    }
}
