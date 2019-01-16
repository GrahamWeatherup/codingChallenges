package codingChallengesTechLead;

public class num7 {
    /*
    This problem was asked by Facebook.

    Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

    For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

    You can assume that the messages are decodable. For example, '001' is not allowed.
     */

    public static void main(String[] args) {
        try {
            new num7().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() {
        System.out.println(countDecodeOptions("26"));
        System.out.println(countDecodeOptions("111"));
    }

    int countDecodeOptions(String message) {

        int returnVal = 0;

        if (message.length() > 0) {
            int thisLevel = 0;
            Fits fits = getNumFits(message);
            if (fits.ones){
                String remaining = message.substring(1);
                System.out.println("1s:"+remaining);
                if (remaining.length()>0) {
                    thisLevel += countDecodeOptions(remaining);
                }else{
                    thisLevel += 1;
                }

            }
            if (fits.twos){
                String remaining = message.substring(2);
                System.out.println("2s:"+remaining);
                if (remaining.length()>0) {
                    thisLevel += countDecodeOptions(remaining);
                }else{
                    thisLevel += 1;
                }
            }
            returnVal+=thisLevel;
        }

        return returnVal;
    }

    Fits getNumFits(String remaining){
        if (remaining.length()==0){
            return null;
        }
        Fits fits = new Fits();
        char char1 = remaining.charAt(0);
        fits.ones=char1!='0';
        if (remaining.length()>1) {
            char char2 = remaining.charAt(1);
            fits.twos = char1 == '1' || (char1 == '2' && char2 < '7');
        }
        return fits;
    }

    class Fits{
        boolean ones = false;
        boolean twos = false;

        @Override
        public String toString() {
            return String.format("Fits[ones=%s,twos=%s]",ones,twos);
        }
    }

    private enum Alphabet{£,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z}

}
