package com.basic.thread.sync;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaeldungSynchronizedMethods {
	
	private int sum = 0;

    public void calculate() {
        setSum(getSum() + 1);
    }
	
}
