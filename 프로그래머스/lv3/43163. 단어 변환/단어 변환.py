from collections import defaultdict, deque

def is_can_change(a, b):
    diff = 0
    n = len(a)
    for i in range(n):
        if a[i] != b[i]:
            diff += 1
    return diff == 1

def solution(begin, target, words):
    answer = 0
    
    if target not in words:
        return 0

    total_words = [begin] + words
    maps = defaultdict(list)
    n = len(total_words)
    for i in range(n):
        for j in range(i+1, n):
            u, v = total_words[i], total_words[j]
            if is_can_change(u, v):
                maps[u].append(v)
                maps[v].append(u)
    
    queue = deque([(begin, 0)])
    
    while queue:
        cur, cnt = queue.popleft()
        if cur == target:
            return cnt
        for nxt in maps[cur]:
            queue.append((nxt, cnt+1))
    
    return answer