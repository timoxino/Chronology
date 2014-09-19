package by.chronology.common.util;

/**
 * Contains different kind of util methods that help in case of working with Java Reflection API.
 *
 * @author Tsimafei_Shchytkavets
 */
public class ReflectionUtil
{
    public static final String JAVASSIST_CLASS_NAME_PART = "_$$_javassist";
    public static final String CGLIB_CLASS_NAME_PART = "$$EnhancerByCGLIB$$";

    public static boolean isClassEquals(Class<?> first, Class<?> second)
    {
        return getTargetClass(first).equals(getTargetClass(second));
    }

    private static Class<?> getTargetClass(Class<?> c1ass)
    {
        Class<?> targetClass = c1ass;
        while (isProxy(targetClass))
            targetClass = targetClass.getSuperclass();

        return targetClass;
    }

    private static boolean isProxy(Class<?> c1ass)
    {
        return (isJavassistProxy(c1ass) || isCglibProxy(c1ass));
    }

    private static boolean isJavassistProxy(Class<?> c1ass)
    {
        return c1ass.getName().indexOf(JAVASSIST_CLASS_NAME_PART) != -1;
    }

    private static boolean isCglibProxy(Class<?> c1ass)
    {
        return c1ass.getName().indexOf(CGLIB_CLASS_NAME_PART) != -1;
    }
}
