from collections import deque

def explore(adjList,n,src,dest):
    parent = [-1]*n
    visited=[False]*n
    d=deque([src])
    visited[src]=True
    while len(d)>0:
        at = d.popleft()
        if at==dest:
            return parent
        for i in adjList[at]:
            if not visited[i] and adjList[at][i]>0:
                visited[i]=True
                d.append(i)
                parent[i]=at
    return None

def getBottleNeck(adjList,parent,dest):
    p=dest
    c=10**18
    while parent[p]!=-1:
        c=min(c,adjList[parent[p]][p])
        p=parent[p]
    return c

def updateGraph(adjList,parent,dest,flow):
    p=dest
    while parent[p]!=-1:
        adjList[parent[p]][p]-=flow
        adjList[p][parent[p]]+=flow
        p=parent[p]

n,m=map(int,input().split())
adjList = [{} for _ in range(n)]
for _ in range(m):
    a,b,c = map(int,input().split())
    adjList[a][b] = c
    adjList[b][a] = 0
src,dest=map(int,input().split())
maxFlow = 0
path = explore(adjList,n,src,dest)
while path:
    f = getBottleNeck(adjList,path,dest)
    maxFlow += f
    updateGraph(adjList,path,dest,f)
    path = explore(adjList,n,src,dest)
print(maxFlow)