package com.lin.calculator;

/**
 * 定义操作符枚举
 */
public enum EnumOperator {
    ADD('+'),//加
    REDUCE('-'),//减
    MULTIPLY('*'),//乘
    DIVISION('/')//除
    ;

    EnumOperator(char symbol) {
        this.symbol = symbol;
    }

    private char symbol;

    public char getSymbol() {
        return this.symbol;
    }
}
