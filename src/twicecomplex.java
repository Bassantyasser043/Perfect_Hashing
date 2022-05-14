import java.io.IOException;
public class twicecomplex {

        private Integer[] values, Table;
        public int n, Numberofcollisions;
        private boolean collision;
        Universal hFunction;

        public twicecomplex(Integer[] values) {
            this.values = values;
            n = values.length;
            Numberofcollisions = 0;
            collision = true;
            //n^2
            this.hFunction = new Universal(n * n);
        }

        public boolean hashN2() {
            if (n == 1) {
                Table = new Integer[1];
                Table[0] = values[0];
            } else {
                while (collision) {
                    collision = false;
                    Table = new Integer[n * n];
                    hFunction.generateHF();
                    for (int num:values) {
                        //get index of each value in binary value.
                        //return key=index
                        int idx = hFunction.hashing(num);
                        if (Table[idx] != null && !Table[idx].equals(num)) {
                            Numberofcollisions++;
                            System.out.println("Collision at: " + num + ", at Index: " + idx);
                            collision = true;
                            break;
                        }
                        Table[idx] = num;
                    }
                }
            }
            return true;
        }

        public int getNumberofcollisions(){
            return Numberofcollisions;
        }


    public int getSpace_ONsquare() {
        return (n * n) + n;
    }

    public String printHTable() {
            Main main=new Main();
        StringBuilder printer = new StringBuilder();
        printer.append('[');
        for (int i = 0; i < Table.length; i++) {
            if (Table[i] == null) {
                printer.append("   , ");
            } else {
                printer.append(Table[i] + ", ");

            }
        }
        if (!printer.toString().contains(", ")) {
            printer = new StringBuilder();
        } else  { //remove the substring of the last array in stringbuilder
            printer.deleteCharAt(printer.length()-2);
            printer.append("]");
        }

        System.out.println(printer);
  return String.valueOf(printer);
    }


}
