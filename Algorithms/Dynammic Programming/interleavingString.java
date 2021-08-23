public class interleavingString {
    
    static boolean isPossible(String A, String B, String C){
        int n = A.length(), m = B.length();
        if(n + m != C.length())
            return false;
        
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=0; i<n; i++)
            dp[i+1][0] = (dp[i][0] & A.charAt(i)==C.charAt(i));
        
        for(int j=0; j<m; j++)
            dp[0][j+1] = (dp[0][j] & B.charAt(j)==C.charAt(j));
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                int k = i + j - 1;
                if(A.charAt(i-1) == C.charAt(k))
                    dp[i][j] |= dp[i-1][j];
                if(B.charAt(j-1) == C.charAt(k))
                    dp[i][j] |= dp[i][j-1];
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(isPossible("XY", "X", "XXY"));
    }

}
