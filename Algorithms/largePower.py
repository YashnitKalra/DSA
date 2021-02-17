# Fermat's Theorem
# a^(p-1) % p = 1, p => prime number

# (a^b)%p = (a^(p-1) * a^(p-1) * a^(p-1) * ... * a^x)%p
# a^(p-1) comes b//(p-1) and x = b%(p-1)

def power(a,b,m):
    res = 1
    while b>0:
        if b&1==1:
            res = (res%m * a%m)%m
        b>>=1
        a = (a%m * a%m)%m
    return res

a = 3
b = str(10**(10**5))
m = 10**9+7

rem = 0
for i in b:
    rem = ((rem*10)%(m-1) + (ord(i)-ord('0'))%(m-1) )%(m-1)

print(power(a,rem,m))