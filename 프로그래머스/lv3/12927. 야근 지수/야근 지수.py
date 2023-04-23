from heapq import heappush, heappop, heapify

def solution(n, works):
    heapify(heap := [-w for w in works])
    while n:
        m = -heappop(heap)
        if m == 0:
            return 0
        else:
            heappush(heap, -(m-1))
            n-=1
    return sum([(-m)**2 for m in heap])