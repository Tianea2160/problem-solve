from collections import deque

def solution(book_time):
    answer = 0
    if not book_time: return 0
    def time(t):
        h, m = t.split(":")
        return int(h)*60 + int(m)
    tmp = [(time(start), time(end)) for start, end in book_time]
    tmp = sorted(tmp, key=lambda x: x[0])
    queue, cnt  = deque(), 0
    for t in tmp:
        start, end = t
        while queue and queue[0] <= start: 
            queue.popleft()
            cnt-=1
        cnt +=1
        answer = max(len(queue), answer)
        queue.append(end+10)
        queue = deque(sorted(queue))
    
    return answer+1