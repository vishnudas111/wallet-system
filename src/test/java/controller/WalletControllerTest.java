package controller;

import wallet.system.contoller.WalletController;
import wallet.system.service.WalletService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {

    @Mock
    private WalletService walletService;

    @InjectMocks
    private WalletController walletController;

    // ✅ Test Deposit API
    @Test
    void testDeposit() {
        doNothing().when(walletService).deposit(1L, 500.0);

        ResponseEntity<String> response = walletController.deposit(1L, 500.0);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Deposit successful!", response.getBody());
    }

    // ✅ Test Withdraw API
    @Test
    void testWithdraw() {
        doNothing().when(walletService).withdraw(1L, 200.0);

        ResponseEntity<String> response = walletController.withdraw(1L, 200.0);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Withdrawal successful!", response.getBody());
    }

    // ✅ Test Check Balance API
    @Test
    void testCheckBalance() {
        when(walletService.checkBalance(1L)).thenReturn(1000.0);

        ResponseEntity<Double> response = walletController.checkBalance(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1000.0, response.getBody());
    }
}