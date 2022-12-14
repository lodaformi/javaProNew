package com.loda.controller;

import com.loda.dao.NoteDao;
import com.loda.service.NoteService;

/**
 * @Author loda
 * @Date 2022/11/11 21:12
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class NoteServlet {
    private NoteService noteService;

    private NoteDao noteDao;

    public NoteServlet(NoteService noteService, NoteDao noteDao) {
        this.noteService = noteService;
        this.noteDao = noteDao;
    }

    public void test() {
        System.out.println("NoteServlet test...");
        noteService.test();
        noteDao.test();
    }
}
