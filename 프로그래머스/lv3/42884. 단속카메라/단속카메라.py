def solution(routes):
    answer = 0
    
    s, e = -98765432321, -98765432321
    
    routes.sort(key=lambda x : x[1])
    
    print(routes)
    for start, end in routes:
        # print(e, start)
        if e < start:
            s, e = start, end
            answer+=1

    return answer