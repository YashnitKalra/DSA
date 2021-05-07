def bellmanford(n,e,adjList,src):
    dist = [10**18]*n
    dist[src] = 0
    for _ in range(n-1):
        for u in range(n):
            for v in adjList[u]:
                w=adjList[u][v]
                if dist[u]!=10**18 and dist[u]+w<dist[v]:
                    dist[v] = dist[u] + w 
    return dist


n,m=map(int,input().split())
adjList = [{} for _ in range(n)]
for _ in range(m):
    u,v,w = map(int,input().split())
    adjList[u][v] = w
src = int(input())
dist = bellmanford(n,m,adjList,src)
print(dist)