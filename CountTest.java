package com.junit.progs;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountTest {

    @Test
    public void test() {

        JunitTesting test = new JunitTesting();
        int output = test.countA("alphabet");
        
        assertEquals(4, output);
    }

}
