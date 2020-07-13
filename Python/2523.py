N = int(input())

for i in range(1, N+1) :
    star = ""
    for j in range(0, i) :
        star += "*"
    print(star)

for i in range(N-1, 0, -1) :
    star = ""
    for j in range(i, 0, -1) :
        star += "*"
    print(star)