n, m = map(int, input().split())

answer = [i for i in range(n+1)]

for _ in range(m):
    i, j = map(int, input().split())
    tmp = answer[i:j + 1]
    tmp.reverse()
    answer = (answer[:i] + tmp + answer[j+1:])
print(" ".join(map(str, answer[1:])))