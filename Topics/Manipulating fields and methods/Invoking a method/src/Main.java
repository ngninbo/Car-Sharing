import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MethodsDemo {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        SomeClass obj = new SomeClass();
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.invoke(obj));
        }
    }
}