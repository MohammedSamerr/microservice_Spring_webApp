package voucherapp.example.voucherAppdemo.controller;

import voucherapp.example.voucherAppdemo.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voucherapp.example.voucherAppdemo.repo.voucherRepo;

@RestController
@RequestMapping("/voucherApi")
public class voucherController {

    @Autowired
    voucherRepo repo;

    @PostMapping("/vouchers")
    public Voucher crete(@RequestBody Voucher voucher ){
            return repo.save(voucher);
    }

    @GetMapping("/vouchers/{code}")
    public Voucher getVoucher(@PathVariable("code") String code){
        return repo.findByCode(code);
    }


}
