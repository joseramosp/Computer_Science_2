
public class Question<V extends Comparable<V>> {

    private V question;
    private Question no;
    private Question yes;
    private Question parentQuestion;

    public Question(V data) {
        this.question = data;
    }

    public void setParent(Question<V> parentQuestion){
        this.parentQuestion = parentQuestion;
    }

    public Question<V> getParent(){
        return parentQuestion;
    }

    public Question(V data, Question<V> parent) {
        this.question = data;
        parentQuestion = parent;
    }

    public Question(V data, Question<V> n, Question<V> y) {
        this.question = data;
        this.no = n;
        this.yes = y;
    }

    public void setNo(Question<V> no) {
        this.no = no;
    }

    public void setNo() {
        this.no = null;
    }

    public void setYes(Question<V> yes) {
        this.yes = yes;
    }

    public void setYes() {
        this.yes = null;
    }

    public void setQuestion(V question) {
        this.question = question;
    }

    public V question() {
        return question;
    }

    public Question<V> yes() {
        return yes;
    }

    public Question<V> no() {
        return no;
    }

    public boolean hasChild() {
        return (!isLeaf());
    }

    public boolean isLeaf() {
        return no == null && yes == null;
    }

    public boolean hasParent(){
        return parentQuestion != null;
    }

    public String toString(){
        String s = " { ";

        if(this.isLeaf()){
            s = s + "\" "+(question.toString()+" \" { \" {null} \" { \" {null} \" } }");
        }
        else{
            s = s + "\" "+(question.toString()+" \"" + no.toString() + yes.toString());
        }
        s = s + " }";
        return s;
    }
}
