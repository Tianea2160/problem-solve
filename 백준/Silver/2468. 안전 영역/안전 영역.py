from collections import deque

n = int(input())

maps = [list(map(int, input().split())) for _ in range(n)]
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def bfs(start, limit, visit):
    y, x = start
    queue = deque([[y, x]])
    visit[y][x] = True
    while queue:
        y, x = queue.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= ny < n and 0 <= nx < n and not visit[ny][nx] and maps[ny][nx] >= limit:
                visit[ny][nx] = True
                queue.append([ny, nx])


def process(limit):
    visit = [[False] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if not visit[i][j] and maps[i][j] >= limit:
                cnt += 1
                bfs([i, j], limit, visit)
    return cnt


ans = 0
for i in range(1, 101):
    ans = max(process(i), ans)
print(ans)
