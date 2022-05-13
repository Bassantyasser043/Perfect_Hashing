package perfect_Hashing;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public Integer[] reading(File file){
        Integer vec[] = null;
        try {
            Scanner in = new Scanner(file);
            String[] s = in.useDelimiter("\\Z").next().split(",");
            in.close();
            vec = new Integer[s.length];
            System.out.println("kkdk "+Arrays.toString(s));
            for (int i = 0; i < s.length; i++) {
                vec[i] = Integer.parseInt(s[i]);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vec;
    }
    public static void main(String[] args) {
        File file = new File("123.txt");
        Main readTextFile=new Main();
        Integer[] values = readTextFile.reading(file);
        boolean chechValues = true;
        int n=values.length;
        twicecomplex nnSpaceSol = new twicecomplex(values);
		if (nnSpaceSol.hash()) {
			System.out.println("DATA HASHED SUCCESSFULLY");
		}
		nnSpaceSol.printHTable();

		System.out.println("REBUILDING TRIALS :"+nnSpaceSol.getNumberofcollisions());


		for (int i = 0; i < values.length && chechValues; i++) {
			chechValues = nnSpaceSol.exist(values[i]);
		}
        if (chechValues) {
			System.out.println("ALL ELEMENTS EXISTS");
		}else{
			System.out.println("FAILD TO FIND SOME ELEMENTS");
		}
    }
}
