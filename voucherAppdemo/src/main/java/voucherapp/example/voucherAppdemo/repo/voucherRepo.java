package voucherapp.example.voucherAppdemo.repo;
import voucherapp.example.voucherAppdemo.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface voucherRepo extends JpaRepository<Voucher, Long> {

    Voucher findByCode(String code);
}
