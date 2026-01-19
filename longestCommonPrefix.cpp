class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        bool isPrefix = true;
        int pos = 0;
        char match;
        string prefix = "";
        while( isPrefix ){
            for (size_t i = 0; i < strs.size(); ++i){
                if (!(pos < strs[i].size())){
                    isPrefix = false;
                    break;
                }
                if ( i == 0) {
                    match = strs[i][pos];
                } else if (strs[i][pos] != match){
                    isPrefix = false;
                    break;
                }
            }
            if (isPrefix){
                prefix += match;
                ++pos;
            }else {
                return prefix;
            }
        }
        return prefix;
    }
};

/*

isPrefix = true
pos = 0;
prefix = ""
matchChar = '';
while ( isPrefix)
    for ( each str : strs)
        if ( ! pos , str.size()) 
            isPrefix = false
            break;
        if ( firstString ) matchChar = str[pos]
        if str[pos] != matchChar
            isPrefix = false
            break;
    if isPrefix
        add matchChhar to prefix
        pos++
    else return prefix
return prefix;

isPrefix = false
pos = 2;
prefix = "fl"
matchChar = 'o';


"fl"
"flower"
"flow"
"flight"
        


*/
