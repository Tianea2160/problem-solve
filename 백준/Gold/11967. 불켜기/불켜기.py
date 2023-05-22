from collections import defaultdict, deque

n, m = map(int, input().split())

graph = defaultdict(list)
for _ in range(m):
    a, b, c, d = map(int, input().split())
    graph[(a - 1, b - 1)].append((c - 1, d - 1))
visit = [[False] * n for _ in range(n)]
light = [[False] * n for _ in range(n)]

queue = deque([[0, 0]])
visit[0][0] = True
light[0][0] = True

for y, x in graph[(0, 0)]:
    light[y][x] = True

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

while queue:
    y, x = queue.popleft()

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]
        if 0 <= ny < n and 0 <= nx < n and not visit[ny][nx] and light[ny][nx]:
            visit[ny][nx] = True
            queue.append([ny, nx])
            for a, b in graph[(ny, nx)]:
                light[a][b] = True
                for i in range(4):
                    na, nb = a + dy[i], b + dx[i]
                    if 0 <= na < n and 0 <= nb < n and visit[na][nb] and light[na][nb]:
                        queue.append([na, nb])

ans = 0
for i in range(n):
    for j in range(n):
        if light[i][j]:
            ans += 1

print(ans)
