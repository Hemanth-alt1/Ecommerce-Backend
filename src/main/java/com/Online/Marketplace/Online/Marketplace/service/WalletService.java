package com.Online.Marketplace.Online.Marketplace.service;

import com.Online.Marketplace.Online.Marketplace.model.Wallet;

public interface WalletService {
   public Wallet getWallet(int user_id);
   public Wallet updateWallet(int user_id, String action, int amount);
    void deleteWallet(int user_id);
    void deleteAllWallets();
}