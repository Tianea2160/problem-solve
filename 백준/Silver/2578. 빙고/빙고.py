maps = [list(map(int, input().split())) for _ in range(5)]
visit = [[False] * 5 for _ in range(5)]
bingo = set()
nums = []
for _ in range(5):
    num = list(map(int, input().split()))
    nums.extend(num)


def find_index(num):
    for i in range(5):
        for j in range(5):
            if num == maps[i][j]:
                return (i, j)
    return (-1, -1)


ans = 0


def check_bingo(y, x):
    result = 0
    flag = True
    for i in range(5):
        if not visit[y][i]:
            flag = False
            break
    if flag:
        result += 1
        bingo.add((y, 0, y, 4))

    flag = True
    for i in range(5):
        if not visit[i][x]:
            flag = False
            break
    if flag:
        result += 1
        bingo.add((0, x, 4, x))
    # 대각선 확인

    if (y, x) in [(0, 0), (1, 1), (2, 2), (3, 3), (4, 4), (0, 4), (1, 3), (3, 1), (4, 0)]:
        flag = True
        for i in range(5):
            if not visit[i][i]:
                flag = False
                break
        if flag:
            result += 1
            bingo.add((0, 0, 4, 4))

        flag = True
        for i in range(5):
            if not visit[i][4 - i]:
                flag = False
                break
        if flag:
            result += 1
            bingo.add((0, 4, 4, 0))

    return result


for idx, num in enumerate(nums):
    y, x = find_index(num)
    visit[y][x] = True
    ans += check_bingo(y, x)
    if len(bingo) >= 3:
        print(idx + 1)
        break
