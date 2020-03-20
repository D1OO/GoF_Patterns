package net.shvdy;

/**
 * 20.03.2020
 *
 * @author Dmitriy Storozhenko
 * @version 1.0
 */
public class SingletonPattern {
    public static void main(String[] args) throws InterruptedException {

        final int SIZE = 1000;

        Thread t[] = new Thread[SIZE];

        for(int i=0; i<SIZE; i++){
            t[i] = new Thread(new R());
            t[i].start();
        }
        for(int i=0; i<SIZE; i++){
            t[i].join();
        }

        System.out.println(Singleton.counter);

    }
}
class R implements Runnable{

    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton{
    private static final Object sync = new Object();

    public static int counter = 0;
    private static volatile Singleton instance = null;
    private Singleton(){
        counter++;
    }
//	public Singleton getInstance(){
//		return instance;
//	}

    //	public static Singleton getInstance(){
//		if(instance == null){
//			instance = new Singleton();
//		}
//		return instance;
//	}
//	public static synchronized Singleton getInstance(){
//		if(instance == null){
//			instance = new Singleton();
//		}
//		return instance;
//	}
    public static Singleton getInstance(){
        if(instance == null){
            synchronized(sync){
                if(instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}
