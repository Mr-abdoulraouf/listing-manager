package com.agency360.listing.service;

import com.agency360.listing.exception.ResourceNotFoundException;
import com.agency360.listing.model.tables.daos.DealerDao;
import com.agency360.listing.model.tables.pojos.Dealer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class DealerServiceImp implements DealerService{

    private final DealerDao dealerDao;
    @Override
    public List<Dealer> getAll() {
        return dealerDao.findAll();
    }

    @Override
    public void save(Dealer dealer) {
       dealerDao.insert(dealer);
    }

    @Override
    public Dealer update(Integer id, Dealer dealer) {
        Dealer dealerToUpdate = dealerDao.fetchOptionalById(id).orElseThrow(() -> new ResourceNotFoundException("Dealer not found with id: "+id));
        dealerToUpdate.setName(dealer.getName());
        dealerDao.update(dealerToUpdate);
        return dealer;
    }

    @Override
    public void delete(Integer id) {
        dealerDao.deleteById(id);
    }
}
