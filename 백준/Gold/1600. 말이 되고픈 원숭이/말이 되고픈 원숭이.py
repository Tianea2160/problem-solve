import sys
from collections import deque

k = int(input())

w, h = map(int, input().split())

maps = [list(map(int, input().split())) for _ in range(h)]
visit = [[[False for _ in range(k + 1)] for _ in range(w)] for _ in range(h)]

dy = [0, 0, 1, -1, -2, -1, 2, 1, -2, -1, 2, 1]
dx = [1, -1, 0, 0, -1, -2, -1, -2, 1, 2, 1, 2]

queue = deque([[0, 0, k, 0]])
visit[0][0][k] = True

ans = sys.maxsize

while queue:
    y, x, z, v = queue.popleft()

    if y == h - 1 and x == w - 1:
        ans = min(ans, v)
        break

    if z > 0:
        for i in range(4, 12):
            ny, nx, nz = y + dy[i], x + dx[i], z - 1
            if 0 <= ny < h and 0 <= nx < w and not visit[ny][nx][nz] and maps[ny][nx] == 0:
                visit[ny][nx][nz] = True
                queue.append([ny, nx, nz, v + 1])

    for i in range(4):
        ny, nx, nz = y + dy[i], x + dx[i], z
        if 0 <= ny < h and 0 <= nx < w and not visit[ny][nx][nz] and maps[ny][nx] == 0:
            visit[ny][nx][nz] = True
            queue.append([ny, nx, nz, v + 1])

print(ans if ans != sys.maxsize else -1)
