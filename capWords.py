import sys

def capitalizeFirstLetter(sentences):
	words = []
	for w in sentences:
		newWord = w[0].upper() + w[1:]
		words.append(newWord)
	return words


def printWords(words):
	for w in words:
		print w,
	print
	

def main():
	f = open(sys.argv[1], 'rU')
	for line in f:
		sentences = []
		sentences = line.split()
		uwords = capitalizeFirstLetter(sentences)
		printWords(uwords)
	f.close();


if __name__ == "__main__":
    main()
