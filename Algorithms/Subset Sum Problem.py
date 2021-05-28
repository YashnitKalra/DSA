# given non-negative integers find if there exists a subset whose sum is 'S'.
#       0   1   2   3   4   5   6
# 1     T   T   F   F   F   F   F        
# 2     T   T   T   T   F   F   F
# 3     T   T   T   T   T   T   T


def ssp(arr, S):
    dp = [[False]*(S+1) for _ in range(2)]
    dp[1][0] = True
    a = 0
    for num in arr:
        for i in range(S+1):
            if i<num:
                dp[a][i] = dp[1-a][i]
            else:
                dp[a][i] = dp[1-a][i] or dp[1-a][i-num]
        a = 1-a
    return dp[1-a][-1]

arr = [3, 34, 4, 12, 5, 2]
print(ssp(arr, 9))
print(ssp(arr, 30))