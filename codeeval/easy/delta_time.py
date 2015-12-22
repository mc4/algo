import sys
from datetime import datetime, timedelta

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		s1, s2 = test.strip().split()

		if s1 < s2:
			s1, s2 = s2, s1

		FMT = '%H:%M:%S'
		delta = datetime.strptime(s1, FMT) - datetime.strptime(s2, FMT)

		if str(delta)[1:2] == ':':
			delta = '0'+str(delta)

		print delta
