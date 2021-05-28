# Using binary tree where left is for 0 and right is for 1

class Node:
    def __init__(self):
        self.left = None
        self.right = None

class BTrie:
    def __init__(self, bits):
        self.bits = bits
        self.root = Node()
    
    def insert(self, num):
        p = self.root
        mask = 1<<(self.bits-1)
        for _ in range(self.bits):
            if (num & mask)==0:
                if p.left==None:
                    p.left = Node()
                p = p.left
            else:
                if p.right==None:
                    p.right = Node()
                p = p.right
            mask >>= 1
    
    def getMaxXorNum(self, num):
        p = self.root
        mask = 1<<(self.bits-1)
        ans = 0
        for _ in range(self.bits):
            if (num & mask)==0:
                if p.right!=None:
                    ans |= mask
                    p = p.right
                else:
                    p = p.left
            else:
                if p.left!=None:
                    p = p.left
                else:
                    ans |= mask
                    p = p.right
            mask >>= 1
        return ans

btrie = BTrie(30)
a = [1, 2, 3]
b = [4, 1, 2]
for i in a:
    btrie.insert(i)
for i in b:
    print(btrie.getMaxXorNum(i) ^ i)