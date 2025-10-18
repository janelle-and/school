import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class queueDemo {
    public static void main(String[] args) {
        // linked list queue

        Queue<String> queue = new LinkedList<>();

        queue.offer("Alice");
        queue.offer("Bob");
        queue.offer("Carol");
        System.out.println(queue);

        // First Element
        System.out.println(queue.peek());

        // Remove Element
        queue.remove();
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);

        // Empty or Not
        System.out.println("Is the list empty? " + queue.isEmpty());

        // Size
        System.out.println("Size: " + queue.size());



        // Priority queue
        System.out.println("\nPriority Queues");

        Queue<Integer> pq = new PriorityQueue<>();

        pq.offer(50);
        pq.offer(20);
        pq.offer(10);
        pq.offer(80);

        System.out.println(pq);

        // first element
        System.out.println(pq.peek());

        // Remove element
        System.out.println(pq.poll());
        System.out.println(pq);



        // Array Dequeue

        System.out.println("\nArrayDeque");

//        Queue<String> q = new ArrayDeque<>();
        ArrayDeque q = new ArrayDeque<>();

        q.offer("Alice");
        q.offer("Bob");
        q.offer("Charlie");

        System.out.println(q);

        // Add First
//        ((ArrayDequeue) q).offerFirst("");
        q.offerFirst("Sam");
        System.out.println(q);

        // Add Last
        q.offerLast("Tom");
        System.out.println(q);

        // Remove
        q.removeFirst();
        System.out.println(q);

        q.removeLast();
        System.out.println(q);


    }
}
