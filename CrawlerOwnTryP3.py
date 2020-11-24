# -*- coding: utf-8 -*-
"""
Created on Mon Feb 29 18:17:41 2016

@author: Mahedi Hasan
"""

from queue import Queue
from HtmlParserbymahedihasan import parsingLink
import urllib.request
import urllib.error
import urllib.parse
import time

seedurl = "http://spbu.ru/"
qu=Queue()
qu.put(seedurl)
visited={seedurl:False}
innerlink=0
subdomain=0
outerlink=0
i=0
j=0
        
def crawl():
    while not qu.empty():
        senturl=qu.get()
        if visited[senturl]:
            continue
        visited[senturl]=True
        time.sleep(0)
        try:
            content=urllib.request.urlopen(senturl).read()
            global j
            j+=1
            print (senturl)
            parser = parsingLink(content)
            url_list = parser.get_links()
            for subpage in url_list:
                completeurl = urllib.parse.urljoin(senturl, subpage)
                #completeurl=urllib.parse.urlencode(senturl, subpage)
                #completeurl=completeurl+"/"
                if completeurl.startswith(seedurl):
                    global innerlink
                    innerlink+=1
                elif seedurl in completeurl:
                    global subdomain
                    subdomain+=1
                else:
                    global outerlink
                    outerlink+=1
                if (completeurl not in visited):
                    visited[completeurl]=False
                    qu.put(completeurl)
        except urllib.error.HTTPError as e:
            #if e.code == 404:
            global i
            i+=1
            print (e.msg)
    



 

crawl()


print("Total number of page visited by crawler: ",j)
print("Number of pages not found: ",i)
print("Total number of page found: ",j-i)
print("Total number of Inner link: ",innerlink)
print("Total number of Sub-domain: ",subdomain)
print("Total number of outerlink: ",outerlink)
print("pages visited: ",visited)

