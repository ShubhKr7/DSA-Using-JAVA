/*
 2351. First Letter to Appear Twice

 Given a string s consisting of lowercase English letters, return the first letter to appear twice.

Note:
A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
s will contain at least one letter that appears twice.
 
Example 1:
Input: s = "abccbaacz"
Output: "c"
Explanation:
The letter 'a' appears on the indexes 0, 5 and 6.
The letter 'b' appears on the indexes 1 and 4.
The letter 'c' appears on the indexes 2, 3 and 7.
The letter 'z' appears on the index 8.
The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.

Example 2:
Input: s = "abcdd"
Output: "d"
Explanation:
The only letter that appears twice is 'd' so we return 'd'.

Constraints:
2 <= s.length <= 100
s consists of lowercase English letters.
s has at least one repeated letter.
 */

package leetcodeQuestions;
class firstLetterToAppearTwice {
    public static char twice(String s) {
        boolean[] seen = new boolean[26]; // Array to track seen letters
        for (char c : s.toCharArray()) {
            int index = c - 'a'; // Convert character to index (0-25)
            if (seen[index]) {
                return c; // Return the first letter that appears twice
            }
            seen[index] = true; // Mark the letter as seen
        }
        return ' '; // Return a space if no letter appears twice
    }

    public static void main(String[] args) {
        String s = "abca"; // Example input
        char result = twice(s);
        if (result != ' ') {
            System.out.println("The first letter to appear twice is: " + result);
        } else {
            System.out.println("No letter appears twice in the string.");
        }
    }
}