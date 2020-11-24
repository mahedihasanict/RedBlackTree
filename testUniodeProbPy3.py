# -*- coding: utf-8 -*-
"""
Created on Mon Feb 29 17:38:15 2016

@author: Mahedi Hasan
"""

import urllib
from bs4 import BeautifulSoup
args=urllib.urlencode({'keywords':'magic'})
doc=urllib.urlopen('http://www.example.com/submit', args)
soup=BeautifulSoup(doc)
stuff = soup.findAll('section',id='banner')
print (stuff)