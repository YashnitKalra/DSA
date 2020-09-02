class TrieNode:
    def __init__(self,data):
        self.mapping = {}
        self.endofword = False
        self.data = data
    
class Trie:
    def __init__(self):
        self.root=TrieNode(0)
        self.count = 1
    
    def addWord(self,s):
        p = self.root
        for i in range(len(s)):
            if s[i] not in p.mapping:
                p.mapping[s[i]] = TrieNode(self.count)
                self.count+=1
            p = p.mapping[s[i]]
        p.endofword = True
    


        