# Euler's totient function counts number of positive integers upto n that are co-prime with n
# Let totient function be phi()
# phi(p) = p-1, where p is a prime number

# phi(p**x) = p**x - Number of multiples of p till x
# phi(p**x) = p**x - (p**x)/p
# phi(p**x) = (p**(x-1))(p-1)

# Euler's totient function is a multiplicative function i.e.,
# f(n * m) = f(n) * f(m), where gcd(n ,m) = 1
# n = (p1**x1)(p2**x2)...(pk**xk)
# phi(n) = phi(p1**x1) * phi(p2**x2) * ... * phi(pk**xk)
# phi(n) = (p1**(x1-1))(p1-1) * (p2**(x2-1))(p2-1) * ... * (pk**(xk-1))(pk-1)
# dividing and  multiplying by n
# phi(n) = n * (p1-1)/p1 * (p2-1)/p2 * ... * (pk-1)/pk

# O(sqrt(n)) time complexity
def phi(n):
    res = n
    for i in range(2, int(n**0.5)+1):
        if n%i==0:
            res //= i
            res = res * (i-1)
            while n%i==0:
                n//=i
    if n>1:
        res //= n
        res = res * (n-1)
    return res

print(phi(20), phi(497), phi(1997), phi(10**6))

# Using sieve
# O(n log(log n))
p = [i for i in range(10**6 + 1)]
for i in range(2, len(p)):
    if i==p[i]:
        for j in range(i, len(p), i):
            p[j] //= i
            p[j] = p[j] * (i-1)
print(p[20], p[497], p[1997], p[10**6])