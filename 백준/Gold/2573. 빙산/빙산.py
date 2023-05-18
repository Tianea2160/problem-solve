import sys
from collections import deque

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
input = sys.stdin.readline

n, m = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(n)]
cnt = 0


def bfs(start):
    y, x = start

    queue = deque([start])
    visit[y][x] = True

    while queue:
        y, x = queue.popleft()
        # 주변의 0의 개수를 측정해서 새로운 지도에 적용
        c = 0
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]

            if 0 <= ny < n and 0 <= nx < m:
                if maps[ny][nx] == 0:
                    c += 1
                elif maps[ny][nx] > 0 and not visit[ny][nx]:
                    visit[ny][nx] = True
                    queue.append([ny, nx])
        new_maps[y][x] = max(maps[y][x] - c, 0)


# 새로운 지도를 그려야함
depth = 0
for _ in range(10000):
    depth += 1
    cnt = 0
    visit = [[False] * m for _ in range(n)]
    new_maps = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if maps[i][j] > 0 and not visit[i][j]:
                cnt += 1
                # print(i, j, depth, cnt)
                bfs([i, j])
    maps = new_maps
    if cnt > 1:
        break
print(depth - 1 if depth != 10000 else 0)
