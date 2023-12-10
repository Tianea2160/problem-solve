from collections import defaultdict

t = int(input())
for i in range(t):
    n = int(input())
    data = defaultdict(set)

    for j in range(n):
        clothes_name, clothes_type = input().split(" ")
        data[clothes_type].add(clothes_name)

    answer = 1
    for clothes_type, clothes in data.items():
        answer *= (len(clothes) + 1)
    answer -= 1  # 처음에 아무 것도 안입고 있는 경우 제거
    print(answer)
