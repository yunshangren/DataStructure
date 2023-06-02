package solution12;

/**
 * @author Acer
 * @create 2023/5/25 16:28
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.run();
        Thread.sleep(5000);
        thread.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("run ...");
    }
}
