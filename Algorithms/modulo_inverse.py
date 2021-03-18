# multiplicative inverse of n in 1/n
# n * 1/n = 1

# for modulo inverse
# (n * x)%p = 1
# x is modulo inverse of n
# it does not exist for every number
# condition gcd(n, p) == 1, then only it exists.

# **************************************************************
# USING FERMAT'S THEOREM
# 'p' should be prime
# it states that for any integer 'a':
# (a^p) % p = a % p
# dividing both sides by 'a'
# (a^(p-1)) % p = 1 % p
# dividing both sides by 'a'
# (a^(p-2)) % p = a^(-1) % p

class Fermat:
    def modInverse(self, a, p):
        return pow(a, p-2, p)

print(Fermat().modInverse(2,7))