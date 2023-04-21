from collections import deque

def convert(time):
    h, m = map(int, time.split(":"))
    return h*60 + m

def solution(plans):
    answer = []
    stack = []
    data = {}
    
    for subject, time, duration in plans:
        t = convert(time)
        data[t] = [subject, t, int(duration)]
        
    for i in range(0, 1440):
        if stack:
            task = stack.pop()
            task[2] -= 1
            if task[2] == 0:
                answer.append(task[0])
            else:
                stack.append(task)
        if data.get(i):
            stack.append(data[i])
    
    while stack:
        task = stack.pop()
        answer.append(task[0])
    
    return answer