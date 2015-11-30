# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        
        left_height = self.maxDepth(root.left)
        right_height = self.maxDepth(root.right)
        
        return left_height+1 if left_height > right_height else right_height+1

# 36/36 test cases passed
# Runtime: 60 ms