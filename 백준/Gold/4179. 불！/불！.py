from collections import deque

n, m = map(int, input().split())

maps = []
for _ in range(n):
    maps.append([c for c in input()])

init = []
for i in range(n):
    for j in range(m):
        if maps[i][j] == "J":
            init.append([i, j, 1])

for i in range(n):
    for j in range(m):
        if maps[i][j] == "F":
            init.append([i, j, -1])
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
queue = deque(init)
answer = "IMPOSSIBLE"

while queue:
    y, x, v = queue.popleft()
    if v >= 0 and maps[y][x] != "F" and (y == 0 or x == 0 or y == n - 1 or x == m - 1):
        answer = v
        break

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]
        if 0 <= ny < n and 0 <= nx < m and maps[ny][nx] != "#":
            if v > -1 and maps[ny][nx] == ".":
                maps[ny][nx] = "J"
                queue.append([ny, nx, v + 1])
            if v == -1 and maps[ny][nx] != "F":
                maps[ny][nx] = "F"
                queue.append([ny, nx, -1])

    # person
print(answer)
