package ProductApp.example.ProductApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ProductApp.example.ProductApp.dto.Voucher;
import ProductApp.example.ProductApp.model.product;
import ProductApp.example.ProductApp.repo.productRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/productApi")
public class productController {
    
    @Autowired
    productRepo repo ;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${voucherService.url}")
    private String voucherServiceURL;

    @GetMapping("/products/{id}")
    public product getProductById(@PathVariable("id") Long id){
        return repo.findById(id).get();
    }
    
    @PostMapping("/products")
    public product Create(@RequestBody product product) {

        Voucher voucher = restTemplate.getForObject(voucherServiceURL + product.getVoucherCode(), Voucher.class);

        product.setPrice(product.getPrice().subtract(voucher.getDiscount()));

        return repo.save(product);
    }
    
}
