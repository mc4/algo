import sys
from string import ascii_lowercase as alphabet

def difference(d):
	return set(alphabet) - set(d)

codel = 'rbc vjnmkf kd yxyqci na rbc zjkfoscdd ew rbc ujllmcp\
tc rbkso rbyr ejp mysljylc kd kxveddknmc re jsicpdrysi\
de kr kd eoya kw aej icfkici re zjkr'

english = 'the public is amazed by the quickness of the juggler\
we think that our language is impossible to understand\
so it is okay if you decided to quit'

zipped = dict(zip(codel,english))
zipped['n'], zipped['u'], zipped['g'] = 'b', 'j', 'v'

for k, v in zip(difference(zipped.keys()), difference(zipped.values())):
	zipped[k] = v

def translate(text):
    return ''.join(map(lambda f: zipped[f], text))

with open(sys.argv[1], 'r') as test_cases:
	for test in test_cases:
		print translate(test.strip())