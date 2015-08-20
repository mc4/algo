import sys
from math import pow

def get_binary_factor(x):
	if x==0: 
		return 0
	if x==1: 
		return 1
	factor=0
	num=0
	while num < x:
		num += pow(2,factor)
		factor+=1
	return factor-1

def dec_to_bin(x):
	''' converts the int x in decimal form to the binary number in a string '''
	str, bin = '', 0
	factor = get_binary_factor(x)

	while factor >= 0:
		bin = pow(2,factor) + bin
		if bin <= x:
			str += '1'
		elif bin > x:
			bin = bin - pow(2,factor)
			str += '0'
		factor -= 1

	return str

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		binary_str=dec_to_bin(int(test.strip()))
		print binary_str.count('1')
