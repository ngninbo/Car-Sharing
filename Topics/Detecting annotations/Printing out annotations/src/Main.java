import java.lang.annotation.Annotation;
import java.util.Arrays;

class AnnotationUtils {

    public static void printClassAnnotations(Class classObject) {
        Arrays.stream(classObject.getDeclaredAnnotations())
                .map(annotation -> annotation.annotationType().getSimpleName())
                .map(s -> s.replace("@", ""))
                .forEach(System.out::println);
    }

}