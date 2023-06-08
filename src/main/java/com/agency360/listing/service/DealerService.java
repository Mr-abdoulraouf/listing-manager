package com.agency360.listing.service;

import com.agency360.listing.model.tables.pojos.Dealer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DealerService {

    List<Dealer> getAll();
    void save(Dealer dealer);

    Dealer update(Integer id, Dealer dealer);

    void delete(Integer id);
}
