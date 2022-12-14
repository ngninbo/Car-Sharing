import java.lang.reflect.Modifier;
import java.util.Arrays;

class ReflectionUtils {

    public static int countPublicMethods(Class targetClass) {
        return (int) Arrays.stream(targetClass.getDeclaredMethods())
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .count();
    }
}