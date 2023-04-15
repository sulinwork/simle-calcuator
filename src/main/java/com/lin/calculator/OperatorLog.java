package com.lin.calculator;

import java.math.BigDecimal;

/**
 * 记录操作日志
 */
public class OperatorLog {

    private long txId;

    //操作前的值
    private BigDecimal after;

    //操作后的值
    private BigDecimal before;

    //操作符
    private EnumOperator operator;

    //操作数
    private BigDecimal operatorNum;


    //下一个操作日志指针
    private OperatorLog next;
    //上一个操作日志指针
    private OperatorLog pre;


    @Override
    public String toString() {
        return String.format("txId:[%s],log:%s %s %s = %s", txId, before.toString(), operator.getSymbol(), operatorNum.toString(), after.toString());
    }

    public long getTxId() {
        return txId;
    }

    public void setTxId(long txId) {
        this.txId = txId;
    }

    public BigDecimal getAfter() {
        return after;
    }

    public void setAfter(BigDecimal after) {
        this.after = after;
    }

    public BigDecimal getBefore() {
        return before;
    }

    public void setBefore(BigDecimal before) {
        this.before = before;
    }

    public EnumOperator getOperator() {
        return operator;
    }

    public void setOperator(EnumOperator operator) {
        this.operator = operator;
    }

    public BigDecimal getOperatorNum() {
        return operatorNum;
    }

    public void setOperatorNum(BigDecimal operatorNum) {
        this.operatorNum = operatorNum;
    }

    public OperatorLog getNext() {
        return next;
    }

    public void setNext(OperatorLog next) {
        this.next = next;
    }

    public OperatorLog getPre() {
        return pre;
    }

    public void setPre(OperatorLog pre) {
        this.pre = pre;
    }
}
