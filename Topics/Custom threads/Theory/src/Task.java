// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) throws InterruptedException {
    MyThread t1 = new MyThread();
    t1.setName("My-thread-1");
    t1.start();

    t1.join();

    MyThread t2 = new MyThread();
    t2.setName("My-thread-2");
    t2.start();

    System.out.println("output-1");

    t2.join();

    System.out.println("output-2");
  }
}


class MyThread extends Thread {

  @Override
  public void run() {
    System.out.println("Hello from " + getName());
  }
}
