package com.assignment.repositories;

import com.assignment.models.Bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BillRepositoryImpl implements BillRepository{
    private List<Bill> bills = new ArrayList<>();
    private static long idCounter = 0;
    @Override
    public Bill save(Bill bill) {
        if(bill.getId()==0)
            bill.setId(++idCounter);
        bills.add(bill);
        return bill;
    }

    @Override
    public Optional<Bill> findById(long billId) {
        return bills.stream().filter(bill -> bill.getId()==billId).findFirst();
    }
}
