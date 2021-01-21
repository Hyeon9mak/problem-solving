N = int(input())
R = []

for i in range(0, N*2) :
    if i%2 == 0 : R.append("*")
    else        : R.append(" ")

for l in range(0, N) :
    P1 = P2 = ""
    for i in range(0, N) :
        P1 += R[i]
    print(P1)
    for i in range(N*2-1, N-1, -1) :
        P2 += R[i]
    print(P2)