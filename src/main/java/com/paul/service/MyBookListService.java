package com.paul.service;

import com.paul.entity.MyBookList;
import com.paul.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBook(MyBookList myBookList) {
        myBookRepository.save(myBookList);
    }

    public List<MyBookList> getMyBookLists() {
        return myBookRepository.findAll();
    }

    public void deleteById(int id) {
        myBookRepository.deleteById(id);
    }
}
