def matMul(m1, m2):
    m3 = []
    for i in range(len(m1)):
        temp = []
        for j in range(len(m2[0])):
            t = 0
            for k in range(len(m2)):
                t += m1[i][k] * m2[k][j]
            temp.append(t)
        m3.append(temp)
    return m3

def power(m, p):
    res = [
        [1, 0],
        [0, 1]
    ]
    while p>0:
        if p&1==1:
            res = matMul(res, m)
        p>>=1
        m = matMul(m, m)
    return res

def getAns(n):
    start = [[1, 1]]
    mat = [
        [0, 1],
        [1, 1]
    ]
    if n==1:
        return start[0][0]
    elif n==2:
        return start[0][1]
    else:
        m = power(mat, n-2)
        a = matMul(start, m)
        return a[0][1]

print(getAns(6))