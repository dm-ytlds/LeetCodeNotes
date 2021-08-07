public class NThread {
    int j = 1;

    public synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    class T1 implements Runnable {
        public void run() {
            inc();
        }
    }

    public synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }

    class T11 implements Runnable {
        public void run() {
            dec();
        }
    }

    public static void main(String[] args) {
        NThread t = new NThread();
        T1 t1 = t.new T1();
        T11 t11 = t.new T11();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(t1);
            thread.start();
            Thread thread1 = new Thread(t11);
            thread1.start();
        }
    }
}

