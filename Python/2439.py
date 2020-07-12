N = int(input())
for i in range(1, N+1) :
    p = ""
    for j in range(0, N-i) :
        p += " "
    for k in range(0, i) : 
        p += "*"
    print(p)