package by.chronology.common.util;

import javassist.util.proxy.ProxyFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReflectionUtilTest
{
    @Test
    public void isClassEquals()
    {
        assertThat("Classes should be equal", ReflectionUtil.isClassEquals(Child.class, Child.class), is(true));
        assertThat("Classes shouldn't be equal", ReflectionUtil.isClassEquals(Child.class, Parent.class), is(false));
    }

    @Test
    public void isClassEqualsJavassist()
    {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(Child.class);
        assertThat("Classes should be equal", ReflectionUtil.isClassEquals(Child.class, factory.createClass()), is(true));
        assertThat("Classes shouldn't be equal", ReflectionUtil.isClassEquals(Parent.class, factory.createClass()), is(false));
    }

    @Test
    public void isClassEqualsCglib()
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Child.class);
        enhancer.setCallbackTypes(new Class[] { NoOp.class });
        assertThat("Classes should be equal", ReflectionUtil.isClassEquals(Child.class, enhancer.createClass()), is(true));
        assertThat("Classes shouldn't be equal", ReflectionUtil.isClassEquals(Parent.class, enhancer.createClass()), is(false));
    }

    private class Parent
    {
    }

    private class Child extends Parent
    {
        public Child()
        {
        }
    }
}