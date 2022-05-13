import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

    public class Main {

        public Integer[] reading(File file) throws IOException {
            String[] vec=null;
            String L = "";
            BufferedReader file1=new BufferedReader(new FileReader(file));
            while ((L = file1.readLine()) != null) {
                 vec = L.split(",");
            }
            Integer vecFinal[] = new Integer[vec.length];
            for(int i=0;i<vec.length;++i){
                  vecFinal[i]=Integer.parseInt(vec[i]);
            }
            return vecFinal;
        }

        public void save(String content) throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter("res.txt"));
            writer.write(content);
            writer.close();
        }

        public static void main(String[] args) throws IOException {
            Scanner s=new Scanner(System.in);
            File file = new File("file.txt");
            Main readTextFile=new Main();
            Integer[] values = readTextFile.reading(file);
            System.out.println(Arrays.toString(values));
            System.out.println("Enter (on) in case of order of N or (on2) in case of order of N^2:  ");
            String require=s.nextLine();
            switch (require){
                case "on":
                    OrderOfN nSoln=new OrderOfN(values);
                    if(nSoln.hashN()){
                        System.out.println("n Soln HASHED SUCCESSFULLY");
                    }
                    nSoln.printHTable_OrderOfN();
                    int space=nSoln.getSpace_OrderN();
                    System.out.println("Space = "+space);


                    nSoln.getNoOfRehashing();
                    break;
                case "on2":
                    twicecomplex nnSpaceSol = new twicecomplex(values);
                    if (nnSpaceSol.hashN2()) {
                         System.out.println("Order of n square hashed successfully..");
                     }
                    nnSpaceSol.printHTable();
                    int spacenn=nnSpaceSol.getSpace_ONsquare();
                    System.out.println("Space = "+spacenn);
                    System.out.println("Number of Collisions: "+nnSpaceSol.getNumberofcollisions());
                    break;
            }




        }
    }

