import java.lang.reflect.*;

/**
 Get an array of fields the object declares that contain annotations (inherited fields should be skipped).
 */
class AnnotationsUtil {

    public static String[] getFieldsContainingAnnotations(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields())
                .filter(field -> field.getDeclaredAnnotations().length > 0)
                .map(Field::getName).toArray(String[]::new);
    }

}