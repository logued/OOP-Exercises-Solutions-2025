package t10_design_patterns_1.examples.ex01;

public final class ExecuteTaskCommand implements Command {

    private final Task _task;
    private final TaskExecutionStrategy _strategy;

    public ExecuteTaskCommand(Task task, TaskExecutionStrategy strategy) {
        _task = task;
        _strategy = strategy;
    }

    @Override
    public void execute() {
        _strategy.execute(_task);
    }
}