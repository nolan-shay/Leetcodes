class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> set;
        while( !set.contains(n) ){
            set.insert(n);
            n = squareSum(n);
            if (n ==1) return true;
        }
        return false;
    }

    int squareSum( int x){
        cout << "x=" << x << "\n";
        int sum = 0;
        while ( x > 0){
            int dig = x % 10;
            x = x/10;
            sum += dig*dig;
        }
        cout << "Sum=" << sum << "\n";
        return sum;
    }
};
