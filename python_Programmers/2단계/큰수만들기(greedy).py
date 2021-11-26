def solution(number, k):
    # 큰수를 모으는 배열 생성
    collected = []

    for (i, num) in enumerate(number):
        while collected and collected[-1] < num and k > 0:
            collected.pop()
            k -= 1

        if k == 0:
            collected += number[i:]
            break

        collected.append(num)

    collected = collected[:-k] if k > 0 else collected
    answer = "".join(collected)
    return answer

# 스택을 이용한 문제
def solution2(number, k):
    # 1. 스택 생성
    st = []

    # 2. 큰 수가 앞자리가 되게끔 스택에 저장합니다.
    for elem in number:
        while st and st[-1] < elem and k > 0:
            st.pop()
            k -= 1
        st.append(elem)
    # 3. k가 남았다면 뒤에서부터 뺍니다.
    while k > 0:
        st.pop()
        k -=1
    answer = "".join(st)
    return answer

def sol(number, k):
    answer = ""
    stack = []
    for num in number:
        while stack and stack[-1] < num and k > 0 :
            stack.pop()
            k = k - 1
        stack.append(num)
    if k > 0:
        stack = stack[:-k]
    return "".join(stack[:])

number = "1231234"
k = 3
# print(solution(number, k))
# print(solution2(number, k))
print(sol(number, k))