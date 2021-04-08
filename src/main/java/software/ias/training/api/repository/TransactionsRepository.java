package software.ias.training.api.repository;

import org.springframework.stereotype.Repository;
import software.ias.training.api.domain.BankTransaction;
import software.ias.training.api.test.Database;

import java.util.List;

@Repository
public class TransactionsRepository {
    private final Database database;

    // dependency inversion
    public TransactionsRepository(Database database) {
        this.database = database;
    }

    public void createBankTransaction(BankTransaction transaction) {
        database.insertData(transaction);
    }

    public void removeBankTransaction(int index){
        int size = listBankTransactions().size();
        if (index <= size) {
            listBankTransactions().remove(index);
            System.out.print("ok:200");
        } else {
            System.out.print("Error al borrar");
        }
    }

    public void updateBankTransaction(BankTransaction transaction, int index){
        int size = listBankTransactions().size();
        if (index <= size) {
            listBankTransactions().set(index, transaction);
            System.out.print("ok:200");
        } else {
            System.out.print("Error al actualizar");
        }

    }

    public List<Object> listBankTransactions() {
        return database.listData();
    }
}
