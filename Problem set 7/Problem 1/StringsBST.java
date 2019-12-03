import java.util.ArrayList;

public class StringsBST extends BSTree<String>{

    public void balance(){

        ArrayList<String> everyWordInTheTree = allWordsSortedAtoZ();
        this.clear();

//        System.out.print("[ ");
//        for(int i = 0; i< everyWordInTheTree.size(); i++){
//            System.out.print(everyWordInTheTree.get(i)+" ");
//        }
//        System.out.println("]");

        balanceHelp(everyWordInTheTree, 0, everyWordInTheTree.size());
    }

    private void balanceHelp(ArrayList<String> arrayList, int start, int end){

        if (end - start == 3) {
            this.insert(arrayList.get(start + 1));
            this.insert(arrayList.get(start));
            this.insert(arrayList.get(end - 1));
            return;
        }
        else if(end - start < 3){
            for(int i = start; i<end; i++){
                this.insert(arrayList.get(i));
            }
            return;
        }
        int middle = start + ((end - start)/2);

        insert(arrayList.get(middle));

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
        allWordsSortedAtoZHelp(rt.right(), words);

        return;
    }

    public void findSimilar(String key) {
        ArrayList<String> allSimilarWords = new ArrayList<>();
        allSimilarWords = findSimilar(root, key, allSimilarWords);

        if (!allSimilarWords.isEmpty()) {
            System.out.print("[ ");
            for(int i = 0; i<allSimilarWords.size(); i++){
                System.out.print(allSimilarWords.get(i)+" ");
            }
            System.out.println("]");
        }
    }
    
    protected ArrayList<String> findSimilar(BSTNode rt, String k, ArrayList<String> allSimilarWords)
    {
        if(rt == null) return allSimilarWords;
        String c = (String) rt.value();

        if(isSimilarOrEqualTo(c,k)){
            similarFound(rt,k,allSimilarWords);
        }

        if(c.compareTo(k) > 0) {
            findSimilar(rt.left(), k, allSimilarWords);

            //If c is greater than k but is similar to k, go and check its right side too.
            if (isSimilarOrEqualTo(c, k)) {
                findSimilar(rt.right(), k, allSimilarWords);
            }
            return allSimilarWords;
        }
        else
            return findSimilar(rt.right(), k, allSimilarWords);
    }

    protected void similarFound(BSTNode rt, String k, ArrayList<String> allSimilarWords){

        if(rt == null) return;
        String c = (String) rt.value();
        if(isSimilarOrEqualTo(c,k)){
            allSimilarWords.add(c);
            return;
        }
        else return;
    }

    static boolean isSimilarOrEqualTo(String word1, String word2){
        if(word1.length()>=word2.length()) {
            if (word1.substring(0, word2.length()).equals(word2))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
