public class Power {

    public int power(int m, int n){
        if(n == 0){
            return 1;
        }
        else{
            return m * power(m,n - 1);
        }
    }
}
