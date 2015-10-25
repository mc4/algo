import sys

def main():

	f = open(sys.argv[1], 'rU')
	for line in f:
		line.strip()
		list = line.split()
		for w in reversed(list): #doesn't create a copy, creates it on the fly
			print w,
		print

if __name__ == "__main__":
	main()
