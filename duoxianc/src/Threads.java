public class Threads extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
//            try{
//                Thread.sleep(500);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
            Thread.yield();
            System.out.println(Thread.currentThread().getName()+"="+i);
        }
    }
}
