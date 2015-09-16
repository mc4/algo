import sys

with open(sys.argv[1], 'r') as testcases:
	for test in testcases:
		content = test.strip().split(',')

		nums = [x for x in content if x.isdigit()]
		stuff = [x for x in content if not x.isdigit()]

		if stuff and nums:
			print ','.join(stuff) + '|' + ','.join(nums)
		elif not nums:
			print ','.join(stuff)
		else:
			print ','.join(nums)
