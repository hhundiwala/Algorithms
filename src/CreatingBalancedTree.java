public class CreatingBalancedTree {
    TreeNode root;
    int[] array;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.array = nums;
        if(nums.length == 0)
            return root;

        int right = nums.length - 1;
        this.OptimisedAdd(0,right);

        return root;
    }

    public void OptimisedAdd(int i,int j){
        if(i<j){
            int mid = i+(j-i)/2;
            this.insertElement(this.array[mid]);
            this.OptimisedAdd(i,mid-1);
            this.OptimisedAdd(mid+1,j);
        }
    }

    public void insertElement(int x){
        TreeNode node = new TreeNode(x);

        if(this.root == null)
            this.root = node;
        else{
            TreeNode prev,curr;
            prev = this.root;
            curr = this.root;

            //finding the position to insert
            while(curr!=null){
                prev = curr;
                if(curr.val > x )
                    curr = curr.left;
                else if(curr.val < x )
                    curr = curr.right;
            }
            //inserting at the found position
            if(prev.val > x){
                prev.left = node;
            }else if(prev.val < x){
                prev.right = node;
            }
        }

    }
}
