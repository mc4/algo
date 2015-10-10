"""
Email Validation.

Challenge Description:

You are given several strings that may/may not be valid emails. You should
write a regular expression that determines if the email id is a valid email id
or not. You may assume all characters are from the english language.

Input sample:

Your program should accept as its first argument a filename. This file will
contain several text strings, one per line. Ignore all empty lines. E.g.
foo@bar.com
this is not an email id
admin#codeeval.com
good123@bad.com

Output sample:

Print out 'true' (all lowercase) if the string is a valid email. Else print out
'false' (all lowercase). E.g.

true
false
false
true
"""

import sys
import re

def is_email_valid(address):
	#if re.search(r'\w[\w.]*\w@\w[\w.]+', address): return True
	#if re.search(r'[a-z|A-Z|0-9|-|_|+|.?]*@[a-z|A-Z|0-9|-|_|+|.?]+', address): 
	if re.search(r'[\w\.-]+@[\w\.-]+', address):
		return 'true'
	else: 
		return 'false'

with open(sys.argv[1], 'r') as testcases:
	for test in testcases: 
		print is_email_valid(test.strip())