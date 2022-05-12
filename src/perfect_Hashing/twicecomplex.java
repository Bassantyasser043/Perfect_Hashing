package perfect_Hashing;
public class twicecomplex {
        private Integer[] values, Table;
        private int n, Numberofcollisions;
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

        public boolean hash() {
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
                            System.out.println("Collision at: " + num + ", To Index: " + idx);
                            Numberofcollisions++;
                            collision = true;
                            break;
                        }
                        Table[idx] = num;
                    }
                }
            }
            return true;
        }

        public int getNumberofcollisions() {
            return Numberofcollisions;
        }

        public boolean exist(int value) {
            if (n == 0) {
                return false;
            }
            if (n == 1) {
                if (Table[0] == value) {
                    return true;
                }
                return false;
            }
            if (Table[hFunction.hashing(value)] != null) {
                return true;
            }
            return false;
        }
        public void printHTable() {
            StringBuilder printer = new StringBuilder();
           printer.append('[');
            for (int i = 0; i < Table.length; i++) {
                if (Table[i] == null) {
                    printer.append("-, ");
                } else {
                    printer.append(Table[i] + ", ");
                }
            }
            if (!printer.toString().contains(",")) {
                printer = new StringBuilder();
            } else { //remove the substring of the last array in stringbuilder
                printer.deleteCharAt(printer.length() - 1);
                printer.append(']');
            }
            System.out.println(printer);
        }

        public int getSpaceUsed() {
            return (n * n) + n;
        }
    }
