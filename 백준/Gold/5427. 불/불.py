from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

t = int(input())

for _ in range(t):
    w, h = map(int, input().split())

    maps = [[c for c in input()] for _ in range(h)]
    init = []
    # 불의 위치 구하기
    for i in range(h):
        for j in range(w):
            if maps[i][j] == "*":
                init.append([i, j, -1])

    # 상근이 시작위치 구하기
    for i in range(h):
        for j in range(w):
            if maps[i][j] == "@":
                init.append([i, j, 0])

    queue = deque(init)
    ans = 'IMPOSSIBLE'
    # bfs 동작하기
    while queue:
        y, x, v = queue.popleft()

        if v > -1 and (y == 0 or y == h - 1 or x == 0 or x == w - 1):
            ans = v + 1
            break

        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]

            if 0 <= ny < h and 0 <= nx < w and maps[ny][nx] != "#":
                if v > -1 and maps[ny][nx] == ".":
                    maps[ny][nx] = "@"
                    queue.append([ny, nx, v + 1])
                if v == -1 and maps[ny][nx] != "*":
                    maps[ny][nx] = "*"
                    queue.append([ny, nx, -1])
    print(ans)
    # 결과 계산하기
