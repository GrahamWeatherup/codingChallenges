package main;

import java.util.HashMap;

public class CorrellationStorage {




    public static void main(String[] args){

        new CorrellationStorage().run();
    }

    void run(){
        Click[] clicks = getTestData(1000,5);

        HashMap<MyKey,Double> correllations = new HashMap<MyKey,Double>();

        for (int i=0; i<clicks.length;i++){
            for (int j=i+1; j<clicks.length;j++){
                correllations.put(new MyKey(i,j),correllation(clicks[i].wave,clicks[j].wave));
            }
        }


    }

    double correllation(double[] wave1, double[] wave2){
        double total = 0;
        for (int i=0;i<wave1.length;i++){
            total += wave1[i]*wave2[i];
        }
        return total/wave1.length;
    }


    public class MyKey{
        private final int x;
        private final int y;

        public MyKey(int x, int y) {
            if (x > y) {
                this.x = y;
                this.y = x;
            } else {
                this.x = x;
                this.y = y;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyKey)) return false;
            MyKey key = (MyKey) o;
            return x == key.x && y == key.y;
        }

        @Override
        public int hashCode() {
            return 0;//TODO this will only ever store 1 value?
        }
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
        for (int i=0;i<size;i++){
            clicks[i] = new Click(randAry(waveLen));
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
