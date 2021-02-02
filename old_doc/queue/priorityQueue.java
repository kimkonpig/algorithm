import java.util.PriorityQueue;

public class priorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(3);
        pq.add(2);
        pq.add(1);

        Integer poll = pq.poll();
        System.out.println(poll);
        //System.out.println("Hello World");
    }
}