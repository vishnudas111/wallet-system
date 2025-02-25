package wallet.system.contoller;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam Long userId, @RequestParam double amount) {
        walletService.deposit(userId, amount);
        return ResponseEntity.ok("Deposit successful!");
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam Long userId, @RequestParam double amount) {
        walletService.withdraw(userId, amount);
        return ResponseEntity.ok("Withdrawal successful!");
    }

    @GetMapping("/balance/{userId}")
    public ResponseEntity<Double> checkBalance(@PathVariable Long userId) {
        return ResponseEntity.ok(walletService.checkBalance(userId));
    }
}

