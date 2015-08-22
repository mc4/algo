import sys

def roll_the_coast(line):
	roll = True
	coast = ''

	for i in xrange(len(line)):
		if roll:
			coast += line[i].upper()
			roll = False
		else:
			coast += line[i].lower()
			roll = True

	return coast

#print roll_the_coast("Hello world HI")

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print roll_the_coast(test)
