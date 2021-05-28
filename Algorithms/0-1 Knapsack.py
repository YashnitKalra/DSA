# Given some items with values and weights
# Knapsack can accomodate maximum 'W' weight
# Find the maximum value such that sum of weights <= W
# values = [10, 20, 30]
# weights = [2,3,4]
# W = 10
#       0   1   2   3   4   5   6   7   8   9
#   2   0   0   10  10  10  10  10  10  10  10
#   3   0   0   10  10  20  30  30  30  30  30
#   4   0   0   10  10  10  10  40  40  50  70

def knapsack(values, weights, W):
    dp = [[0]*(W+1) for _ in range(len(weights)+1)]
    for i in range(1, len(weights)+1):
        for j in range(1, W+1):
            if j<weights[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-weights[i-1]] + values[i-1])
    return dp[-1][-1]

values = [60, 100, 120]
weights = [10, 20, 30]
print(knapsack(values, weights, W=50))