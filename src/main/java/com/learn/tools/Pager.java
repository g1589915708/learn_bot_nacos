package com.learn.tools;

import lombok.Data;

import java.util.List;

@Data
public class Pager<T> {
    private int page;
    private int size;
    private List<T> result;
    private int total;
}
