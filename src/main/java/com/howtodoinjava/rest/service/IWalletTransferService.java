package com.howtodoinjava.rest.service;

import javax.annotation.Nonnegative;

public interface IWalletTransferService {
    int getBalance(int id);
    void transferMoney(@Nonnegative int id1,@Nonnegative int amount,@Nonnegative int id2);

}
