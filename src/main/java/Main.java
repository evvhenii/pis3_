import dao.receipt.ReceiptDao;
import dao.receipt.impl.ReceiptJpaImpl;
import entity.Receipt;
import entity.ReceiptEntry;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("receipt");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ReceiptDao receiptDao = new ReceiptJpaImpl(entityManager);

        List<ReceiptEntry> receiptEntryList = new ArrayList<>();
        for (long i = 0; i < 5; i++) {
            receiptEntryList.add(ReceiptEntry.builder()
                    .productId(i)
                    .quantity(10)
                    .sum(10 * i)
                    .build());
        }

        Receipt receipt = Receipt.builder()
                .cashierId(55L)
                .dateTime(new Date(System.currentTimeMillis()))
                .totalPrice(551L)
                .entries(receiptEntryList)
                .build();
        receiptDao.save(receipt);

        Receipt specificReceipt = receiptDao.findById(15L);
        System.out.println("This is a specific receipt " + specificReceipt);
//        System.out.println("These are all available receipts:");
//        receiptDao.findAll().stream().forEach(System.out::println);

    }
}
