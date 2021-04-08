package software.ias.training.api.controller;

import org.springframework.web.bind.annotation.*;
import software.ias.training.api.domain.BankTransaction;
import software.ias.training.api.repository.TransactionsRepository;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class BankTransactionsController {
    private final TransactionsRepository repository;

    public BankTransactionsController(TransactionsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Object> listTransactions() {
        return repository.listBankTransactions();
    }

    @PostMapping("/post-transaction")
    public void createTransaction(@RequestBody BankTransaction transaction) {
        repository.createBankTransaction(transaction);
    }

    @PutMapping("/update-transaction")
    public void updateTransaction(@RequestBody BankTransaction transaction, @RequestParam int index) {
        repository.updateBankTransaction(transaction, index);
    }

    @DeleteMapping("/remove-transaction")
    public void removeTransaction(@RequestParam int index) {
        repository.removeBankTransaction(index);
    }
}
