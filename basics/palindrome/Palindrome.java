public class Palindrome {
    public boolean isPalindrome(String str) {
        if (str.length() == 0) return false;
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}