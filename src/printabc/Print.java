package printabc;

class Print{
    private Integer flag=1;
    private Integer count=0;

    public Integer getCount() {
        return count;
    }

    public synchronized void printA(){

        while (flag!=1){
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //1
        System.out.print(Thread.currentThread().getName());
        flag=2;

        notifyAll();
        count++;
    }
    public synchronized void printB(){
        while (flag!=2){
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2
        System.out.print(Thread.currentThread().getName());
        flag=3;
        notifyAll();
        count++;
    }
    public synchronized void printC(){
        while (flag!=3){
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //3
        System.out.print(Thread.currentThread().getName());
        flag=1;
        notifyAll();
        count++;
    }
}
class MyThread implements Runnable{
    private Print print;

    public MyThread(Print print) {
        this.print = print;
    }

    @Override
    public void run() {

        while (print.getCount()<13){
            if(Thread.currentThread().getName().equals("A")){
                print.printA();
            }else if(Thread.currentThread().getName().equals("B")){
                print.printB();
            }else if(Thread.currentThread().getName().equals("C")){
                print.printC();
            }
        }
    }
}
 class Test{
    public static void main(String[] args) {
        Print print=new Print();
        MyThread mt=new MyThread(print);
        Thread thread1=new Thread(mt,"A");
        Thread thread2=new Thread(mt,"B");
        Thread thread3=new Thread(mt,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}