answer = ""
for c in input():
    answer += c.lower() if c.isupper() else c.upper()
print(answer)
