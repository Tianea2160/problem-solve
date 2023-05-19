from collections import deque

n, m, k = map(int, input().split())

maps = [[int(c) for c in input()] for _ in range(n)]
visit = [[[False for _ in range(m)] for _ in range(n)] for _ in range(k + 1)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

queue = deque([[k, 0, 0, 1]])
visit[k][0][0] = True

ans = -1
while queue:
    z, y, x, v = queue.popleft()

    if y == n - 1 and x == m - 1:
        ans = v
        break
    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]

        if 0 <= ny < n and 0 <= nx < m:
            if z > 0 and maps[ny][nx] == 1 and not visit[z - 1][ny][nx]: # 벽을 뚫을 수 있는 기회가 있는 경우
                visit[z - 1][ny][nx] = True
                queue.append([z - 1, ny, nx, v + 1]) # 벽을 뚫을 수 있는 기회가 없는 경우
            if maps[ny][nx] == 0 and not visit[z][ny][nx]:
                visit[z][ny][nx] = True
                queue.append([z, ny, nx, v + 1])

print(ans)