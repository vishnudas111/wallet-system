package service;

import wallet.system.entity.Transaction;
import wallet.system.entity.User;
import wallet.system.repository.TransactionRepository;
import wallet.system.repository.UserRepository;
import wallet.system.service.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class WalletServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private WalletService walletService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setBalance(1000.0);
    }

    // Test Deposit Money
    @Test
    void testDeposit_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        walletService.deposit(1L, 500.0);

        assertEquals(1500.0, user.getBalance());
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    // Test Withdraw Money Successfully
    @Test
    void testWithdraw_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        walletService.withdraw(1L, 200.0);

        assertEquals(800.0, user.getBalance());
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    // Test Withdrawal with Insufficient Balance
    @Test
    void testWithdraw_Failure_InsufficientBalance() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            walletService.withdraw(1L, 2000.0);
        });

        assertEquals("Insufficient funds", exception.getMessage());
        verify(transactionRepository, never()).save(any(Transaction.class));
    }

    // Test Check Balance
    @Test
    void testCheckBalance_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        double balance = walletService.checkBalance(1L);

        assertEquals(1000.0, balance);
    }

    // Test User Not Found Exception
    @Test
    void testUserNotFoundException() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            walletService.checkBalance(99L);
        });

        assertEquals("User not found", exception.getMessage());
    }
}