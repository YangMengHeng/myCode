# this is gerald code file in python.
# -*- coding: utf-8 -*-

size = 1024

try:
#    readFile = open('g:/myCode/VSCode/python/hello.py', 'r', encoding='utf8')
#    print(readFile.read(size))
    writeFile = open('g:/myCode/VSCode/python/test.txt', 'w')
    writeFile.write('Hello python!')
finally:
#    readFile.close()
    writeFile.close()

with open('g:/myCode/VSCode/python/test.txt', 'r', encoding='utf8') as readFile:
    print(readFile.read())