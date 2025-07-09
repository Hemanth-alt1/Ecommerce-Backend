package com.Online.Marketplace.Online.Marketplace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Online.Marketplace.Online.Marketplace.model.Wallet;
import com.Online.Marketplace.Online.Marketplace.repository.WalletRepository;
import com.Online.Marketplace.Online.Marketplace.service.WalletService;

@Service
public class WalletServiceimpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet getWallet(int user_id) {
        return walletRepository.findById(user_id).orElse(null);
    }

    @Override
    public Wallet updateWallet(int user_id, String action, int amount) {
        Wallet wallet = walletRepository.findById(user_id).orElse( walletRepository.save(new Wallet(user_id, 0)));

        if ("debit".equalsIgnoreCase(action)) {
            if (wallet.getBalance() < amount) {
                throw new RuntimeException("Insufficient balance");
            }
            wallet.setBalance(wallet.getBalance() - amount);
        } else if ("credit".equalsIgnoreCase(action)) {
            wallet.setBalance(wallet.getBalance() + amount);
        }

        return walletRepository.save(wallet);
    }

    @Override
    public void deleteWallet(int user_id) {
        walletRepository.deleteById(user_id);
    }

    @Override
    public void deleteAllWallets() {
        walletRepository.deleteAll();
    }
}
