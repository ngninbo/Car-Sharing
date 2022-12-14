import java.lang.reflect.Field;

final class AccountUtils {

    private AccountUtils() { }

    public static void increaseBalance(Account account,
                                       long amount) throws IllegalAccessException, NoSuchFieldException {
        Field field = account.getClass().getDeclaredField("balance");
        field.setAccessible(true);
        field.set(account, field.getLong(account) + amount);
    }
}