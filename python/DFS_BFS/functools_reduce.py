from functools import reduce

# 기본활용
result = reduce(lambda x, y: x + y, [1, 2, 3, 4, 5], 0)
print(result)

# reduce()로 최대값구하기
func = lambda a, b: a if a > b else b
result = reduce(func, [1, 100, 2, 55])
print(result)

# age값 모두 더하기
users = [{'mail': 'gregorythomas@gmail.com', 'name': 'Brett Holland', 'sex': 'M', 'age': 73},
         {'mail': 'hintoncynthia@hotmail.com', 'name': 'Madison Martinez', 'sex': 'F', 'age': 29},
         {'mail': 'wwagner@gmail.com', 'name': 'Michael Jenkins', 'sex': 'M', 'age': 51},
         {'mail': 'daniel79@gmail.com', 'name': 'Karen Rodriguez', 'sex': 'F', 'age': 32},
         {'mail': 'ujackson@gmail.com', 'name': 'Amber Rhodes', 'sex': 'F', 'age': 42}]

print(reduce(lambda acc, cur: acc + cur["age"], users, 0))