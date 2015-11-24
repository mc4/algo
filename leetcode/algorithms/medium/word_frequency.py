from collections import defaultdict

d = defaultdict(int)
with open('words.txt', 'r') as lines:
	for line in lines:
		line = line.strip().split()
		for word in line:
			d[word] += 1

for k, v in sorted(d.items(), reverse=True):
	print(k, v)