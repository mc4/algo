class Solution(object):
    def minDepth(self, root):

        if root == None:
            return 0
            
        if root.left == None or root.right == None:
            return 1 + max(self.minDepth(root.left), self.minDepth(root.right))
            
        return 1 + min(self.minDepth(root.left), self.minDepth(root.right))