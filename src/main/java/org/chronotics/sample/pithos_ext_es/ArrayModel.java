package org.chronotics.sample.pithos_ext_es;

import java.util.List;
import java.util.Set;

public class ArrayModel {
    List<String> arr_str;
    Set<Double> arr_double;
    int[] arr_int;

    public List<String> getArr_str() {
        return arr_str;
    }

    public void setArr_str(List<String> arr_str) {
        this.arr_str = arr_str;
    }

    public Set<Double> getArr_double() {
        return arr_double;
    }

    public void setArr_double(Set<Double> arr_double) {
        this.arr_double = arr_double;
    }

    public int[] getArr_int() {
        return arr_int;
    }

    public void setArr_int(int[] arr_int) {
        this.arr_int = arr_int;
    }
}
