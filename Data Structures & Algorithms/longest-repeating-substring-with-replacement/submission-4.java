class Solution {
    public int characterReplacement(String s, int k) {

        int maxLen = 0;

        int left = 0;
        int right = 0;
        int hash[] = new int[26];

        int maxFreq = 0;
        while(left <= right && right < s.length()){

            hash[s.charAt(right) - 'A']++;
            maxFreq = findMaxFreq(hash);
            //System.out.println("maxFreq coming for pos flow" + maxFreq);

            //  if ((right - left+1) - maxFreq <= k){
                
            //     //System.out.println("Maxlen coming from >> " + right+" :" + left);
            //  }
                while((right - left+1) - maxFreq > k){
                     //System.out.println("Inside neg case >> " + right+" :" + left);
                    hash[s.charAt(left) - 'A']--;
                    maxFreq = findMaxFreq(hash);
                    //System.out.println("maxFreq coming for neg flow" + maxFreq);
                    left++;
                }

            maxLen = Math.max(maxLen, right - left+1);

            right++;

        }

        return maxLen;

    }


    int findMaxFreq(int[] hash){

        int maxFreq = 0;

        for (int index = 0; index < 26; index++){
            maxFreq = Math.max(maxFreq, hash[index]);
        }

        return maxFreq;
    }
}
