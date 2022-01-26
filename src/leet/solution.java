package leet;

import java.util.*;

class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }

class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
public class solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){break;}
        }
        if(fast == null || fast.next == null){return null;}
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    // 1010
    public int numPairsDivisibleBy60(int[] time) {
        int ret = 0;
        int[] arr = new int[60];
        for(int dur : time){
            arr[(dur % 60)]++;
        }
        int left = 1;
        int right = 59;
        while(left < right){
            ret += arr[left] * arr[right];
            left++;
            right--;
        }
        ret += arr[0] > 1 ? (arr[0]-1)*arr[0]/2:0;
        ret += arr[30] > 1 ? (arr[30]-1)*arr[30]/2:0;
        return ret;
    }
    // 875
    public int minEatingSpeed(int[] piles, int h) {
        return 1;
    }
    public boolean validMountainArray(int[] arr) {
        int peak = 0;
        for(int i = 1; i < arr.length; ++i){
            if(arr[peak] < arr[i]){peak = i;}
            else if(arr[peak] == arr[i]){return false;}
            else{break;}
        }
        int i = peak+1;
        if(peak < arr.length - 1){
            for(; i < arr.length; ++i){
                if(arr[peak] <= arr[i]){return false;}
                else if(arr[peak] > arr[i]){
                    peak = i;
                }
            }
        }else{return false;}
        return true;
    }
    public boolean detectCapitalUse(String word) {
        int l = word.length();
        char last = word.charAt(l - 1);
        if(last <= 'z' && last >= 'a'){
            int index = l -1;
            while(index >= 1){
                if(!(word.charAt(index) <= 'z' && word.charAt(index) >= 'a')){return false;}
                index--;
            }
        }else if(last <= 'Z' && last >= 'A'){
            for(int i = 0; i < l; ++i){
                if(!(word.charAt(i) <= 'Z' && word.charAt(i) >= 'A')){return false;}
            }
        }
        return true;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(root1 != null || !st.empty()){
            while(root1 != null){
                st.push(root1);
                root1 = root1.left;
            }
            root1 = st.peek();
            st.pop();
            ret.add(root1.val);
            root1 = root1.right;
        }
        st = new Stack<>();
        while(root2 != null || !st.empty()){
            while(root2 != null){
                st.push(root2);
                root2 = root2.left;
            }
            root2 = st.peek();
            st.pop();
            ret.add(root2.val);
            root2 = root2.right;
        }
        Collections.sort(ret);
        return ret;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ret = new ArrayList<>();
        return ret;
    }
}
