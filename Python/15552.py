#input() -> sys.stdin.readline()
#input() 은 sys.stdin.readline()에 비해 한참 느리다. 때문에 시간 제한이 존재하는 코테에서는 거의 무조건적으로 사용해주면 좋다.
import sys
T = int(sys.stdin.readline())

for i in range(0, T) :
    A, B = sys.stdin.readline().split()
    print(int(A) + int(B))