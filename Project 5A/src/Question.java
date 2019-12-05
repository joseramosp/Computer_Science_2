
public class Question<V extends Comparable<V>> {

    private V question;

    private Question no;
    private Question yes;

    public Question(V data) {
        this.question = data;
    }

    public Question(V data, Question<V> parent) {
        this.question = data;
    }

    public Question(V data, Question<V> n, Question<V> y) {
        this.question = data;
        this.no = n;
        this.yes = y;
    }

    public void setNo(Question<V> no) {
        this.no = no;
    }

    public void setYes(Question<V> yes) {
        this.yes = yes;
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
}
