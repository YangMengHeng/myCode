# this is gerald code file in python.
# YangHui triangles algorithm

def triangles():
    L = [1]

    while True:
        yield L[:]
        L.append(0)
        L = [L[i] + L[i - 1] if i > 0 else L[0] for i in range(len(L))]

i = 0
results = []
for t in triangles():
    results.append(t)
    i += 1
    if i == 10:
        break
for t in results:
    print(t)