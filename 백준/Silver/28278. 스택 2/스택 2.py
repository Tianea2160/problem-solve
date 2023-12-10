import sys

t = int(sys.stdin.readline())
stack = []

for _ in range(t):
    args = list(map(int, sys.stdin.readline().split(" ")))
    cmd = args[0]

    if cmd == 1:
        stack.append(int(args[1]))
    elif cmd == 2:
        print(-1 if not stack else stack.pop())
    elif cmd == 3:
        print(len(stack))
    elif cmd == 4:
        print(1 if not stack else 0)
    elif cmd == 5:
        print(-1 if not stack else stack[-1])
