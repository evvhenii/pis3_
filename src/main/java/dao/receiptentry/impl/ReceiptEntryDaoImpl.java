package dao.receiptentry.impl;

import dao.receiptentry.ReceiptEntryDao;
import entity.Product;
import entity.Receipt;
import entity.ReceiptEntry;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReceiptEntryDaoImpl implements ReceiptEntryDao {

    @Override
    public void save(ReceiptEntry receiptEntry) {

    }

    @Override
    public List<ReceiptEntry> findAll() {
        return null;
    }

    public ReceiptEntry findById(Long id) {
        return null;
    }
}
