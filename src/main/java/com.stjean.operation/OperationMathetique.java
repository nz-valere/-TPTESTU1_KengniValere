package com.stjean.operation;

import java.util.Arrays;
import java.util.Collections;

public class OperationMathetique {
    public boolean estPositif(int nombre) {
        return nombre > 0;
    }

    public int factorial(int nombre) {
        if (nombre < 0) {
            throw new IllegalParamISIException("Number must be non-negative.");
        }
        int result = 1;
        for (int i = 1; i <= nombre; i++) {
            result *= i;
        }
        return result;
    }


    public Integer[] sort(Integer[] lists) {
        Arrays.sort(lists, Collections.reverseOrder());
        return lists;
    }

    public double maxNumba(double[] values) {
        double max = Double.NEGATIVE_INFINITY;
        for (double value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }


}
