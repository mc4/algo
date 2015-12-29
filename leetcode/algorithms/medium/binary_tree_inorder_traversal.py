class Solution(object):
    def inorderTraversal(self, root):

        ls = []
        def recurse(node):
            if node == None:
                return None
            
            recurse(node.left)
            ls.append(node.val)
            recurse(node.right)
            
        recurse(root)    
        return ls