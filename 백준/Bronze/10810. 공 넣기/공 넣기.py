n, m = map(int, input().split())

answer = [0] * (n + 1)

for _ in range(m):
    start, end, k = map(int, input().split())

    for x in range(start, end + 1):
        answer[x] = k
print(" ".join(map(str, answer[1:])))
