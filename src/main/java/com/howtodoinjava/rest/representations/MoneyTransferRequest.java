package com.howtodoinjava.rest.representations;
import javax.annotation.Nonnegative;
import javax.validation.constraints.NotNull;
public class MoneyTransferRequest {

    @NotNull
    private Integer fromAccount;
    @NotNull
    private Integer toAccount;
    @Nonnegative
    private Integer amount;

    public Integer getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Integer fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Integer getToAccount() {
        return toAccount;
    }

    public void setToAccount(Integer toAccount) {
        this.toAccount = toAccount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
