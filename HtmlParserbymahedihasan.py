# -*- coding: utf-8 -*-
"""
Created on Mon Feb 29 18:18:44 2016

@author: Mahedi Hasan
"""

import lxml.html as html


class parsingLink:
    def __init__(self,content):
        if content == "":
            content = '<div></div>'
        self.content = html.fromstring(content)

    def get_links(self):
        links = self.content.xpath('//a/@href')
        return links