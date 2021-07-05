def getMaxSegments(n, lengths):
    dp = [0]*(n+1)
    for i in lengths:
        if i<len(dp):
            dp[i] = 1
    for i in range(len(dp)):
        if dp[i]!=0:
            for length in lengths:
                if i+length < len(dp):
                    dp[i+length] = max(dp[i+length], dp[i]+1)
    return dp[-1]

print(getMaxSegments(5, [5, 3, 2]))