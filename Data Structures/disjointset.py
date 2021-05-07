class DisjointSetNode:
    def __init__(self):
        self.parent=self
        self.size=1
        self.rank=0

class DisjointSet:
    def __init__(self,n):
        self.arr=[]
        for _ in range(n):
            self.arr.append(DisjointSetNode())
    
    def findParent(self, n):
        p = self.arr[n]
        while p.parent != p:
            p = p.parent
        self.arr[n].parent = p
        return p
    
    def union(self, a, b):
        p1, p2 = self.findParent(a), self.findParent(b)
        if p1==p2:
            return False
        if p1.rank>=p2.rank:
            p2.parent = p1
            p1.rank += 1 if p1.rank==p2.rank else 0
            p1.size += p2.size
        else:
            p1.parent = p2
            p2.size += p1.size
