import sys 

with open(sys.argv[1], 'r') as testcases:
	for test in testcases:

		left, target = test.strip().split(';')
		numbers, pairs = map(int, left.split(',')), []

		for i in xrange(len(numbers)):
			for j in xrange(i+1,len(numbers)):
						
				if numbers[i] + numbers[j] == int(target):
					pairs.append(str(numbers[i])+','+str(numbers[j]))

		print ';'.join(pairs) if len(pais) != 0 else 'NULL'