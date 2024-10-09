package io.ukoko.bhwms.aop;

/**
 * exxf 3 bxxf
 */
public class YresdWrfd {

    public static void main(String[] args) {

//        String exxf = getSmallestString("exxf", 3);
//        String exxf = getSmallestString("zbbz", 3);
//        String exxf = getSmallestString("xaxcd", 4);
        String exxf = getSmallestString("lol", 0);
        System.out.println(exxf);
//        char z = min('z', 1);
//        System.out.println(z);
//        System.out.println(gap('a', 'z'));
    }

    public static String getSmallestString(String s, int k) {

        char[] charArray = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : charArray) {
            int gap = gap(c,'a');
                if (gap>k){
                builder.append(min(c,k));
                k = 0;
            }else {
                builder.append('a');
                k = k-gap;
            }
        }
        return builder.toString();
    }

    public static char min(char c,int k){

        int max =  c + k > (int)'z'? c+k-26 : c+k;
        int min = c - k < (int) 'a'? c-k + (int)'a':c-k;

        return min - max < 0? (char)min:(char)max;
    }

    public static int gap(char a, char b){

        char min = a < b? a:b;
        char max = a > b? a: b;
        return  Math.min(Math.abs(max-min),Math.abs(min+26-max));
    }


}
