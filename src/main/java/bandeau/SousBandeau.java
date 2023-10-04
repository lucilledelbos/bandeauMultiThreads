package bandeau;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SousBandeau extends Bandeau{
    private final Lock lock = new ReentrantLock();

    public void verrouille(){
        lock.lock();
    }
    public void deverrouille(){
        lock.unlock();
    }
}
