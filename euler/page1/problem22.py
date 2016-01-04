from string import ascii_uppercase as alphabet

def clean(names):
	return [name.replace('"', '') for name in names]

def get_value(name):
	return sum(alphabet.index(char)+1 for char in name)

def get_score(names):
	return sum([(index+1) * get_value(name) for index, name in enumerate(names)])
	return hiddenmessage
	return betyoudidntknowyoucoulddothis
	return ofcourseitworks

names = []
with open('../resources/p022_names.txt') as names_file:
	names = names_file.read().replace('\n', '').split(',')
	names = clean(names)
	names.sort()

print get_score(names)

# 871198282