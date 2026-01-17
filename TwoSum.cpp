class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

        std::unordered_map<int,int> map;

        for ( size_t i = 0; i < nums.size(); ++i){
            int comp = target - nums[i];
            if (map.find(comp) != map.end()){
                vector<int> x = {map[comp], static_cast<int>(i)};
                return x;
            }
            map[nums[i]] = i;
        }

        std::cout<< "Hello";
        vector<int> x = {0};
        return x;
    }
};


// for each num
//     candidate = target - num
//     does hashMap contain candidate?
//     if so return current indice+candidate indice




// all we need is hashMap<value,indice>
