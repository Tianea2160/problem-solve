from collections import deque

n, k = map(int, input().split())

queue = deque([[n, 0]])
visit = [-1] * 100001

while queue:
    x, v = queue.popleft()
    if x == k:
        tmp = [k]
        visit[n] = -1
        idx = k
        while visit[idx] != -1:
            tmp.append(visit[idx])
            idx = visit[idx]
        print(v)
        print(" ".join(map(str, tmp[::-1])))
        break
    a, b, c = x - 1, x + 1, x * 2

    if c <= 100000 and visit[c] == -1:
        visit[c] = x
        queue.append([c, v + 1])
    if a >= 0 and visit[a] == -1:
        visit[a] = x
        queue.append([a, v + 1])
    if b <= 100000 and visit[b] == -1:
        visit[b] = x
        queue.append([b, v + 1])

