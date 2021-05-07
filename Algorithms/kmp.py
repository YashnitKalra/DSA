def kmp(s,p):
    t = p + '$' + s
    prefix = computePrefix(t)
    indices = []
    for i in range(len(p)+1, len(t)):
        if prefix[i] == len(p):
            indices.append(i - 2*len(p))
    return indices

def computePrefix(s):
    prefix = [0]*len(s)
    border = 0
    for i in range(1,len(s)):
        while border>0 and s[i]!=s[border]:
            border = prefix[border-1]
        if s[i] == s[border]:
            border += 1
        else:
            border = 0
        prefix[i] = border
    return prefix

# to find pattern in string create a new string "P + any symbol not appearing in pattern + S"
# compute prefix of new string and where ever the value is equal to length of pattern
# subtract |P|-1 from the value to get index of string where pattern was found
# but this is the position in new string subtract pattern length to get index in original string

pat = input()
s = input()
indices = kmp(s,pat)
print(pat)
print(s)
print(indices)