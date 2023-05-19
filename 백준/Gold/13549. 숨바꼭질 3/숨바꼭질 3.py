import sys
from collections import deque

input = sys.stdin.readline
n, k = map(int, input().split())

visit = [False] * 100001

queue = deque([[n, 0]])
visit[n] = True

while queue:
    cur, v = queue.popleft()
    if cur == k:
        print(v)
        break

    a, b, c = cur - 1, cur + 1, cur * 2

    if c <= 100000 and not visit[c]:
        visit[c] = True
        queue.append([c, v])

    if a >= 0 and not visit[a]:
        visit[a] = True
        queue.append([a, v + 1])
    if b <= 100000 and not visit[b]:
        visit[b] = True
        queue.append([b, v + 1])
