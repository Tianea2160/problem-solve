from collections import Counter

n, c = map(int, input().split())
nums = list(map(int, input().split()))
first = {}
for i, num in enumerate(nums):
    if num in first:
        continue
    first[num] = i
counter = Counter(nums)
nums.sort(key=lambda x: (-counter[x], first[x]))
print(" ".join(map(str, nums)))
