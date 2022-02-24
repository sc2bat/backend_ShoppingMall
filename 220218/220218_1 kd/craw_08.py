import requests
from pandas import DataFrame
from bs4 import BeautifulSoup
import re
from datetime import datetime
import os
import lxml.html
import numpy
import pandas as pd

url = 'http://www.yes24.com/24/Category/Display/001001046011?PageNumber=9'
req = requests.get(url)
print(req)
root = lxml.html.fromstring(req.content)


bnames = root.cssselect('div.goods_name >a:nth-child(2n)')
writers = root.cssselect('span.goods_auth >a:nth-child(1)')
publishers = root.cssselect('div.goods_pubGrp >span.goods_pub')
byears = root.cssselect('span.goods_date')
prices = root.cssselect('div.goods_price >em.yes_b:nth-child(1)')
contents = root.cssselect('div.goods_read')

bnameList = []
writerList = []
publisherList = []
byearList = []
priceList = []
contentList = []

for bname in bnames:
    bnameList.append(bname.text_content().strip())
for writer in writers:
    writerList.append(writer.text_content().strip())
for publisher in publishers:
    publisherList.append(publisher.text_content().strip())
for byear in byears:
    byearList.append(byear.text_content().strip())
for price in prices:
    priceList.append(price.text_content().strip())
for content in contents:
    contentList.append(content.text_content().strip())


img1 = ['01.png', '02.png', '03.png', '04.png', '05.png', '06.png', '07.png', '08.png', '09.png', '10.png', '11.png', '12.png', '13.png', '14.png', '15.png', '16.png', '17.png', '18.png', '19.png', '20.png']
img2 = ['21.png', '22.png', '23.png', '24.png', '25.png', '26.png', '27.png', '28.png', '29.png', '30.png', '31.png', '32.png', '33.png', '34.png', '35.png', '36.png', '37.png', '38.png', '39.png', '40.png']
img3 = ['41.png', '42.png', '43.png', '44.png', '45.png', '46.png', '47.png', '48.png', '49.png', '50.png', '51.png', '52.png', '53.png', '54.png', '55.png', '56.png', '57.png', '58.png', '59.png', '60.png']
    
f = open('C:/Users/PC/Desktop/qwer/220217/crawling test/sqltxt/fiction6.txt', 'w', encoding='utf8')
i = 1
while i < 20:
    priceList[i] = re.sub(",", "", priceList[i])
    data = "INSERT INTO bookproduct(bseq, bname, writer, publisher, byear, price, content, kind, genre, image, bestyn) " + "\n VALUES(bookproduct_seq.nextVal, \'" + bnameList[i] + "\', \'" + writerList[i] + "\', \'" + publisherList[i] + "\', \'" + byearList[i] + "\', \'" + priceList[i] + "\', \n\'" + contentList[i] + "\', \n\'l\', \'fiction\', \'" + img3[i] + "\', \'y\');\n"
    f.write(data)
    i += 1

f.close()