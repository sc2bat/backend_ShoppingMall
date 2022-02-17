import requests
from pandas import DataFrame
from bs4 import BeautifulSoup
import re
from datetime import datetime
import os
import lxml.html
import numpy

url = 'http://www.yes24.com/24/Category/Display/001001046011'

req = requests.get(url)
print(req)

root = lxml.html.fromstring(req.content)
# box = root.csselect('div.cCont_goodsSet')
bnames = root.cssselect('div.goods_name >a:nth-child(2n)')

bnameList = []

for bname in bnames:
    bnameList.append(bname.text_content().strip())
# print(bnameList)

writers = root.cssselect('span.goods_auth >a:nth-child(1)')

writerList = []

for writer in writers:
    writerList.append(writer.text_content().strip())

# print(writerList)


publishers = root.cssselect('div.goods_pubGrp >span.goods_pub')

publisherList = []

for publisher in publishers:
    publisherList.append(publisher.text_content().strip())

print(publisherList)


byears = root.cssselect('span.goods_date')

byearList = []

for byear in byears:
    byearList.append(byear.text_content().strip())

# print(byearList)


prices = root.cssselect('div.goods_price >em.yes_b:nth-child(1)')

priceList = []

for price in prices:
    priceList.append(price.text_content().strip())

# print(priceList)

print(len(bnameList), len(writerList), len(publisherList), len(byearList), len(priceList), len(byearList))

# for i in bnameList:
#     print(i,",", i, i)
