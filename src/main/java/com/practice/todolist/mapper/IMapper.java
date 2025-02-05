package com.practice.todolist.mapper;

import java.util.Map;

public interface IMapper <I, O> {

    public O map(I in);
}
