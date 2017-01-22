import java.util.Vector;

public class TestCase {
    public static Vector<MyTask> getTestCases(){
        Vector<MyTask> testcases = new Vector<>();
        testcases.add(new MyTask("A", 0, 3));
        testcases.add(new MyTask("B", 2, 6));
        testcases.add(new MyTask("C", 4, 4));
        testcases.add(new MyTask("D", 6, 5));
        testcases.add(new MyTask("E", 8, 2));
        return testcases;
    }

}

