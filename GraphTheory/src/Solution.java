class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.longestPalindrome("babad");
	}
	
    public String longestPalindrome(String s) {
        int N = s.length();
        int start = 0;
        int end = 0;
        
        for(int i =0; i < s.length() - 1; i++) {
            
            int[] a = expand(i,i,N,s);
            int[] b = expand(i, i+1,N,s);
            if(a[1] - a[0] > b[1] - b[0]) {
               if(end -start < a[1] - a[0]) {
                   start = a[0];
                   end = a[1];
               }         
            }else {
                if(end - start < b[1] - b[0]) {
                   start = b[0];
                   end = b[1];
               }
            }
            
            
        }
        return s.substring(start,end);
    }
    
    public int[] expand(int p1,int p2, int N,String s) {
        
        int[] a = new int[2];
        while(p1 - 1 >= 0 && p2 + 1 < N) {
            if( s.charAt(p1) == s.charAt(p2)) {
                a[0] = p1;
                a[1] = p2; 
                p1--;
                p2++;
            }else {
                return a; 
            }
            
        }    
        return a;
    }
    
}