import requests
from pandas import DataFrame
from bs4 import BeautifulSoup
import re
from datetime import datetime
import os
import lxml.html

news_url = 'https://ridibooks.com/bestsellers/general'

req = requests.get(news_url)
print(req)
soup = BeautifulSoup(req.text, 'html.parser')
root = lxml.html.fromstring(req.text)   
titles = root.cssselect('span.title_text')
writers = root.cssselect('p.author')

titleList = []
writerList = []
for title in titles:
    titleList.append(title.text_content().strip())
print(titleList)

for writer in writers:
    writerList.append(writer.text_content().strip())
print(writerList)
# print(req.text)