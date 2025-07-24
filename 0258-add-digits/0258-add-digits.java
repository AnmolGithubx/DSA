class Solution {
    public int addDigits(int num) {
        while (num >= 10) { // loop chle jb tk number 10 ya uss se bda hai
            int sum = 0;
//ye for loop num ki har digit ko ek-ek karke nikalta hai.
// num % 10 se last digit milti hai.
// Us digit ko sum mein add karte hain.
// num /= 10 se last digit remove ho jaati hai (integer division).
            for (; num > 0; num /= 10) {
                sum += num % 10;
            }
            num = sum;
        }
        return num;
    }
}
