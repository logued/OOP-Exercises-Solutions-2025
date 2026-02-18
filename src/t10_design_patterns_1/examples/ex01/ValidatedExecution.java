package t10_design_patterns_1.examples.ex01;

public final class ValidatedExecution implements TaskExecutionStrategy {
    @Override
    public void execute(Task task) {
        task.validate();
        task.run();
    }
}