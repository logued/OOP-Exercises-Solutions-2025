package t10_design_patterns_1.examples.ex01;

public class Main {


    public static void main(String[] args) {

        TaskQueue taskQueue = new TaskQueue();

        taskQueue.submit(new ExecuteTaskCommand(new Task(), new ImmediateExecution()));
        taskQueue.submit(new ExecuteTaskCommand(new Task(), new ValidatedExecution()));

        taskQueue.processAll();
    }
}

