class Solution {
public:
    string longestPalindrome(string s) {
        int max = 0;
        string maxStr = "";
        for ( size_t i = 0; i < s.size(); ++i){
            int size = 1;
            string str = "";
            str += s[i];
            int left = i-1;
            int right = i+1;
            while ( left >= 0 && right < s.size()){
                if (s[left] == s[right]) {
                    size += 2;
                    str = s[left] + str + s[right];
                } else break;
                left--;
                right++;
            }
            if ( size > max){
                max = size;
                maxStr = str;
            }
        }
        for ( size_t i = 0; i < s.size()-1; ++i){
            int size = 0;
            string str = "";
            int left = i;
            int right = i+1;
            while ( left >= 0 && right < s.size()){
                if (s[left] == s[right]) {
                    size += 2;
                    str = s[left] + str + s[right];
                } else break;
                left--;
                right++;
            }
            if ( size > max){
                max = size;
                maxStr = str;
            }
        }
        return maxStr;
    }
};



// n * n2 brute force, check each subtring see if its a palindrome maintain longest length

// n2 where you start from the middle position and build out to the left and right to see if its a palindrome

// for each index
//     check if adding one to the end and one to the beginning still makes it a palindrome, if so keep going until out of bounds
// for each index where index stop one short so that you can look at pairs
