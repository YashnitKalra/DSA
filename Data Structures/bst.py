class BstNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Bst:
    def __init__(self):
        self.root = None
        self.shoot = 0
    
    def insert(self, val):
        if self.root == None:
            self.root = BstNode(val)
        else:
            p = self.root
            while p!=None:
                r = p
                if val < p.val:
                    p = p.left
                else:
                    p = p.right
            if val < r.val:
                r.left = BstNode(val)
            else:
                r.right = BstNode(val)