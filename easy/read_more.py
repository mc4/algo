import sys

def trim(s):
	# we know length is already 55+ '''
	t = s[:39]

	if t[-1] == ' ':
		pass		

	return t.strip() + '... <Read More>'

with open(sys.argv[1], 'r') as tc:
	for t in tc:

		if len(t) <= 55:
			print t.strip()
			continue

		res = ''
		index = 0
		wl = t.strip().split()

		if len(wl[0]) > 40:
			print wl[0][:40] + '... <Read More>'
			continue

		while True:
			if len(res)+len(wl[index]) >= 40:
				break
			
			res += wl[index] + ' '
			index += 1
		
		print res.strip() + '... <Read More>'

