# 클래스
# 하나의 함수를 별개의 객체로 사용하여 여러개를 사용할 수 있음
# 객체를 이용한 코드는 메서드와 인스턴스 변수가 객체를 이용하지 않고 만든 프로그램보다 안전하게 있다고 보관되어 있기 때문에
# 다른 코드들의 영향을 받아서 훼손, 변형될 가능성이 현저히 낮음

# 클래스 생성
class Service:
    secret = "영구는 배꼽이 두 개다"
    def sum(self, a, b):
        result = a + b
        print("%s + %s = %s입니다." %(a, b, result))

a = Service() # 객체 생성
print(a.secret)
a.sum(1,1)

# self는 왜 필요할까?
# self라는 변수를 클래스 함수의 첫 번째 인수로 받아야 한다는 것은 파이썬만의 특징임
# 왜 ‘self’가 필요했는지는 파이썬 언어가 개발된 원리를 알아야만 알 수 있음
# 즉, 클래스 내 함수의 첫 번째 인수는 무조건 self로 사용해야 인스턴스 함수로 사용할 수 있다고만 알아둠

# 클래스 구조 만들기
class FourCal:
    def setdata(self, first, second):
        self.first = first
        self.second = second
    def sum(self):
        result = self.first + self.second
        return result
    def mul(self):
        result = self.first * self.second
        return result
    def sub(self):
        result = self.first - self.second
        return result
    def div(self):
        result = self.first / self.second
        return result

a = FourCal()
b = FourCal()
a.setdata(4,2)
b.setdata(3,7)

print(a.sum())
print(a.mul())
print(a.sub())
print(a.div())

print(b.sum())
print(b.mul())
print(b.sub())
print(b.div())

# 입력 받은 장소로 박응용이 여행을 간다고 출력해 주는 travel 메소드를 HousePark 클래스에 구현
class HousePark:
    lastname ="박"
    def setname(self, name):
        self.fullname = self.lastname + name
    def travel(self, where):
        print("%s, %s여행을 가다." %(self.fullname, where))

pey = HousePark()
pey.setname("응용")
pey.travel("부산")

# 클래스 초기값 설정하기
# setname 함수가 실행되지 않으면 오류가 발생함
# 이런 오류가 발생하는 것을 방지하기 위해 pey라는 객체를 만드는 순간 setname 메소드가 동작하게 한다면 편리
class HousePark2:
    lastname = "박"
    def __init__(self, name):
        self.fullname = self.lastname + name
    def travel(self, where):
        print("%s, %s여행을 가다." % (self.fullname, where))

# pey = HousePark2() 입력값이 2개여야하는데 self하나만 입력받았기 때문에 오류
pey = HousePark2("응용")
# __init__ 메소드를 이용하면 인스턴스를 만드는 동시에 초기값을 줄일 수 있기 때문에 편리함
pey.travel("태국")

# 클래스의 상속
# class 상속 받을 클래스명(상속할 클래스명)
class HouseKim(HousePark2):
    lastname = "김"

juliet = HouseKim("줄리엣")
juliet.travel("독도")

# 매소드 오버라이딩(Overriding)
class HouseKim(HousePark2):
    lastname = "김"
    def travel(self, where, day):
        print("%s, %s여행 %d일 가네." %(self.fullname, where, day))

juliet = HouseKim("줄리엣")
juliet.travel("독도", 3)

# 연산자 오버로딩(Overloading)
class HousePark:
    lastname = "박"
    def __init__(self, name):
        self.fullname = self.lastname + name
    def travel(self, where):
        print("%s, %^s여행을 가다." % (self.fullname, where))
    def love(self, other):
        print("%s, %s 사랑에빠졌네" % (self.fullname, other.fullname))
    def __add__(self, other):
        print("%s, %s 결혼했네" % (self.fullname, other.fullname))

class HouseKim(HousePark):
    lastname = "김"
    def travel(self, where, day):
        print("%s, %s여행 %d일 가네." % (self.fullname, where, day))
pey = HousePark("응용")
juliet = HouseKim("줄리엣")
pey.love(juliet)
pey + juliet


class HousePark:
    lastname = "박"
    def __init__(self, name):
        self.fullname = self.lastname + name
    def travel(self, where):
        print("%s, %s여행을 가다." % (self.fullname, where))
    def love(self, other):
        print("%s, %s 사랑에 빠졌네" % (self.fullname, other.fullname))
    def fight(self, other):
        print("%s, %s 싸우네" % (self.fullname, other.fullname))
    def __add__(self, other):
        print("%s, %s 결혼했네" % (self.fullname, other.fullname))

    def __sub__(self, other):
        print("%s, %s 이혼했네" % (self.fullname, other.fullname))


class HouseKim(HousePark):
    lastname = "김"

    def travel(self, where, day):
        print("%s, %s여행 %d일 가네." % (self.fullname, where, day))


pey = HousePark("응용")
juliet = HouseKim("줄리엣")
pey.travel("부산")
juliet.travel("부산", 3)
pey.love(juliet)
pey + juliet
pey.fight(juliet)
pey - juliet
