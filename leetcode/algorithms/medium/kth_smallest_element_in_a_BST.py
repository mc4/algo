class Solution(object):
    def kthSmallest(self, root, k):
        
        ls = []
        
        # postorder traversal
        def recurse(node):
            if node == None:
                return None
            
            recurse(node.left)
            recurse(node.right)
            ls.append(node.val)
            
        recurse(root)    
        #return sorted(ls)[k-1:k][0] # only faster than 33%
        
        # faster than ~69%
        ls.sort()
        ls = ls[k-1:k] # get k smallest element
        return ls[0] 
        