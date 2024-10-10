package voucherapp.example.voucherAppdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import voucherapp.example.voucherAppdemo.model.Roles;

public interface roleRepo  extends JpaRepository<Roles , Long>{
    
}
