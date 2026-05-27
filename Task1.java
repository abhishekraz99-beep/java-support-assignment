import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Handle null accounts list safely
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {

            // FIX: dueDate can be null for restructured accounts
            if (account.getDueDate() != null &&
                account.getDueDate().before(new Date())) {

                // Existing business logic preserved:
                // only overdue accounts with positive balance
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}
