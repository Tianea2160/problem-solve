from collections import defaultdict
from itertools import combinations
from bisect import bisect_left

def solution(information, querys):
    answer = []
    
    # 해당 조건에 맞는 지원자가 '몇명'인지 쉽게 할 수 있는 도구 만들기
    
    # 검색할 수 있는 모든 조건의 경우를 돌면서 해당 조건을 key로 사용하고, 해당 조건을 기준으로 몸무게를 넣는다.
    data = defaultdict(list)
    
    for info in information:
        words = info.split()
        condition = words[:-1]
        score = int(words[-1])
        
        for i in range(5):
            case = combinations([0,1,2,3], i)
            for c in case:
                tmp = condition.copy()
                for idx in c: tmp[idx] = "-"
                key = "".join(tmp)
                data[key].append(score)
        
        # for k in data: print(k, data[k])
    for value in data.values():
        value.sort()
        
    for query in querys:
        words = query.replace("and", "").split()
        condition = words[:-1]
        target = int(words[-1])
        key = "".join(condition)
        scores = data[key]
        idx = bisect_left(scores, target)
        answer.append(len(scores) - idx)
    
    return answer