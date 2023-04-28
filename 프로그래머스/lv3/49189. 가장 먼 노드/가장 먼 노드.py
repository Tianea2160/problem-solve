from heapq import heapify, heappush, heappop
from collections import defaultdict

def solution(n, edge):
    answer = 0
    # 최단 거리로 갔을 때의 지나간 간선의 개수를 찾아야함
    # 다익스트라를 사용하라는 말
    maps= defaultdict(list)
    
    dist = [987654321]*(n+1)
    heap = [(0, 1)]
    heapify(heap)
    dist[1] = 0
    
    for u, v in edge:
        maps[u].append(v)
        maps[v].append(u)
    while heap:
        w, cur = heappop(heap)
        for nxt in maps[cur]:
            if dist[nxt] > dist[cur] + 1:
                dist[nxt] = dist[cur]+1
                heappush(heap, (dist[nxt], nxt))
    m = max(dist[1:])
    for i in range(1, len(dist)):
        if m ==  dist[i]:
            answer+=1
    return answer