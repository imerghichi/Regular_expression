
public class Regular_expression {
    public static boolean is_matching(String text, String regular_expression) {
        boolean[][] m = new boolean[text.length() + 1][regular_expression.length() + 1];
        m[text.length()][regular_expression.length()] = true;
        for (int i = text.length(); i >= 0; i--) {
            for (int j = regular_expression.length()-1; j >= 0; j--) {
                boolean first_match = false;
                if (i < text.length() && (regular_expression.charAt(j) == text.charAt(i) || regular_expression.charAt(j) == '.')) {
                    first_match = true;
                }
                if (j + 1 < regular_expression.length() && regular_expression.charAt(j + 1) == '*') {
                    m[i][j] = m[i][j + 2] || first_match && m[i + 1][j];
                } else {
                    m[i][j] = first_match && m[i + 1][j + 1];
                }
            }
        }
        return m[0][0];
    }
    //test

    public static void main(String args[]){
        String text = "aa";
        String regular_expression = "a*";

        boolean b = is_matching("aa","a*");
        System.out.print(b);
    }
}
