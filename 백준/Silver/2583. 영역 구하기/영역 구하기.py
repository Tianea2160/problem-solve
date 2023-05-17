from collections import deque

h, w, t = map(int, input().split())

maps = [[0] * w for _ in range(h)]
visit = [[False] * w for _ in range(h)]

for _ in range(t):
    a, b, c, d = map(int, input().split())
    for i in range(b, d):
        for j in range(a, c):
            maps[i][j] = 1

# for l in maps: print(l)

dy = [0, 0, -1, 1]
dx = [1, -1, 0, 0]


def bfs(start):
    y, x = start

    queue = deque([start])
    visit[y][x] = True
    cnt = 0
    while queue:
        y, x = queue.popleft()
        cnt += 1
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]

            if 0 <= ny < h and 0 <= nx < w and not visit[ny][nx] and maps[ny][nx] == 0:
                visit[ny][nx] = True
                queue.append([ny, nx])
    return cnt


region_cnt = 0
s = []
for i in range(h):
    for j in range(w):
        if not visit[i][j] and maps[i][j] == 0:
            region_cnt += 1
            s.append(bfs([i, j]))
s.sort()
print(region_cnt)
print(" ".join(map(str, s)))
