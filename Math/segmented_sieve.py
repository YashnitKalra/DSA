# to get prime numbers between L to R
# R can be large, for e.g.: R <= 10**12
# R-L+1 <= 10**6

# Find prime numbers till R**0.5 using sieve
r = 10**10
l = r - 50

n = int(r**0.5) + 1
primes = [True]*(n+1)
primes[0] = primes[1] = False
p = []
for i in range(2, len(primes)):
    if primes[i]:
        p.append(i)
        for j in range(i+i, len(primes), i):
            primes[j] = False

primes = [True]*(r-l+1)
# index 2 tells whether l+2 is prime or not
# index n tells whether l+n is prime or not

# we use the fact that if a number "n" is divisible by any number <= n**0.5, then it is not prime

for num in p:
    start = (l//num) * num  # getting the first multiple of prime in the range [l, r]
    if start<l:
        start += num
    for i in range(start-l, len(primes), num):
        primes[i] = False
for i in range(l, r+1):
    print(f"{i}: {primes[i-l]}")