n = 20

rank = {
    "A+": 4.5,
    "A0": 4.0,
    "B+": 3.5,
    "B0": 3.0,
    "C+": 2.5,
    "C0": 2.0,
    "D+": 1.5,
    "D0": 1.0,
    "F": 0.0
}
scores = {
    "1.0": 1.0,
    "2.0": 2.0,
    "3.0": 3.0,
    "4.0": 4.0,
}
total_score = 0
sum = 0
for _ in range(n):
    sub, score, grade = input().split()
    if grade == "P":
        continue
    sum += rank[grade]*scores[score]
    total_score += scores[score]
print(sum / total_score)
