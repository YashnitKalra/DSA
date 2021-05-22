# Infinite coins with n different values
# Find number of ways to get Amount "A"
# Order of coins doesn't matter
# E.g. coins = [1,2,3], A = 4
# Ways = {1,1,1,1}, {1,1,2}, {1,3}, {2,2} = 4 ways

#       0   1   2   3   4   (Amount)
#   0   1   0   0   0   0
#   1   1   1   1   1   1
#   2   1   1   2   2   2
#   3   1   1   2   3   3

# can also use 1-D array

def getNumberOfWays(coins, amount):
    arr = [[0]*(amount+1) for _ in range(len(coins)+1)]
    for i in range(len(coins)+1):
        arr[i][0] = 1
    for i in range(1, len(coins)+1):
        for j in range(1, amount+1):
            if j<coins[i-1]:
                arr[i][j] = arr[i-1][j]
            else:
                arr[i][j] = arr[i-1][j] + arr[i][j-coins[i-1]]
    return arr[-1][-1]

print(getNumberOfWays([5,4,3,2,1], 5))