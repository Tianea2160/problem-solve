from collections import deque

n, m = map(int, input().split())

maps = [[int(c) for c in input()] for _ in range(n)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]


def bfs():
    queue = deque([[0, 0, 0, 1]])
    visit = [[[False] * m for _ in range(n)] for _ in range(2)]
    visit[0][0][0] = True
    ans = 987654321

    while queue:
        z, y, x, v = queue.popleft()

        if y == n - 1 and x == m - 1:
            ans = v
            break
        for i in range(4):
            nz, ny, nx = z, y + dy[i], x + dx[i]

            if 0 <= ny < n and 0 <= nx < m:
                if maps[ny][nx] == 0 and not visit[z][ny][nx]:
                    visit[z][ny][nx] = True
                    queue.append([nz, ny, nx, v + 1])
                if nz == 0 and maps[ny][nx] == 1 and not visit[1][ny][nx]:
                    visit[1][ny][nx] = True
                    queue.append([1, ny, nx, v + 1])
    return ans if ans != 987654321 else -1


print(bfs())
