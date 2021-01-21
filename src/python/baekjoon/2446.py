N = int(input())

for i in range(N, 0, -1) :
    star = ""
    for j in range(0, N-i) :
        star += " "
    for k in range(0, 2*i-1) :
        star += "*"
    print(star)

for i in range(2, N+1) :
    star = ""
    for j in range(0, N-i) :
        star += " "
    for k in range(0, 2*i-1) :
        star += "*"
    print(star)