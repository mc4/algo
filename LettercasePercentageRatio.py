import sys

def printPercentage(seq):

	lowerCount = 0
	upperCount = 0
	total = 0

	for char in seq:
		if char == '\n':
			continue
		if char.isupper():
			upperCount += 1
		else:
			lowerCount += 1

	total = lowerCount + upperCount

	lowerPercentage = (float(lowerCount)/total) * 100
	upperPercentage = (float(upperCount)/total) * 100

	print 'lowercase: %.2f uppercase: %.2f' % (lowerPercentage, upperPercentage)

def main():
	f = open(sys.argv[1], 'rU')

	for line in f:
		printPercentage(line)

	f.close()

if __name__ == "__main__":
	main()
