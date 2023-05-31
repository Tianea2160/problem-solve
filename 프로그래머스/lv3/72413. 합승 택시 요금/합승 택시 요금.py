from heapq import heapify, heappush, heappop
from collections import defaultdict

def solution(n, s, a, b, fares):
    answer = 987654321
    maps = defaultdict(list)
    
    for u, v, w in fares:
        maps[u].append((v, w))
        maps[v].append((u, w))
        
    def dijstra(start):
        dist = [987654321]*(n+1)    
        dist[start] = 0
        heap = [(0, start)]
        heapify(heap)
        while heap:
            cnt, cur = heappop(heap)
            for nxt, w in maps[cur]:
                if dist[nxt] > dist[cur] + w:
                    dist[nxt] =  dist[cur] + w
                    heappush(heap, (dist[nxt], nxt))
        return dist
        
    fir = dijstra(s)
    
    for i in range(1, n+1):
        sec = dijstra(i)
        total_cost = fir[i] + sec[a] + sec[b]
        answer = min(answer, total_cost)
    return answer