package com.howtodoinjava.rest.lockfactory;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockProvider {
    HashMap<Integer,Lock>map=new HashMap<>();
    public Lock getLock(int id){
        if(!map.containsKey(id))
           map.put(id,new ReentrantLock());
        return map.get(id);
    }
}
