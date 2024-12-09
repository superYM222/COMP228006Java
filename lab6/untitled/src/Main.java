import account.Account;
import transaction.Transaction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Account account = new Account(1000);


        Queue<Transaction> transactionQueue = new LinkedList<>();
        transactionQueue.add(new Transaction(account, true, 400));
        transactionQueue.add(new Transaction(account, false, 300));
        transactionQueue.add(new Transaction(account, true, 500));
        transactionQueue.add(new Transaction(account, false, 700));
        transactionQueue.add(new Transaction(account, true, 900));
        transactionQueue.add(new Transaction(account, false, 1900));
        transactionQueue.add(new Transaction(account, true, 10002));


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        while (!transactionQueue.isEmpty()) {
            executorService.execute(transactionQueue.poll());
        }

        executorService.shutdown();
        System.out.printf("Tasks started, main ends %n%n");
    }
}
