import sys

def clean(text, keys):
	res = ''

	for index in map(int, keys.strip().split()):
		if index:
			res += text[index-1]
	return res

with open(sys.argv[1], 'r') as tc:
	for t in tc:
		text, keys = t.strip().split('| ')
		print clean(text, keys)