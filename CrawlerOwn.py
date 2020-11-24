i=0
j=0
import BeautifulSoup
import time 
import urllib2
import urlparse
#import time
import threading
import Queue

import pprint
 

seedurl = "http://spbu.ru/"
urlfrontier = {seedurl:False}



def Crawl():
    for url, crawled in iter(urlfrontier.iteritems()):
        if not crawled:
            #print "Also {}".format(url)
            return url
    return False


def open_parse_Url_get_links(url):

    try:   
        #i=0
        openedpage = urllib2.urlopen(url) #opens page by using url
        global j
        j+=1        
        parsedpage = BeautifulSoup.BeautifulSoup(openedpage)#parses page
        for subpage in parsedpage.findAll('a'):# findes all html tags with a which is actually subpages
            completeurl = urlparse.urljoin(url, subpage.get('href'))# join the prvious url and next subdomain
            if completeurl.startswith(seedurl):
                if (completeurl not in urlfrontier):#adds a newly formed url into url frontier to wait to be crawled in future
                    urlfrontier[completeurl] = False
        urlfrontier[url] = True   
    except urllib2.HTTPError, e:
        if e.code == 404:
            global i
            i+=1
        print e.msg
        #print i
        #print e.headers
        urlfrontier[url] = True 
 

k=1 
while k==1:
    Crawled = Crawl()
    if Crawled is False:
        break
    open_parse_Url_get_links(Crawled)
    time.sleep(2)
print j
print i
print j-i
pprint.pprint(urlfrontier)