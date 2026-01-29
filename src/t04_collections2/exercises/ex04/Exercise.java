package t04_collections2.exercises.ex04;

import java.util.Deque;
import java.util.LinkedList;

public final class Exercise {

    public static void run() {
        System.out.println("ex04 started");

        // Using a Deque (Double-Ended Queue) Interface to access a LinkedList implementation.
        Deque<String> jobsQueue = new LinkedList<>();
        jobsQueue.offer("build");      // enqueue (tail) - add at end/tail of queue
        jobsQueue.offer("test");       // " 'offer' an element to add to the tail of the queue"
        jobsQueue.offer("package");
        jobsQueue.offer("deploy");

        // The normal(or pure) use of a Queue is to add elements at the tail (end) and remove
        // elements from the head (front) ONLY. (like a queue in a coffee shop)

        // Dequeue element-by-element from front to end of queue (FIFO order)
        while (!jobsQueue.isEmpty()) {
            String job = jobsQueue.poll();  // removes from front of queue
            System.out.print(job + ", ");
        }
        System.out.println();

        // Reset the Deque with values.
        jobsQueue.offer("build");
        jobsQueue.offer("test");
        jobsQueue.offer("package");
        jobsQueue.offer("deploy");

        // This time we make use of the Deque features so that we
        // can insert values at the front of the queue also.
        // We will insert a "lint" job after "test"

        // remove jobs from head of queue
        while (!jobsQueue.isEmpty()) {
            String job = jobsQueue.poll();  // removes from front of queue
            if (job.equals("test")) {
                break;
            }
        }

        // push in jobs at front of queue (in reverse order)
        jobsQueue.offerFirst ("lint");
        jobsQueue.offerFirst ("test");
        jobsQueue.offerFirst ("build");

        // remove elements element-by-element from front to end of queue (FIFO order)
        while (!jobsQueue.isEmpty()) {
            String job = jobsQueue.poll();  // removes from front of queue
            System.out.print(job + ", ");
        }
    }
}

//Exercise 04 — A small job queue (Software Dev)
//What you’ll practice: Using a Deque<String> as a FIFO queue.
//        Why this matters: Queues appear everywhere (build pipelines, server tasks).
//
//Scenario: Jobs arrive in this order: "build", "test", "package", "deploy".
//
//Task: Enqueue with offer(...), process with poll(). After you dequeue "test", insert a "lint" job immediately after it (simulating a pipeline rule change).
//
//Steps:
//
//Use Deque<String> q = new LinkedList<>(); then offer(...) jobs.
//Process in a loop: take String job = q.poll(); and print it.
//Right after you process "test", insert "lint" using a ListIterator positioned at the current spot.
    ///  lack of clarity in question here - not possible to get a ListIterator on a Deque ?
//Finish processing and print the final order you executed.
//Quick check: Execution order shows "build" → "test" → "lint" → "package" → "deploy".
//Hint: Prefer offer/poll/peek (return null on empty) over add/remove/element (throw exceptions).


