package stackoverflow;

public class Test {

    public static void main(String[] args) {


        String a = "999";
        String b = "9";

        char[] array_a = a.toCharArray();
        char[] array_b = b.toCharArray();


        int i = array_a.length - 1;
        int j = array_b.length - 1;

        int carry = 0;

        int maxLen = Math.max(i, j);
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0) {
            int avalue = a.charAt(i) - '0';
            int bvalue = b.charAt(j) - '0';
            int result = avalue + bvalue;
            carry = result / 10;
            int res = result % 10;
            sb.append(res);
            i--;
            j--;
        }

        while(i >= 0) {
            int avalue = a.charAt(i) - '0';
            int result = avalue + carry;
            carry = result / 10;
            int res = result % 10;
            sb.append(res);
            i--;
        }

        while(j >= 0) {
            int bvalue = b.charAt(j) - '0';
            int result = bvalue + carry;
            carry = result / 10;
            int res = result % 10;
            sb.append(res);
            j--;
        }

        if(carry > 0) {
            sb.append(carry);
        }

        System.out.println(sb.reverse().toString());

    }
}
