#!/usr/bin/env python3
# -*- coding: utf-8 -*-

'Just a test for python module'

_author_ = '旗木白哉'

import sys

def test():
    args = sys.argv
    if len(args) == 1:
        print("Hello World!")
    elif len(args) == 2:
        print("Hello %s!" %args[1])
    else:
        print("Too many arguments!")

if __name__ == "__main__":
    test()