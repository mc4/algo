# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        
        # check for reference inequalities and Nones
        if p is q:
            return True
        if p is None: 
            return False
        if q is None: 
            return False
        
        # check for data inequality
        if p.val != q.val:
            return False
            '''
            if p.val is None or q.val is None:
                return False
            if not p.val == q.val:
                return False
            '''
            
        # recursively check branches
        if not self.isSameTree(p.left, q.left):
            return False
            
        if not self.isSameTree(p.right, q.right):
            return False
        
        # we've eliminated all possibilities for non-equality, so trees must be equal    
        return True
        

# 54/54
# 32 ms
# Your runtime beats 99.42% of python submissions.