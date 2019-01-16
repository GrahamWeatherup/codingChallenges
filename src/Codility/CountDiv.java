package Codility;


class CountDiv {
    public int solution(int A, int B, int K) {

        int a = A/K;
        int aMod = A % K;
        int b = B/K;
        int bMod = A % K;

        int approx = b - a;
        if (bMod == 0 & aMod == 0 ) approx++;

        return approx;
    }

    void test(){
        check(5,10,2,3);
        check(6,11,2,3);
        for (int AA=0; AA<=50;AA++){
            for (int BB=AA; BB<=50;BB++){
                for (int KK=1; KK<=50;KK++){// add 1 check again later
                    checkAgainstCalcOnly(AA,BB,KK);
                }
            }
        }

    }

    void checkAgainstCalcOnly(int A, int B, int K){
        int fastSol = solution(A, B, K);
        if (fastSol == solutionKnown(A,B,K,true)) {
            System.out.println("PASS "+", "+A+", "+B+", "+K+", ans="+fastSol);
        }else {
            System.out.println("FAIL");
            solution(A, B, K);
            solutionKnown(A,B,K,true);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("FAIL on first for now");
        }

        System.out.println("=============");
    }

    void check(int A, int B, int K, int exp){
        int fastSol = solution(A, B, K);;
        if (fastSol == exp) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            solutionKnown(A,B,K,true);
        }


        System.out.println("=============");
    }

    public static void main(String[] args){
        new CountDiv().test();
    }

    public int solutionKnown(int A, int B, int K, boolean print) {
        int count = 0;
        if (print) System.out.print("{");
        for (int i=A;i<=B;i++){
            if ( i % K == 0) {
                if (print) System.out.print(i+",");
                count++;
            }
        }
        if (print) System.out.println("}");
        return count;
    }


}
