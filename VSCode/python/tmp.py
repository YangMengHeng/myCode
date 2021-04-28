# this is gerald code file in python.
# -*- coding: utf-8 -*-

import os

print([x for x in os.listdir('./python/') if os.path.isfile(x) and os.path.splitext(x)[1]=='.py'])