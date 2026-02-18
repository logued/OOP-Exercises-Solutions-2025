package t10_design_patterns_1.examples.ex01;

import java.util.ArrayDeque;
import java.util.Queue;

public final class TaskQueue {

    private final Queue<Command> _queue = new ArrayDeque<>();

    public void submit(Command command) {
        _queue.add(command);
    }

    public void processAll() {
        while ( !_queue.isEmpty() ) {

            _queue.poll().execute();
        }
    }
}