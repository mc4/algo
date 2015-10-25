import sys

f = open(sys.argv[1], 'rU')
for line in f:

	if not line.isdigit():
		print

	age = int(line.strip())

	if age < 0 or age > 100:
		print 'This program is for humans'
		continue
	if age < 3:
		print 'Still in Mama\'s arms'
	elif age < 5:
		print 'Preschool Maniac'
	elif age < 12:
		print 'Elementary school'
	elif age < 15:
		print 'Middle School'
	elif age < 19:
		print 'High school'
	elif age < 23:
		print 'College'
	elif age < 66:
		print 'Working for the man'
	else:
		print 'The Golden Years'

f.close()
