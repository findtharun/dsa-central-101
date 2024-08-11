package StackAndQueue.FaultyKeyboard;

public class Bruteforce {
    public String finalString(String s) {
        StringBuilder nm = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                nm.reverse();
            } else {
                nm.append(c);
            }
        }
        return nm.toString();
    }
}
