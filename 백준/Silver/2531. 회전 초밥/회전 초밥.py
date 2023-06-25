n, d, k, c = map(int, input().split(" "))
nums = [int(input()) for _ in range(n)]

left, right, result = 0, 0, 0

while left != n:
    right = left + k
    case = set()
    flag = True

    for i in range(left, right):
        i %= n
        case.add(nums[i])
        if nums[i] == c: flag = False
    count = len(case)
    if flag: count += 1
    result = max(result, count)

    left += 1

print(result)