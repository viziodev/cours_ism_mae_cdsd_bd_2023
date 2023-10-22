package com.ism.repositories;

import java.util.ArrayList;

public interface Repository<T> {
     int insert(T data);
     ArrayList<T> findAll();
}
