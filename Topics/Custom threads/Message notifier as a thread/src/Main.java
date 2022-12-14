import java.util.stream.IntStream;

class MessageNotifier extends Thread {

    private final String message;
    private final int repeats;

    public MessageNotifier(String msg, int repeats) {
        super();
        this.message = msg;
        this.repeats = repeats;
    }

    @Override
    public void run() {
        IntStream.range(0, repeats)
                .mapToObj(i -> message)
                .forEach(System.out::println);
    }
}