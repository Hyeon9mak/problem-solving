T = int(input())

for t in range(1, T+1) :
    A, B = input().split()
    print("Case #", t, ": ", A, " + ", B, " = ", int(A)+int(B), sep="")