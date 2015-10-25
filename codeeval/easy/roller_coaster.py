import sys

def roll_the_coast(line):
	roll = True
	coast = ''

	for i in xrange(len(line)):
		if line[i].isalpha():
			if roll:
				coast += line[i].upper()
				roll = False
			else:
				coast += line[i].lower()
				roll = True
		else:
			coast += line[i]

	return coast

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print roll_the_coast(test),
