import requests
from pandas import DataFrame
from bs4 import BeautifulSoup
import re
from datetime import datetime
import os
import lxml.html
import numpy

news_url = 'http://www.yes24.com/24/Category/Display/001001046011'

req = requests.get(news_url)
print(req)
soup = BeautifulSoup(req.text, 'html.parser')
root = lxml.html.fromstring(req.text)   


# titles=root.cssselect('span.goods_pub') 
# prices=root.cssselect('div.goods_pirce>em.yes_b')
# authors=root.cssselect('span.goods_auth')

box = root.cssselect('div.goods_name')
bname = root.cssselect('div.goods_name >a:nth-child(1)')
writer = root.cssselect('span.goods_auth')
publisher = root.cssselect('span.goods_pub')
byear = root.cssselect('span.goods_date')
price = root.cssselect('div.goods_price >em.yes_b:nth-child(1)')
content = root.cssselect('div.goods_read')

bnameList = []
writerList = []
publisherList = []
byearList = []
priceList = []
contentList = []


for i in range(len(bname)):
    bnameList.append(bname[i].text_content().strip())
    writerList.append(writer[i].text_content().strip())
    publisherList.append(publisher[i].text_content().strip())
    byearList.append(byear[i].text_content().strip())
    priceList.append(price[i].text_content().strip())
    contentList.append(content[i].text_content().strip())

print(bnameList)
print(writerList)
print(publisherList)
print(byearList)
print(priceList)
print(contentList)

print(numpy.size(bnameList))