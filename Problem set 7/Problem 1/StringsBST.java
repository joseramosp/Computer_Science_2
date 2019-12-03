import java.util.ArrayList;

public class StringsBST extends BSTree<String>{

    public void balance(){

        ArrayList<String> everyWordInTheTree = allWordsSortedAtoZ();
        this.clear();

        System.out.print("[ ");
        for(int i = 0; i< everyWordInTheTree.size(); i++){
            System.out.print(everyWordInTheTree.get(i)+" ");
        }
        System.out.println("]");

        balanceHelp(everyWordInTheTree, 0, everyWordInTheTree.size());
    }

    private void balanceHelp(ArrayList<String> arrayList, int start, int end){

        if (end - start == 3) {
            this.insert(arrayList.get(start + 1));
            System.out.println(arrayList.get(start + 1));
            this.insert(arrayList.get(start));
            System.out.println(arrayList.get(start));
            this.insert(arrayList.get(end - 1));
            System.out.println(arrayList.get(end - 1));
            return;
        }
        else if(end - start < 3){
            for(int i = start; i<end; i++){
                this.insert(arrayList.get(i));
                System.out.println(arrayList.get(i));
            }
            return;
        }
        int middle = start + ((end - start)/2);

        insert(arrayList.get(middle));
        System.out.println(arrayList.get(middle));

        balanceHelp(arrayList, start, middle);

        balanceHelp(arrayList,middle+1,end);
    }

    public ArrayList<String> allWordsSortedAtoZ(){
        int count = 0;
        ArrayList<String> allWordsAtoZ = new ArrayList<>();
        allWordsSortedAtoZHelp(root, allWordsAtoZ);
        return allWordsAtoZ;
    }

    protected void allWordsSortedAtoZHelp(BSTNode rt, ArrayList<String> words)
    {
        if(rt == null) return;
        allWordsSortedAtoZHelp(rt.left(), words);
        words.add((String) rt.value());
        // System.out.print(rt.value() + " ");
        allWordsSortedAtoZHelp(rt.right(), words);

        return;
    }



}
