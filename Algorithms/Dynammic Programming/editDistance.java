// min cost to convert s1 to s2
// Operations:
// 1. Insert a character
// 2. Remove a character
// 3. Replace a character

class editDistance{

    static int solution(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                if(i==0)
                    dp[i][j] = j;   // insert j characters
                else if(j==0)
                    dp[i][j] = i;   // remove i characters
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(
                        dp[i-1][j],         // insert
                        Math.min(
                            dp[i][j-1],     // remove
                            dp[i-1][j-1]    // replace
                        )
                    );
            }
        }
        
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(solution("intention", "execution"));
    }
}