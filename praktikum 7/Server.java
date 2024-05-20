import java.util.ArrayList;
import java.util.List;

public class Server {
    // nWorkers menyatakan jumlah maksimum threads yang tersedia pada server a.k.a thread pool
    private int workers;

    Server(int workers) {
        this.workers = workers;
    }

    public Integer[] process(String[] requests) throws InterruptedException {
        // List to keep track of threads
        List<Thread> threads = new ArrayList<>();
        // Array to store the word counts
        Integer[] results = new Integer[requests.length];

        // Create a runnable class to process requests
        class RequestProcessor implements Runnable {
            private int index;

            RequestProcessor(int index) {
                this.index = index;
            }

            @Override
            public void run() {
                results[index] = count(requests[index]);
            }
        }

        // Create and start threads
        for (int i = 0; i < requests.length; i++) {
            Thread thread = new Thread(new RequestProcessor(i));
            threads.add(thread);
            thread.start();

            // If we've reached the maximum number of workers, wait for threads to complete
            if (threads.size() == workers) {
                for (Thread t : threads) {
                    t.join();
                }
                // Clear the list to reuse it
                threads.clear();
            }
        }

        // Wait for any remaining threads to complete
        for (Thread t : threads) {
            t.join();
        }

        return results;
    }

    protected int count(String request) {
        if (request == null || request.isEmpty()) {
            return 0;
        }
        // Split the request by spaces and return the length of the resulting array
        String[] words = request.split("\\s+");
        return words.length;
    }

    // Driver code for testing
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server(3);
        String[] requests = {"This is a test", "Another test", "Hello World", "Java programming"};
        Integer[] results = server.process(requests);

        for (int result : results) {
            System.out.println(result);
        }
    }
}
