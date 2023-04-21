n, m = map(int, input().split())
answer = [i for i in range(n+1)]

for _ in range(m):
    i, j = map(int, input().split())
    answer[i], answer[j] = answer[j], answer[i]
print(" ".join(map(str, answer[1:])))