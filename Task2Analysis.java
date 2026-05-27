public class Task2Analysis {

    // 1. What is the exact cause of ConcurrentModificationException in Java?
    // ConcurrentModificationException occurs when a collection is modified
    // structurally while it is being iterated using an Iterator or enhanced for-loop.

    // 2. What code pattern at line 142 most likely triggered this error?

    // for (Transaction t : transactions) {
    //     if (condition) {
    //         transactions.remove(t);
    //     }
    // }

    // 3. Provide the minimal code change that resolves this safely.

    // Iterator<Transaction> itr = transactions.iterator();
    // while (itr.hasNext()) {
    //     Transaction t = itr.next();
    //     if (condition) {
    //         itr.remove();
    //     }
    // }
}
