package StackAndQueue.CandyCrush1D.RecursivelyRemoveAdjacentDuplicates;

public class IntuitiveApproach {

    public static String rremove(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i<n; i++){
            boolean repeated  = false;
            while(i+1 <n && s.charAt(i) == s.charAt(i+1)){
                repeated = true;
                i++;
            }
            if(!repeated)
                sb.append(s.charAt(i));
        }
        String result = sb.toString();
        // Check if result is different from input
        if (result.equals(s)) {
            return result;
        } else {
            // Recursively call rremove with the updated string
            return rremove(result);
        }
    }

    public static void main(String[] args) {
        String inputString = "abccbccba";
        String inputString2 = "abcccbd";
        String outputString = rremove(inputString2);
        System.out.println("Output: " + outputString);
    }
}
