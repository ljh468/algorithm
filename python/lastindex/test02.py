# list = ["/a/a_v2.x", "/b/a.x", "/c/t.z" ,"/d/a/t.x", "/e/z/t_v1.z", "/k/k/k/a_v9.x"]


list = input().split()
list1 = []
str = []
for i in list:
    if i == "BOOL":
        list1.append(1)
    if i == "SHORT":
        list1.append(2)
    if i == "FLOAT":
        list1.append(4)
    if i == "INT":
        list1.append(8)
    if i == "LONG":
        list1.append(16)

for c in list1:
    count = 0
    count += c
    if count == 8 or count == 16:
        continue
    else:
        i

