import requests
from pandas import DataFrame
from bs4 import BeautifulSoup
import re
from datetime import datetime
import os
import lxml.html
import numpy
import pandas as pd

url = 'http://www.yes24.com/24/Category/Display/001001046011?PageNumber=1'
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


# for i in bnames:
#     bnameList.append(i.text_content().strip())
#     writerList.append(i.text_content().strip())
#     publisherList.append(i.text_content().strip())
#     byearList.append(i.text_content().strip())
#     priceList.append(i.text_content().strip())
#     contentList.append(i.text_content().strip())


# print(len(bnameList), len(writerList), len(publisherList), len(byearList), len(priceList), len(contentList))

df=pd.DataFrame({"bname":bnameList,
                 "writer":writerList,
                "publisher":publisherList,
                "byear":byearList,
                "price":priceList,
                "content":contentList,})
df.to_excel('booklistpage1.xlsx',index=False)