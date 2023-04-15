package com.lin.calculator;

import java.util.concurrent.atomic.AtomicLong;

public class TxSequence {
    private AtomicLong id = new AtomicLong(0);

    public long next() {
        return id.incrementAndGet();
    }
}
