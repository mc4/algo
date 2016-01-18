class Solution(object):
    def preorderTraversal(self, root):
        ls = []
        
        def recurse(node):
            if node == None:
                return
            
            ls.append(node.val)
            recurse(node.left)
            recurse(node.right)
            
        recurse(root)
        return ls