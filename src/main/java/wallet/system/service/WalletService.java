package wallet.system.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wallet.system.entity.Transaction;
import wallet.system.helper.TransactionType;
import wallet.system.entity.User;
import wallet.system.repository.TransactionRepository;
import wallet.system.repository.UserRepository;

@Service
public class WalletService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void deposit(Long userId, double amount) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setBalance(user.getBalance() + amount);
        userRepository.save(user);

        Transaction txn = new Transaction();
        txn.setUserId(userId);
        txn.setAmount(amount);
        txn.setType(TransactionType.DEPOSIT);
        transactionRepository.save(txn);
    }

    @Transactional
    public void withdraw(Long userId, double amount) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        user.setBalance(user.getBalance() - amount);
        userRepository.save(user);

        Transaction txn = new Transaction();
        txn.setUserId(userId);
        txn.setAmount(amount);
        txn.setType(TransactionType.WITHDRAWAL);
        transactionRepository.save(txn);
    }

    public double checkBalance(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getBalance();
    }
}

