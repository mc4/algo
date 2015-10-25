#Python 3.4
import sys

def main():

	f = open(sys.argv[1], 'rU')
	for line in f:
		#line = '1,2,3,4;3,4,5,6'

    lists = line.split(';')

    a, b = set(lists[0].split(',')), set(lists[1].split(','))

    print (a & b)

if __name__ == "__main__":
	main()
