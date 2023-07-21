package com.paul.controller;

import com.paul.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {

    @Autowired
    MyBookListService myBookListService;

    @RequestMapping("/deleteMyBook/{id}")
    public String deleteMyId(@PathVariable("id") int id) {
        myBookListService.deleteById(id);
        return "redirect:/my_books";
    }

}
