# list = ["/a/a_v2.x", "/b/a.x", "/c/t.z" ,"/d/a/t.x", "/e/z/t_v1.z", "/k/k/k/a_v9.x"]


list1 = input().split()

sole = []
for n in list1:
    size = n.rfind("/")+1
    str = n[size : len(n)]

    a = ["_v1", "_v2","_v3","_v4","_v5","_v6","_v7","_v8","_v9"]
    for i in a:
        str = str.replace(i, "")

    sole.append(str)

soleset = set(sole)

for c in soleset:
    count = 0
    for d in sole:
        if c == d:
            count += 1
    if(count >1):
        print(c)
        print(count)