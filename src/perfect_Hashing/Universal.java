package perfect_Hashing;

import java.util.Random;

public class Universal {
    //number of elements in the matrix.
    private int elements_num=0;
    //vector array that is randomized
    private int [] vec;
    //size of the element itself.
    private int N;
    public Universal(int N) {
        //calculate the number of elements
        if(N>0) {
            this.N = N;
            elements_num = (int) (Math.floor((Math.log(N) / Math.log(2)))+1);
            vec = new int[elements_num];
        }
        //generate hash matrix.
        generateHF();
    }
   // randomized integers in the matrix.
    //construct hash function.
    public void generateHF(){
        Random r = new Random();
        for (int i = 0; i < elements_num; i++) {
            vec[i] = r.nextInt();
        }
    }
        public int hashing(int value){
            StringBuilder ap=new StringBuilder();
            for(int i=0;i<elements_num;i++){
                //counting number of ones in the numbers.
                ap.append((Integer.bitCount(value & vec[i]))%2);
            }
            //return key of the value.
            //4=100 integer=100
            return(Integer.parseInt(ap.toString(),2)%N);
        }
    }
//
