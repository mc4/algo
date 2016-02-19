# failed test case 
    # Input: [1,null,2,null,3]
    # Output: true
    # Expected: false

########### I'm 99.99% sure this is correct

class Solution(object):
    def isBalanced(self, root):
        return self.maxDepth(root) - self.minDepth(root) <= 1
        
    def minDepth(self, root):
        
        if root == None:
            return 0
            
        if root.left == None or root.right == None:
            return 1 + max(self.minDepth(root.left), self.minDepth(root.right))
            
        return 1 + min(self.minDepth(root.left), self.minDepth(root.right))
        
    def maxDepth(self, root):
        if root is None:
            return 0
        
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

