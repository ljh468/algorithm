from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
driver = webdriver.Chrome("chromedriver.exe")
driver.implicitly_wait(3)
# driver = webdriver.Chrome("C:/Users/DATALAB_3/AppData/Local/Programs/Python/Python36/chromedriver.exe")

siteList = [1,19,2,23,20]
areaList = ["기획아이디어", "디자인", "광고/마케팅", "문학/시나리오", "IT/소프트웨어"]
k = 0
for i in siteList:
    driver.implicitly_wait(15) # 15초 대기
    driver.get(f"https://www.wevity.com/?c=find&s=1&gub=1&cidx={i}")
    driver.implicitly_wait(15) # 15초 대기
# driver.get("https://www.thinkcontest.com/Contest/CateField.html?c={zero}".format(zero=i))
# 찾는 사이트 주소
# driver.get("https://www.wevity.com/?c=find&s=1&gub=1&cidx=1") # 기획/아이디어
# driver.get("https://www.wevity.com/?c=find&s=1&gub=1&cidx=19") # 디자인
# driver.get("https://www.wevity.com/?c=find&s=1&gub=1&cidx=2") # 광고/마케팅
# driver.get("https://www.wevity.com/?c=find&s=1&gub=1&cidx=23") # 문학/수기
# driver.get("https://www.wevity.com/?c=find&s=1&gub=1&cidx=20") # IT/소프트웨어

    for j in range(2, 12):
        driver.find_element_by_xpath(f'//*[@id="container"]/div[2]/div[1]/div[2]/div[3]/div/ul/li[{j}]/div[1]/a').click()
                                      
        CONTEST_NAME = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[1]/h6').text # 공모전 이름       
        time.sleep(1)
        CONTEST_IMG = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[2]/div[1]/div[1]/img').get_attribute('src') # 이미지 주소
        CONTEST_HOST = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[2]/div[2]/ul/li[3]').text  # 주최
        CONTEST_AREA = (areaList[k])  # 분야
        CONTEST_DAY = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[2]/div[2]/ul/li[5]').text  # 기간
        CONTEST_PRIZE = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[2]/div[2]/ul/li[6]').text # 총상금
        CONTEST_ADDR = driver.find_element_by_xpath('//*[@id="container"]/div[2]/div[1]/div[2]/div/div[2]/div[2]/ul/li[8]/a').get_attribute('href')  # 홈페이지주소        
        CONTEST_CONTENT = driver.find_element_by_css_selector('#viewContents').get_attribute('innerHTML') # 공모전 내용

        print("CONTEST_NAME : ",CONTEST_NAME)
        print("CONTEST_IMG : ", CONTEST_IMG)
        print("CONTEST_HOST : ",CONTEST_HOST)
        print("CONTEST_AREA : ",CONTEST_AREA)
        # print("CONTEST_DAY : ",CONTEST_DAY)
        # print("CONTEST_PRIZE : ",CONTEST_PRIZE)
        print("CONTEST_ADDR : ",CONTEST_ADDR)
        print("CONTEST_CONTENT : ",CONTEST_CONTENT)
        driver.back()
    k = k+1