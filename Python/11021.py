T = int(input())

for t in range(1, T+1) :
    A, B = input().split()
    print("Case #", t, ": ", int(A)+int(B), sep="")