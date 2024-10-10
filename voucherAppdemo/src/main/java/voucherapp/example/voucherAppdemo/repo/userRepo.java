package voucherapp.example.voucherAppdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import voucherapp.example.voucherAppdemo.model.User;

public interface userRepo extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
