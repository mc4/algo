class Solution(object):
    def invertTree(self, root):
        if not root:
            return None
            
        tmp = root.right
        root.right = root.left
        root.left = tmp
        
        self.invertTree(root.left)
        self.invertTree(root.right)
        
        return root
        