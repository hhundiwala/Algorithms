import java.lang.reflect.Array;
import java.net.SocketPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class solution {

    public static void main(String args[]){
        solution sol = new solution();
        int[] arr = {1};
        int[] arr1 = {1};
        //sol.rotate(arr,3);
        System.out.println("Ans: " + sol.intersect(arr,arr1));
    }

    public double myPow(double x, int n) {
        double answer = 1;
        for(int i=0;i<n;i++){
            answer = answer * x;
        }
        if(n<0)
            return 1/answer;
        return answer;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowest_price = prices[0];
        int max_profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<lowest_price){
                lowest_price=prices[i];
            }else{
                profit = prices[i]-lowest_price;
            }
            if(profit>max_profit){
                max_profit = profit;
            }
        }
        return max_profit;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }else{
                count=0;
            }
        }
        return count;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out = new ArrayList<Integer>();
        int len = nums.length;
        for(int i=1;i<=len;i++){
            out.add(i);
        }
        for(int i=0;i<len;i++){
            out.remove(nums[i]);
        }
        return out;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int j=0;
        int num=0;
        if(nums.length<2)
            return false;
        for(int i=0;i<nums.length;i++){
            num=nums[i];
            j=i+1;
            while(j<nums.length && nums[j]!=num){
                j++;
            }
            if(j<nums.length && nums[i]==nums[j] && Math.abs(nums[i]-nums[j])<=k)
                return true;

        }
        return false;
    }

    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(j<nums.length-1){
            while(i<nums.length && nums[i]!=0){
                i++;
            }
            j=i+1;
            while(j<nums.length && nums[j]==0){
                j++;
            }
            if(j>= nums.length)
                break;
            nums[i] = nums[j];
            nums[j] = 0;
            i++;
        }
        System.out.println(nums);
    }

    public int maximumProduct(int[] nums) {
        int len = nums.length;
        int res_1,res_2;
        Arrays.sort(nums);
        res_1 = nums[len-1]*nums[len-1]*nums[len-3];
        res_2 = nums[0]*nums[1]*nums[len-1];
        return Math.max(res_1,res_2);
    }

    public boolean canPlaceFlowers(int[] nums, int n) {

            int count=0;

            for(int i=0;i<nums.length;i++){
                if(i==0){
                    if(nums[i]==0 && nums[i+1]==0){
                        count++;
                    }
                    i++;
                }else if(i==nums.length-1){
                    if(nums[i]==0 && nums[i-1]==0)
                        count = count+1;
                }else{
                    if(nums[i-1]==0 && nums[i]==0 && nums[i+1]==0){
                        count++;
                        nums[i]=1;
                        i++;
                    }
                }
            }
            if(n<=count)
                return true;
            else
                return false;

//
//        int count=0;
//        for(int i=0;i<nums.length-1;i++){
//            if(i==0 && nums[i]==0 && nums[1]==0){
//                count++;
//                i++;
//            }
//            if(i==nums.length-1 && nums[i]==0 && nums[i-1]==0){
//                count++;
//                i++;
//            }
//            if(i!=0 && i!=nums.length-1 &&
//                    nums[i]==0 && nums[i-1]==0 && nums[i+1]==0 ){
//                count++;
//                i++;
//            }
//        }
//        if(count>=n)
//            return true;
//        return false;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();

        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                k++;
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }
        }
        int[] res = new int[list.size()];
        for(int q=0;q<list.size();q++)
            res[q] = list.get(q);
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] previous = new int[len];
        int[] result = new int[len];
        int[] next = new int[len];
        int mult_for_previous = 1;
        int mult_for_next = 1;
        for(int i=0,j=len-1;i<len && j>=0;i++,j--){
            //for ith we are calculating the previous array
            mult_for_previous = mult_for_previous * nums[i];
            previous[i] = mult_for_previous;

            //for jth we are calculating next array
            mult_for_next = mult_for_next * nums[j];
            next[j] = mult_for_next;
        }

        //till now we have calulated the previous and next arrays
        for(int i=0;i<len;i++){
            if(i==0)
                result[i] = next[i+1];
            else if(i==len-1)
                result[i] = previous[i-1];
            else
                result[i] = previous[i-1]*next[i+1];
        }
        return result;
    }

    public int findLength(int[] A, int[] B) {
        int max_length = -1;
        int curr_length = 0;
        int len_a = A.length;
        int len_b = B.length;
        for(int i=0;i<len_a;i++){
            for(int j=0;j<len_b;j++){
                if(A[i]==B[j]){
                    int temp_i = i;
                    curr_length = 0;
                    while(j<(len_b-1) && temp_i<(len_a-1)&& A[temp_i]==B[j]){
                        j++;
                        temp_i++;
                        curr_length++;
                    }
                    if(curr_length>max_length){
                        max_length = curr_length;
                    }
                }
            }
        }
        return max_length;
    }

    public double findMaxAverage(int[] nums, int k) {
        double max_avg = -(Double.MIN_VALUE);
        for(int i=0;i<=(nums.length-k);i++){
            double sum = 0;
            for(int j=0;j<k;j++){
                sum = sum + nums[i+j];
            }
            sum = sum/k;
            if(sum>max_avg){
                max_avg = sum;
            }
        }
        return max_avg;
    }

    public String reverseString(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        int i=0,j=len-1;
        while(i<j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        return Arrays.toString(str);
    }

    public boolean isValid(String st) {
        char[] str = st.toCharArray();
        char temp;
        Stack<Character> s = new Stack<Character>();
        for(int i =0 ; i<str.length;i++){
            if(str[i]=='(' || str[i]=='{' || str[i]=='[')
                s.push(str[i]);
            else{  //means the its closing bracket
                if(s.empty()) return false;
                if(s.peek()=='(' && str[i]==')') s.pop();
                else if(s.peek()=='{' && str[i]=='}') s.pop();
                else if(s.peek()=='[' && str[i]==']') s.pop();
                else return false;
            }
        }
        if(s.empty()) return true;
        return false;
    }

    public String reverseWords(String s) {
        char[] _s = s.toCharArray();  //converting string to array
        int itr = 0;   //taking the iterator
        int i=0;
        int j=0;
        while(i<_s.length && j<_s.length){
            while( j< _s.length-1 && _s[j] != ' '){
                j++;
            }
            // now i is pointing to start and j to end
            int m = i;
            int n = j-1;
            //reversing the string
            while(m<n){
                char temp = _s[m];
                _s[m] = _s[n];
                _s[n] = temp;
                m++;
                n--;
            }
            i = j+1;
            j = i;
        }
        return String.valueOf(_s);
    }

    public boolean detectCapitalUse(String word) {
        char[] _word = word.toCharArray();
        if(_word.length == 1)
            return true;
        int i = 0;
        //if first letter is capital
        if(Character.isUpperCase(_word[i])){
            if(Character.isUpperCase(_word[i+1])){
                for(int j =0 ; j<_word.length;j++){
                    System.out.println(_word[j]);
                    if(Character.isLowerCase(_word[i])) return false;
                }
                return true;
            }else{
                for(int j =1 ; j<_word.length;j++){
                    if(Character.isUpperCase(_word[j])) return false;
                }
                return true;
            }
        }else{    //else everything should be small
            for(int j =0 ;j<_word.length;j++){
                if(Character.isUpperCase(_word[j]))
                    return false;
            }
            return true;
        }

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int count =1;
        int number = nums[0];
        List out = new ArrayList();
        for(int i=1;i<nums.length;i++){
            if(nums[i]==number){
                count++;
                if(count>=k){
                    out.add(number);
                    while((nums[i]==number))
                        i++;
                }
            }else{
                count = 1;
                number = nums[i];
            }
        }
        return out;
    }


    public boolean isPalindrome(String s) {
        char[] _s = s.toCharArray();
        int head = 0;
        int tail = _s.length-1;
        while(head<tail){
            if(!(Character.isLetter(_s[head]) || Character.isDigit(_s[head])))
                head++;
            else if(!(Character.isLetter(_s[tail]) || Character.isDigit(_s[head])))
                tail--;
            else if(Character.toLowerCase(_s[head]) == Character.toLowerCase(_s[tail])){
                head++;
                tail--;
            }else return false;
        }
        return true;
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        int itr = 0;
        for(int i=0;i<len;i++){
            if(i<(len-k))
                temp[i+k] = nums[i];
            else{
                temp[itr] = nums[i];
                itr++;
            }
        }

        for(int i=0;i<len;i++){
            nums[i] = temp[i];
        }
    }

    public int strStr(String haystack, String needle) {

        char[] haystack_char = haystack.toCharArray();
        char[] needle_char = needle.toCharArray();
        int i =0,j=0,ans=-1;
        if(needle.length()==0 && haystack.length()==0)
            return 0;
        if(haystack.length() == 0)
            return -1;
        if(needle.length()==0)
            return 0;
        while(i<haystack_char.length){
            j=0;
            if(haystack_char[i] == needle_char[j]){
                ans=i;
                while(j<needle_char.length && i<haystack_char.length){
                    if(haystack_char[i]== needle_char[j]){
                        if(j==needle_char.length-1)
                            return ans;
                        i++;
                        j++;
                    }else{
                        i=ans;
                        ans=-1;
                        break;
                    }
                }
            }
            i++;
        }
        return ans;
    }



}
