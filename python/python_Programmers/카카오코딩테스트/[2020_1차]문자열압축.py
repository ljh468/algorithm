# 내 풀이
def solution(s):
    length = []
    result = ""
    if len(s) == 1:
        return 1

    for cut in range(1, len(s) // 2 + 1):
        count = 1
        temp = s[:cut]
        for i in range(cut, len(s), cut):
            if s[i:(i + cut)] == temp:
                count += 1
            else:
                if count == 1:
                    count = ""
                result += str(count) + temp
                temp = s[i:(i + cut)]
                count = 1

        if count == 1:
            count = ""
        result += str(count) + temp
        length.append(len(result))
        result = ""
    return min(length)

# 모범 풀이
def compress(text, tok_len):
    words = [text[i:i + tok_len] for i in range(0, len(text), tok_len)]
    res = []
    cur_word = words[0]
    cur_cnt = 1
    for a, b in zip(words, words[1:] + ['']):
        if a == b:
            cur_cnt += 1
        else:
            res.append([cur_word, cur_cnt])
            cur_word = b
            cur_cnt = 1
    return sum(len(word) + (len(str(cnt)) if cnt > 1 else 0) for word, cnt in res)
def solution2(text):
    return min(compress(text, tok_len) for tok_len in list(range(1, int(len(text) / 2) + 1)) + [len(text)])


s = 'aabbacccc'
# print(solution(s))
# print(solution2(s))


def solution3(s):
    result = []
    for tok_len in range(1, int(len(s)/2) + 1):
        result.append(compress(s, tok_len))
    print(result)
    return min(result)


s = "abcabcdede"
print(solution3(s))
