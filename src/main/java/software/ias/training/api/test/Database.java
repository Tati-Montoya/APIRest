package software.ias.training.api.test;

import org.springframework.stereotype.Component;
import software.ias.training.api.domain.BankTransaction;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Database {
    private final List<Object> data = new ArrayList<>();

    public void insertData(Object item) {
        data.add(item);
    }

    public List<Object> listData() {
        return data;
    }


    @PostConstruct
    public void init() {
        data.add(
                new BankTransaction(LocalDate.now(), 100, "coffee")
        );

        data.add(
                new BankTransaction(LocalDate.now(), 150, "water")
        );
    }
}
