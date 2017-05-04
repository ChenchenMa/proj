/**
 * Created by Administrator on 2017/5/3.
 */
public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y){
    return (x-y == 1 || y-x == 1);
    }

    /*public static void main (String[] args) {
        OffByOne ex = new OffByOne();
        if(ex.equalChars('a','b')){System.out.print("true");}
    }*/
}
