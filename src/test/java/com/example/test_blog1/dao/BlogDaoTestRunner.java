package com.example.test_blog1.dao;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import org.junit.runner.Result;

public class BlogDaoTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(com.example.test_blog1.dao.BlogDao.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
