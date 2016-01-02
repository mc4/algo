class Solution(object):
    def isValidBST(self, root):
        from sys import maxint
        return self.helper(root, -maxint-1, maxint)
    
    def helper(self, root, low, high):
        if root == None:
            return True
            
        if root.val <= low or root.val >= high:
            return False
            
        return self.helper(root.left, low, root.val) and self.helper(root.right, root.val, high)
            