class MinStack(object):
    def __init__(self):
        self.stack = []
        self.minimum = []

    def push(self, x):
        self.stack.append(x)
        if not self.minimum or self.minimum[-1] >= x:
            self.minimum.append(x)

    def pop(self):
        p = self.stack.pop()
        if self.minimum and p == self.minimum[-1]:
            self.minimum.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.minimum[-1]