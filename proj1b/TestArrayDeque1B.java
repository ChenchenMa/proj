/**
 * Created by Administrator on 2017/5/3.
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

    @Test
    public void Test(){
        StudentArrayDeque<Integer> A = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> B = new ArrayDequeSolution<>();
        OperationSequence fs = new OperationSequence();

        boolean success = true;
        for (int i = 0; i < 200 && success; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                A.addFirst(i);
                B.addFirst(i);
                DequeOperation op = new DequeOperation("addFirst", i);
                fs.addOperation(op);
            } else if(numberBetweenZeroAndOne <0.5){
                A.addLast(i);
                B.addLast(i);
                DequeOperation op = new DequeOperation("addLast", i);
                fs.addOperation(op);
            } else if(numberBetweenZeroAndOne < 0.75 && !A.isEmpty() && !B.isEmpty()){
                Integer a = A.removeFirst();
                Integer b = B.removeFirst();
                if(a != b) {
                    success = false;
                }
                DequeOperation op = new DequeOperation("removeFirst");
                fs.addOperation(op);
                String message = fs.toString();
                assertEquals(message, b, a);
            } else if(numberBetweenZeroAndOne < 1 && !A.isEmpty() && !B.isEmpty()){
                Integer a = A.removeLast();
                Integer b = B.removeLast();
                if(a != b) {
                    success = false;
                }
                DequeOperation op = new DequeOperation("removeLast");
                fs.addOperation(op);
                String message = fs.toString();
                assertEquals(message, b, a);
            }
        }
    }

}
