package com.example.joaovitor.shared.model;

/**
 * Created by joaovitor on 31/08/17.
 */

public class APIAnswer<E> {
    public int code;
    public String status;
    public APIData<E> data;
}
