import sys
from string import ascii_lowercase as lowercase

# -*- coding: utf-8 -*-
def strip_non_ascii(string):
    ''' Returns the string without non ASCII characters'''
    stripped = (c for c in string if 0 < ord(c) < 127)
    return ''.join(stripped)

with open(sys.argv[1], 'r') as testcases:

	for test in testcases:
		words = strip_non_ascii(test.strip().lower())
		res = ''
		for letter in lowercase:
			if letter not in words:
				res += letter

		print res if res else 'NULL'
