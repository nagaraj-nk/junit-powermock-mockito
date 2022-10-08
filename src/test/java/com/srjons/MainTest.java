package com.srjons;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.powermock.api.mockito.PowerMockito.*;

import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticClass.class})
public class MainTest {

    static ChildClass childClass;
    static ParentClass parentClass;

    @BeforeClass
    public static void init() {
        parentClass = PowerMockito.spy(new ParentClass());
        childClass = PowerMockito.spy(new ChildClass());
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
}