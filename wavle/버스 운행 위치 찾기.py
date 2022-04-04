
json = [
  {
    "number": "1-1",
    "timetable": {
      "weekday": [
        { "name": "정류장 A", "arrive": "09:00" },
        { "name": "정류장 b", "arrive": "09:20" },
        { "name": "정류장 D", "arrive": "09:45" },
        { "name": "정류장 e", "arrive": "10:00" },
        { "name": "정류장 F", "arrive": "10:20" },
        { "name": "정류장 a", "arrive": "10:50" }
      ],
      "weekend": []
    }
  },
  {
    "number": "50",
    "timetable": {
      "weekday": [
        { "name": "정류장 a", "arrive": "09:10" },
        { "name": "정류장 B", "arrive": "09:35" },
        { "name": "정류장 E", "arrive": "09:50" },
        { "name": "정류장 f", "arrive": "10:20" },
        { "name": "정류장 G", "arrive": "10:30" }
      ],
      "weekend": []
    }
  }
]

def currentTime(): # 현재시간과 요일을 확인하는 함수
  from _datetime import datetime
  now = datetime.now()
  nowTime = now.strftime('%H%M') # 현재시간
  nowWeek = now.weekday()
  if nowWeek < 5: # 0, 1, 2, 3, 4 는 평일 // 5, 6은 주말
    nowWeek = 'weekday'
  else:
    nowWeek = 'weekend'
  return nowTime, nowWeek # 현재시간과 요일을 리턴

# 버스 운행표 확인
def solution(bus_list, currentTime):
  print('버스 운행표 시작!')
  str_list = [] # 다수의 버스 상태를 담는 리스트
  nowTime = currentTime[0] # 현재시간을 담는 변수
  nowWeek = currentTime[1] # 현재요일이 weekday인지 weekend인지를 담는 변수

  for bus_name in bus_list:
    print('bus_name : ', bus_name)
    exist = 0  # 버스 존재 유무 확인 변수
    appand = 0  # 버스가 운행 유무 확인 변수

    for json_bus in json: # 운행표의 리스트 탐색 시작!
      
      if bus_name == json_bus['number']: # 입력 버스번호와 운행표의 버스번호가 같다면
        
        for table in json_bus['timetable'][nowWeek]: # json의 timetable에 평일/주말을 구분지어 탐색
          print(table)
          if int(nowTime) < int(table['arrive'].replace(":", "")): # json의 도착시간을 정수형데이터로 변환
                                                                   # 현재시간이 운행표의 도착시간 안에 들어있다면
            str_list.append((bus_name + '번 버스는 ' + table['name'] + '를 향해 운행하고 있습니다.')) # 버스 운행 상태 리스트에 추가
            appand = 1 # 운행중
            exist = 1 # 버스 존재함
            break
        if appand != 1: # 버스가 현재 운행중이 아니라면
          str_list.append((bus_name + '번 버스는 ' + '버스는 운행이 종료되었습니다.')) # 버스 종료 상태 리스트에 추가
          appand = 1 # 운행 종료
          exist = 1 # 버스 존재함
          break
                
    if exist == 0: # 운행표에 입력한 버스가 존재하지 않는다면
      str_list.append((bus_name + '번 버스는 ' + '버스는 존재하지 않습니다.')) # 버스 존재 상태 리스트에 추가
  print('버스 운행표 끝!')
  return str_list

bus_list = list(map(str, input().split(' '))) # 다수의 버스 번호는 띄어쓰기로 입력받음
print(bus_list)

# 현재시간
current_time = currentTime()
# 입력 시간
current_time2 = ['1010', 'weekday']

# 버스운행표 확인 (입력 버스번호, 현재시간과 요일)
print(solution(bus_list, current_time2))