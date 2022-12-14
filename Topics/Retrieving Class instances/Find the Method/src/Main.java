import java.util.Arrays;

class MethodFinder {

    public static String findMethod(String methodName, String[] classNames) throws ClassNotFoundException {

        String result = null;
        for (String className: classNames) {
            if (hasMethod(className, methodName)) {
                result = className;
            }
        }

        return Class.forName(result).getName();
    }

    private static boolean hasMethod(String className, String methodName) throws ClassNotFoundException {
        return Arrays.stream(Class.forName(className).getMethods())
                .anyMatch(method -> methodName.equals(method.getName()));
    }
}