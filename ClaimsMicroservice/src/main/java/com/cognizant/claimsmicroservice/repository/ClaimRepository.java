package com.cognizant.claimsmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.claimsmicroservice.model.Claim;
import com.cognizant.claimsmicroservice.model.ClaimStatusDTO;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {

	public List<ClaimStatusDTO> findByclaimId(Integer claimId);
}