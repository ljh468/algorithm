def solution(phone_book):
    phone_book_strip = set()
    for phone_number in phone_book:
        phone_number = phone_number.replace(" ", "")
        phone_book_strip.add(phone_number)

    phone_book_list = list(phone_book_strip)
    phone_book_list.sort()
    print(phone_book_list)
    for i in range(len(phone_book_list) - 1):
        for j in range(len(phone_book_list)):
            if i != j and phone_book_list[i] == phone_book_list[j][0:len(phone_book_list[i])]:
                print(phone_book_list[i])
                print(phone_book_list[j][0:len(phone_book_list[i])])
                return False
    return True

# print(solution(["12","123","1235","11","1111"]))

# 해시 풀이
def solution1(phone_book):
    answer = True
    hash_map = {}
    for phone_number in phone_book:
        hash_map[phone_number] = 1
    for phone_number in phone_book:
        temp = ""
        for number in phone_number:
            temp += number
            print(temp)
            if temp in hash_map and temp != phone_number:
                answer = False
    return answer
print(solution1(["12","123","1235","567","88"]))

# 모범 풀이
def solution2(phone_book):
    phone_book.sort()

    for i in range(len(phone_book) - 1):
        if phone_book[i] in phone_book[i + 1]:
            return False

    return True
# 모범 풀이2
def solution3(phone_book):
    phone_book.sort()
    print(phone_book)
    for p1, p2 in zip(phone_book, phone_book[1:]):
        print('p1 : ', p1, 'p2 : ', p2)
        if p2.startswith(p1):
            return False
    return True
# print(solution3(["12","123","1235","567","88"]))