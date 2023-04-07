/**************************************************************    Problem Statement     ***************************************************************************/

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
  
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
  
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 
Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
  
  
/*****************************************************************    Solution     *********************************************************************************/
  
// Beats 57.92%
import java.util.*;
class Solution {
    private class Node
    {
        Node children[];
        boolean endOfWord;

        public Node()
        {
            this.children=new Node[26];
            for(int i=0;i<26;i++)
            {
                children[i]=null;
            }

            this.endOfWord=false;
        }
    }

    private Node root=new Node();

    private void insert(String word)
    {
        Node curr=root;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null)
            {
                curr.children[index]=new Node();
            }
            if(i==word.length()-1)
            {
                curr.children[index].endOfWord=true;
            }
            curr=curr.children[index];
        }
    }

    private boolean search(String word)
    {
        Node curr=root;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null)
            {
                return false;
            }
            if(i==word.length()-1 && curr.children[index].endOfWord==false)
            {
                return false;
            }
            curr=curr.children[index];
        }
        return true;
    }

    Map<String,Boolean> map=new HashMap<>();
    private boolean wordBreakProblem(String key)
    {
        if(key.length()==0)
        {
            return true;
        }
        if(map.containsKey(key))
        {
            return map.get(key);
        }
        for(int i=1;i<=key.length();i++)
        {
            String first=key.substring(0,i);
            String second=key.substring(i);
            if(search(first) && wordBreakProblem(second))
            {
                map.put(key,true);
                return true;
            }
        }
        map.put(key,false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i=0;i<wordDict.size();i++)
        {
            insert(wordDict.get(i));
        }
        return wordBreakProblem(s);
    }
}

// Beats 41.57%
// import java.util.*;
// class Solution
// {
//     Map<String, Boolean> map=new HashMap<>();
//     public boolean wordBreak(String s, List<String> wordDict)
//     {
//         if(wordDict.contains(s))
//         {
//             return true;
//         }
//         if(map.containsKey(s))
//         {
//             return map.get(s);
//         }
//         for(int i=1;i<=s.length();i++)
//         {
//             String first=s.substring(0,i);
//             if(wordDict.contains(first) && wordBreak(s.substring(i),wordDict))
//             {
//                 map.put(s,true);
//                 return true;
//             }
//         }
//         map.put(s,false);
//         return false;
//     }
// }


