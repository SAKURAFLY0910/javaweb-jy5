public class test {
    public static void main(String[] args) {
        Threads s=new Threads();
        Threads2 v=new Threads2();

        Thread ss=new Thread(v,"No.2");
        s.setDaemon(true);
        s.setName("No.1");

//
//        s.setPriority(10);

        s.start();

//        try {
//            s.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ss.start();
//              try {
//            Thread.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ss.stop();
//        ss.interrupt();


    }
}
