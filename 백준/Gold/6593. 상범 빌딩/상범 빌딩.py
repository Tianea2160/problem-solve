from collections import deque

while True:
    l, r, c = map(int, input().split())
    if l == 0 and r == 0 and c == 0:
        break
    maps = []
    for i in range(l):
        tmp = []
        for j in range(r):
            tmp.append(input())
        input()
        maps.append(tmp)

    visit = [[[False] * c for _ in range(r)] for _ in range(l)]
    dz = [1, -1, 0, 0, 0, 0]
    dy = [0, 0, 1, -1, 0, 0]
    dx = [0, 0, 0, 0, 1, -1]

    z, y, x = 0, 0, 0
    for i in range(l):
        for j in range(r):
            for k in range(c):
                if maps[i][j][k] == 'S':
                    z, y, x = i, j, k

    queue = deque([[z, y, x, 0]])
    visit[z][y][x] = True

    answer = "Trapped!"

    while queue:
        z, y, x, v = queue.popleft()

        if maps[z][y][x] == "E":
            answer = f"Escaped in {v} minute(s)."
            break
        for i in range(6):
            nz, ny, nx = z + dz[i], y + dy[i], x + dx[i]

            if 0 <= nz < l and 0 <= ny < r and 0 <= nx < c and not visit[nz][ny][nx] and maps[nz][ny][nx] != "#":
                visit[nz][ny][nx] = True
                queue.append([nz, ny, nx, v + 1])
    print(answer)
