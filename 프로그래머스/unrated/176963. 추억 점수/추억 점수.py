from collections import defaultdict

# 시간 복잡도는 O(n), n == 사진의 개수
def solution(names, yearning, photoes):
    answer = []
    maps = defaultdict(int)
    for name, score in zip(names,yearning):
        maps[name] = score
    for photo in photoes:
        answer.append(sum([maps[person] for person in photo]))
    return answer