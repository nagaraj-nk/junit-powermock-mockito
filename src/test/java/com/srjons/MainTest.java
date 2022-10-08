package com.srjons;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticClass.class})
public class MainTest {

    @InjectMocks
    ChildClass childClass;

    ParentClass parentClass;
    DatabaseRepo databaseRepo;

    @Before
    public void init() {
        databaseRepo = PowerMockito.spy(new DatabaseRepo());
        parentClass = PowerMockito.spy(new ParentClass());
        childClass = PowerMockito.spy(new ChildClass());
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_DatabaseLayer() {
        Mockito.doReturn(List.of("apple", "banana")).when(databaseRepo).findItems();
        //when(databaseRepo.findItems()).thenReturn(List.of("apple", "banana"));
        List<String> all = childClass.findAll();
        System.out.println("all = " + all);
    }

    @Test
    public void test_staticMethod() {
        PowerMockito.mockStatic(StaticClass.class);
        when(StaticClass.someStaticMethod()).thenReturn("Hello");
        String actual = StaticClass.someStaticMethod();
        Assert.assertEquals("Hello", actual);
    }

    @Test
    public void test_protectedMethod() throws Exception {
        doReturn("hi").when(childClass, "parentMethod");
        String actual = childClass.childMethod();
        Assert.assertEquals("hi", actual);
    }

    @Test
    public void test_privateMethod() throws Exception {
        doReturn("hi-privateMethod").when(childClass, "privateMethod");
        String actual = childClass.someTestForPrivateMethod();
        Assert.assertEquals("hi-privateMethod", actual);
    }


}