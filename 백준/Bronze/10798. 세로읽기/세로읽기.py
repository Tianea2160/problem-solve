n = 5
maps = []
for _ in range(n):
    maps.append(input())
answer = ''

for i in range(15):
    for j in range(n):
        if len(maps[j]) <= i:
            continue
        answer += maps[j][i]
print(answer)