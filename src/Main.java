import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

    public class Main {

            public Integer[] reading(File file) throws IOException {
                Integer values[] = null;
                try {
                    Scanner in = new Scanner(file);
                    String[] s = in.useDelimiter("\\Z").next().split(",");
                    in.close();
                    values = new Integer[s.length];
                    for (int i = 0; i < s.length; i++) {
                        values[i] = Integer.parseInt(s[i]);
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return values;
            }

        public void save(String content , String FileName) throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileName));
            writer.write(content);
            writer.close();
        }

        public static void main(String[] args) throws IOException , NumberFormatException {
            Scanner s=new Scanner(System.in);
            while(true) {
                System.out.println("Enter name of the file of the elements with its extention like(file.txt) : ");
                String FileIn=s.nextLine();

                File file = new File(FileIn);
                Main readTextFile=new Main();
                Integer[] values = readTextFile.reading(file);

                System.out.println(Arrays.toString(values));


                System.out.println("Enter (on) in case of order of N or (on2) in case of order of N^2:  ");
                String require = s.nextLine();
                switch (require) {
                    case "on":
                        OrderOfN nSoln = new OrderOfN(values);
                        if (nSoln.hashN()) {
                            System.out.println("n Soln HASHED SUCCESSFULLY");
                        }
                        nSoln.printHTable_OrderOfN();
                        int space = nSoln.getSpace_OrderN();
                        System.out.println("Space = " + space);


                        nSoln.getNoOfRehashing();
                        break;
                    case "on2":
                        System.out.println("Enter name of the file of the result: ");
                        String FileOut=s.nextLine();
                        twicecomplex nnSpaceSol = new twicecomplex(values);
                        if (nnSpaceSol.hashN2()) {
                            System.out.println("Order of n square hashed successfully..");
                        }

                        try {
                            readTextFile.save(nnSpaceSol.printHTable(),FileOut);  //for saving the result in file
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        int spacenn = nnSpaceSol.getSpace_ONsquare();
                        System.out.println("Space = " + spacenn);
                        System.out.println("Number of Collisions: " + nnSpaceSol.getNumberofcollisions());
                        break;
                    case "exit":
                        System.exit(0);
                        break;
                }

            }


        }
    }

