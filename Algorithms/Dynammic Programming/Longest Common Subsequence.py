# ABCDGH, AEDFHR, LCS = ADH
#       A   B   C   D   G   H
#   A   1   1   1   1   1   1 
#   E   1   1   1   1   1   1
#   D   1   1   1   2   2   2
#   F   1   1   1   2   2   2
#   H   1   1   1   2   2   3
#   R   1   1   1   2   2   3

def lcs(a, b):
    n, m = len(a), len(b)
    arr = [[0]*(m+1) for _ in range(n+1)]
    for i in range(n):
        for j in range(m):
            if a[i]==b[j]:
                arr[i+1][j+1] = 1 + arr[i][j]
            else:
                arr[i+1][j+1] = max(arr[i][j+1], arr[i+1][j])
    return arr[-1][-1]

print(lcs("ABCDGH", "AEDFHR"))