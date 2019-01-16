package main;

import java.util.HashMap;

public class CorrellationStorage {


    private double[][] correllations;
    private HashMap<Integer, Integer> idMap;
    private Click[] clicks;

    public static void main(String[] args){

        new CorrellationStorage().run();
    }

    void run(){
        clicks = getTestData(1000,5);

        correllations = calculateCorrelations(clicks);

        double correllation_3_5 = getCorrellationByIndex(3, 5);
        double correllation_5_3 = getCorrellationByIndex(5, 3);

        if (correllation_3_5==correllation_5_3){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        double correllationById_5_6 = getCorrellationByIds(1005, 1006);
        double correllationById_6_5 = getCorrellationByIds(1006, 1005);

        if (correllationById_5_6==correllationById_6_5){
            System.out.println("PASS by ID");
        }else {
            System.out.println("FAIL by ID");
        }
    }

    private double getCorrellationByIndex(int i, int j) {
        if (j>i){
            return correllations[j][i];
        }else {
            return correllations[i][j];
        }
    }

    private double getCorrellationByIds(int id1, int id2){
        int indexa = idMap.get(id1);
        int indexb = idMap.get(id2);
        return getCorrellationByIndex(indexa,indexb);
    }


    private double[][] calculateCorrelations(Click[] clicks) {
        correllations = new double[clicks.length][];
        idMap=new HashMap<>();
        for (int i=0; i<clicks.length;i++){
            idMap.put(clicks[i].id,i);
            correllations[i] = new double[i+1]; // remove the '+1' here and the '=' in the for if you don't need the correllation of it with it's self(as i guess it should be perfect = 1?)
            for (int j=0; j<=i;j++){

                correllations[i][j]= correllation(clicks[i].wave, clicks[j].wave);
            }
        }
        return correllations;
    }

    double correllation(double[] wave1, double[] wave2){
        double total = 0;
        for (int i=0;i<wave1.length;i++){
            total += wave1[i]*wave2[i];
        }
        return total/wave1.length;
    }

    class Click{
        int id;
        double[] wave;
        public Click(double[] wave){
            this.wave = wave;
        }
    }

    Click[] getTestData(int size, int waveLen){
        Click[] clicks = new Click[size];
        int offset = 100;
        for (int i=0;i<size;i++){
            clicks[i] = new Click(randAry(waveLen));
            clicks[i].id = i+offset;
        }
        return clicks;
    }

    static double[] randAry(int len){
        double[] array = new double[len];
        for (int j=0;j<array.length;j++){
            array[j] = Math.random();
        }
        return array;
    }
}
