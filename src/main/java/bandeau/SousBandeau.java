package bandeau;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SousBandeau extends Bandeau{
    private final Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private boolean iAmFree = true;
    private static int stickCount = 0;
    private final int myNumber ;


    public SousBandeau() {
        myNumber = ++stickCount;
    }

    public boolean tryScenario(int delay) throws InterruptedException {
        lock.lock();
        try{
            while (!iAmFree) {
                condition1.await();
            }
            iAmFree = false;
            // Pas utile de faire notifyAll ici, personne n'attend qu'elle soit occupée
            return true; // Succès
        }finally {
            lock.unlock();
        }
    }
}
