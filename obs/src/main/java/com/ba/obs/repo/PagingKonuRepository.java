package com.ba.obs.repo;

import com.ba.obs.model.Konu;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagingKonuRepository extends PagingAndSortingRepository<Konu, Integer>
{
}