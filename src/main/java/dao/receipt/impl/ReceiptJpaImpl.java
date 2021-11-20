package dao.receipt.impl;

import dao.receipt.ReceiptDao;
import entity.Receipt;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReceiptJpaImpl implements ReceiptDao {
    private final EntityManager em;

    @Override
    public void save(Receipt receipt) {
        em.getTransaction().begin();
        em.persist(receipt);
        receipt.getEntries().stream()
                .forEach(re -> re.setReceipt(receipt));
        receipt.getEntries().stream()
                .forEach(em::persist);
        em.getTransaction().commit();
    }

    @Override
    public List<Receipt> findAll() {
        return em.createQuery("select r from Receipt r").getResultList();
    }

    public Receipt findById(Long id) {
        Receipt receipt = em.find(Receipt.class, Long.valueOf(id));

        em.createQuery("select r from Receipt r join r.entries where r.id=:id", Receipt.class)
                        .setParameter("id", id)
                                .getResultList();

        em.detach(receipt);
        return receipt;
    }
}
