package com.zhl.sort;
class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
            }
        }
        return dp[m][n];
    }

        /**
         * longest common substring
         * @param str1 string字符串 the string
         * @param str2 string字符串 the string
         * @return string字符串
         */
        public static String LCS (String str1, String str2) {
            // write code here

            int len1 = str1.length(), len2 = str2.length();
            if(len1 == 0 || len2 == 0) return "-1";
            int[][] dp = new int[len1][len2];
            int maxLen = 0, maxIndex = 0;
            for(int i=0; i<len1; i++) {
                for(int j=0; j<len2; j++) {
                    if(str1.charAt(i) == str2.charAt(j)) {
                        if(i==0 || j==0) dp[i][j] = 1;
                        else dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                    if(dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        maxIndex = i;
                    }
                }
            }
            if(maxLen == 0) return "-1";
            return str1.substring(maxIndex-maxLen+1,maxIndex+1);
        }

    public static void main(String[] args) {
        String s1="abdcc";
        String s2="dabdc";
        System.out.println(longestCommonSubsequence(s1, s2));
        System.out.println(LCS(s1,s2));
    }
}
