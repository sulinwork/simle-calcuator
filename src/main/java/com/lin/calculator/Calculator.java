package com.lin.calculator;

import java.math.BigDecimal;

public class Calculator {

    private TxSequence txIdSequence = new TxSequence();

    private OperatorLog headLog = null;
    private OperatorLog operatorLog = null;

    private BigDecimal result = null;


    public Calculator(BigDecimal init) {
        this.result = init;
    }


    public BigDecimal calc(EnumOperator operator, int optNum) {
        return calc(operator, new BigDecimal(optNum));
    }

    public BigDecimal calc(EnumOperator operator, BigDecimal optNum) {
        OperatorLog log = new OperatorLog();
        log.setBefore(result);
        log.setTxId(txIdSequence.next());
        log.setOperator(operator);
        log.setOperatorNum(optNum);
        switch (operator) {
            case ADD:
                result = result.add(optNum);
                break;
            case REDUCE:
                result = result.subtract(optNum);
                break;
            case DIVISION:
                result = result.divide(optNum, 4, BigDecimal.ROUND_HALF_UP);
                break;
            case MULTIPLY:
                result = result.multiply(optNum);
                break;
        }
        log.setAfter(result);
        System.out.println(log);
        appendLog(log);
        return result;
    }

    private void appendLog(OperatorLog log) {
        if (operatorLog != null) {
            operatorLog.setNext(log);
            log.setPre(operatorLog);
        }
        operatorLog = log;
        if (headLog == null) {
            headLog = log;
        }
    }


    public void undo() {
        if (operatorLog == null || operatorLog.getPre() == null) {
            System.out.println("已经到第一步了，无法执行undo");
            return;
        }
        operatorLog = operatorLog.getPre();
        result = operatorLog.getAfter();
        System.out.println("执行undo操作!恢复到：" + operatorLog);
    }


    public void redo() {
        if (operatorLog == null || operatorLog.getNext() == null) {
            System.out.println("已经是最后一步了，无法执行redo");
            return;
        }
        operatorLog = operatorLog.getNext();
        result = operatorLog.getAfter();
        System.out.println("执行redo操作!恢复到：" + operatorLog);
    }

    public void showLog() {
        System.out.println("========显示所有的操作日志=============");
        if (headLog != null) {
            OperatorLog tempLog = headLog;
            while (tempLog != null) {
                System.out.println(tempLog);
                tempLog = tempLog.getNext();
            }
        }
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator(new BigDecimal(0));
        calculator.calc(EnumOperator.ADD, new BigDecimal(10));
        calculator.calc(EnumOperator.MULTIPLY, new BigDecimal(5));
        calculator.calc(EnumOperator.REDUCE, new BigDecimal(5));
        calculator.undo();
        calculator.undo();
        calculator.calc(EnumOperator.MULTIPLY, 5);
        calculator.redo();
        calculator.calc(EnumOperator.ADD, 5);
        calculator.showLog();
    }


}
