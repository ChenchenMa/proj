/**
 * Created by Administrator on 2017/5/3.
 */
public class OffByOne implements CharacterComparator {

    int n;

    public OffByOne( int n){
        this.n = n;
    }


    @Override
    public boolean equalChars(char x, char y){
    return (x-y == n || y-x == n);
    }

    /*public static void main (String[] args) {
        OffByOne ex = new OffByOne();
        if(ex.equalChars('a','b')){System.out.print("true");}
    }*/
}
