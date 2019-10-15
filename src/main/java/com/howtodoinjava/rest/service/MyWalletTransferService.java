package com.howtodoinjava.rest.service;

import com.howtodoinjava.rest.lockfactory.LockProvider;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class MyWalletTransferService implements IWalletTransferService{
    LockProvider lockProvider=new LockProvider();
    HashMap<Integer,Integer> balanceMap=new HashMap<>();
   public  MyWalletTransferService(){
        balanceMap.put(1000,100000);
    }

    @Override
    public int getBalance(int id) {
        Lock lock=lockProvider.getLock(id);
        int balance=-1;
        try{
        lock.lock();
        balance=balanceMap.getOrDefault(id,0);
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
        return balance;
    }

    @Override
    public void transferMoney(int id1, int amount, int id2) {
        Lock lock1=lockProvider.getLock(id1);
        Lock lock2=lockProvider.getLock(id2);
        Lock first,second;
        first=id1<id2?lock1:lock2;
        second=id1<id2?lock2:lock1;
       try{
           first.lock();
           second.lock();
          int m1= balanceMap.getOrDefault(id1,0);
          int m2=balanceMap.getOrDefault(id2,0);
          if(m1>=amount){
              balanceMap.put(id1,m1-amount);
              balanceMap.put(id2,m2+amount);
          }
       }catch (Exception e){
            e.printStackTrace();
       }finally {
           first.unlock();
           second.unlock();
       }
    }
}
