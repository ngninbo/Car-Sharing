import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Version {
    String value();
}

@Version(value = "1.0")
class TestClass {
    public void myMethod() {
        // some code
    }
}