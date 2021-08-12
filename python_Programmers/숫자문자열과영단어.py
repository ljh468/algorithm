def solution(s):
    list = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    for key, value in enumerate (list):
        if value in s:
            s = s.replace(value, str(key))
    return int(s)

print(solution("one4seveneight"))