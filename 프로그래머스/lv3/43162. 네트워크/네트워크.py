from collections import defaultdict, deque

def dfs(visit, n, start, maps):
    queue = deque([start])
    
    while queue:
        cur = queue.popleft()
        for nxt in maps[cur]:
            if not visit[nxt]:
                visit[nxt] = True
                queue.append(nxt)
def solution(n, computers):
    answer = 0
    visit = [False] * n
    maps = defaultdict(list)
    
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            if computers[i][j] == 1:
                maps[i].append(j)
                maps[j].append(i)
    
    for i in range(n):
        if not visit[i]:
            dfs(visit, n, i, maps)
            answer+=1
    
    return answer