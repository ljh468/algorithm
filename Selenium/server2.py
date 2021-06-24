#-*- coding:utf-8 -*-
from flask import Flask
from seleniumtest import seleniumCrawling
import json
application = Flask(__name__)


@application.route("/")
def hello():
    return "<h1> 파이썬!! </h1>"

@application.route('/crawlingAPI', methods=['GET','POST'])
def crawling():

   print("crawling start!!")
   # 입력받을 문장
   rList = []
   rList = seleniumCrawling()
   print("rList : ", rList)
   print("5")
   div = json.dumps(rList, ensure_ascii=False)
   print("5")
   print("crawling end!!")
   return rList

if __name__ == "__main__":
    application.run(host="0.0.0.0", port=5000)
    # application.run(host="127.0.0.1")