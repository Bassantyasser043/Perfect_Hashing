import java.util.ArrayList;

public class OrderOfN {

    public Integer[] elements;
    public int sizeElem=0;
    public Universal HFun;
    public twicecomplex[] table;

    public OrderOfN(Integer[] elements){
        this.elements=elements;
        this.sizeElem=elements.length;
        this.HFun=new Universal(sizeElem);
    }

   public boolean hashN(){
       boolean success;
        table=new twicecomplex[sizeElem]; ///////////from class of order n^2
       ArrayList<Integer>[] HTable = new ArrayList[elements.length];

       for(int t=0;t<HTable.length;++t){
           HTable[t]=new ArrayList<>();
       }
       ///first level of hashing before any collisions
       for(int i=0;i<sizeElem;++i) {
           int val = HFun.hashing(elements[i]);
           if (!HTable[val].contains(elements[i])) {
               HTable[val].add(elements[i]);

           }
       }
       ///rehash each bin using method 1 of order of N^2
       success = true;
           for(int j=0;j<sizeElem &success;++j){
               Integer[] values=new Integer[HTable[j].size()];
               values=HTable[j].toArray(values);
               table[j]=new twicecomplex(values);
               success=table[j].hashN2();  ///hashing of the second level after getting collisions
           }
             return success;

   }
    public void printHTable_OrderOfN() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("key" + i + " : ");
            table[i].printHTable();
        }
    }

    public int getSpace_OrderN() {
        int space = 0;
        for (int i = 0; i < table.length; i++) {
            space += table[i].getSpace_ONsquare();  //get space from order of N^2
        }
        space += sizeElem;   ///add the size oof the elements to the space of Order of N^2 to get space order of N
        return space;
    }

    public void getNoOfRehashing() {
        for (int i = 0; i < table.length; i++) {
            if(table[i].getNumberofcollisions() > 0){
             System.out.println("Rehashing happened at key :" + i + " and no. of Collisions are: " +table[i].getNumberofcollisions() );
            }else{
                System.out.println("");
            }

        }
    }


}
