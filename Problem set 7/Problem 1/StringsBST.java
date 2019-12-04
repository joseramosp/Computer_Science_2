/* Problem set 7 - Problem 1

Name: Jose Ramos
NECC ID#: 00299444
Date: November 28, 2019

-- OBJECTIVE --

Implement a BinarySearchTree using BSTNodes of Strings. Include a balance method that balances the tree. Each node of the
tree contains a string. Sort the tree lexicographically. Write a program that  Enter 25 words into the structure. Prompt
the user for a word 1 letter at a time. Each time a letter is entered, print out all the possible words in the tree. This
continues until only one possible word is displayed. If the word is not the user's word, prompt them for the complete word
and add it to the tree. For example, if the tree contains the following: Apple, Hall, Hen, Hello, Help, Zoo - and the user
enters the letter H, Hen, Hello, and Help are printed. If the next letter entered is E then Hen, Hello, and Help are printed.
If next letter is L then Hello and Help are printed. If the next letter entered is L then Hello and Help are printed. If
P is the users final letter, Help is printed. If help is not the users word - perhaps it is Helper - their word is added
to the tree.

Reference: - OpenDSA Chapter 11
*/

import java.util.ArrayList;

public class StringsBST extends BSTree<String>{

    public void balance(){

        ArrayList<String> everyWordInTheTree = allWordsSortedAtoZ();
        this.clear();

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

    public boolean findSimilar(String key) {
        ArrayList<String> allSimilarWords = new ArrayList<>();
        allSimilarWords = findSimilar(root, key, allSimilarWords);

        if (!allSimilarWords.isEmpty()) {
            System.out.print("[ ");
            for(int i = 0; i<allSimilarWords.size(); i++){
                System.out.print(allSimilarWords.get(i)+" ");
            }
            System.out.println("]");
            return true;
        }
        return false;
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
        }
        return false;
    }
}
