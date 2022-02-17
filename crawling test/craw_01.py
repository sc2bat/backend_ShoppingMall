import requests
from pandas import DataFrame
from bs4 import BeautifulSoup
import re
from datetime import datetime
import os
import lxml.html

news_url = 'http://www.yes24.com/24/Category/Display/001001009'

req = requests.get(news_url)
print(req)
soup = BeautifulSoup(req.text, 'html.parser')
root = lxml.html.fromstring(req.text)
titles = root.cssselect('div.goods_name')

titleList = []
for title in titles:
    titleList.append(title.text_content().strip())
print(titleList)

# print(req.text)