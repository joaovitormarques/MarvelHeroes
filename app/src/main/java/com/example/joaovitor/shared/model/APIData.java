package com.example.joaovitor.shared.model;

import java.util.List;

/**
 * Created by joaovitor on 31/08/17.
 */

public class APIData<E> {
    public List<E> results;
    public int offset;
    public int limit;
    public int total;
    public int count;
}
