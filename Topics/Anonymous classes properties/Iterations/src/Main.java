
class IteratorExecutor {

    static void performIterationsWithCallback(int numberOfIterations, LoopCallback callback) {
        for (int i = 0; i < numberOfIterations; i++) {
            callback.onNewIteration(i);
        }
    }

    static void startIterations(int numberOfIterations) {
        // invoke the method performIterationsWithCallback here
        performIterationsWithCallback(numberOfIterations, iteration -> System.out.printf("Iteration: %s\n", iteration));
    }
}

// Don't change the code below
interface LoopCallback {

    void onNewIteration(int iteration);
}