package com.Online.Marketplace.Online.Marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Online.Marketplace.Online.Marketplace.model.Wallet;
import com.Online.Marketplace.Online.Marketplace.service.WalletService;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/{user_id}")
    public Wallet getWallet(@PathVariable int user_id) {
        Wallet wallet = walletService.getWallet(user_id);
        if (wallet == null) {
            throw new RuntimeException("Wallet not found");
        }
        return wallet;
    }

    @PutMapping("/{user_id}")
    public Wallet updateWallet(@PathVariable int user_id, @RequestBody WalletAction action) {
        return walletService.updateWallet(user_id, action.getAction(), action.getAmount());
    }

    @DeleteMapping("/{user_id}")
    public void deleteWallet(@PathVariable int user_id) {
        walletService.deleteWallet(user_id);
    }

    @DeleteMapping
    public void deleteAllWallets() {
        walletService.deleteAllWallets();
    }
    static class WalletAction {
        private String action;
        private int amount;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
