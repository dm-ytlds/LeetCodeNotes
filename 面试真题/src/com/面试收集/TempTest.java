public class TempTest {
    private void test1(A a) {
        a.age = 20;
        System.out.println("test1 方法中的 age = " + a.age);
    }

    public static void main(String[] args) {
        TempTest t = new TempTest();
        A a = new A();
        a.age = 10;
        t.test1(a);
        System.out.println("main  方法中的 age = " + a.age);
    }
}

class A {
    public int age = 0;
}
