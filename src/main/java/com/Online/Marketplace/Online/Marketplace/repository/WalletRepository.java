package com.Online.Marketplace.Online.Marketplace.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Online.Marketplace.Online.Marketplace.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
   
}
