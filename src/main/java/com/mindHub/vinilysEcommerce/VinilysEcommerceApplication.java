package com.mindHub.vinilysEcommerce;

import com.mindHub.vinilysEcommerce.models.*;
import com.mindHub.vinilysEcommerce.repositories.BillRepository;
import com.mindHub.vinilysEcommerce.repositories.ClientRepository;
import com.mindHub.vinilysEcommerce.repositories.ProductBillRepository;
import com.mindHub.vinilysEcommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class VinilysEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinilysEcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, ProductRepository productRepository, BillRepository billRepository, ProductBillRepository productBillRepository) {
		return (args) -> {

			Client client1 = new Client("Facu","Araujo", "facu@mindhub.com", passwordEncoder.encode("123"), true);
			clientRepository.save(client1);

			Product product1 = new Product("Fine Line", "Harry Styles","asdfasdfasdfasd" ,"2019", List.of( "https://i.pinimg.com/736x/d2/43/5c/d2435c7f07cb296e3a5b51518e26cac6.jpg"), Set.of("Pop","Pop Rock"), 0, 2000.0, true, ProductType.VINYLS, "-");
			Product product2 = new Product("Fine Line", "Harry Styles","asdfasdfasdfasd" ,"2019", List.of( "https://i.pinimg.com/736x/d2/43/5c/d2435c7f07cb296e3a5b51518e26cac6.jpg"), Set.of("Pop","Pop Rock"), 2, 2000.0, true, ProductType.VINYLS, "-");
			Product product3 = new Product("Dual Lipa album", "Dua Lipa","asdfasdfasdfasd" ,"2019", List.of( "https://i.pinimg.com/736x/d2/43/5c/d2435c7f07cb296e3a5b51518e26cac6.jpg"), Set.of("Pop","Pop Rock"), 0, 1000.0, true, ProductType.VINYLS, "-");
			Product product4 = new Product("Toro Rojo", "Guasones", "asdfasdfasdfasd","2019", List.of( "https://i.pinimg.com/736x/d2/43/5c/d2435c7f07cb296e3a5b51518e26cac6.jpg"), Set.of("Pop","Pop Rock"), 10, 1000.0, true, ProductType.VINYLS, "-");


			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			productRepository.save(product4);

			Bill bill1 = new Bill("11111 1111",200.00 ,Delivery.AMBA , 1000.00, 900.00, 1200.00 ,LocalDateTime.now(), client1);
			Bill bill2 = new Bill("2222 2222", 300.00,Delivery.CABA, 1000.00, 900.00, 1300.00 ,LocalDateTime.now(), client1);
			billRepository.save(bill1);
			billRepository.save(bill2);

			ProductBill pb1 = new ProductBill(2, product1, bill1);
			ProductBill pb2 = new ProductBill(2, product2, bill1);
			ProductBill pb3 = new ProductBill(2, product2, bill2);
			productBillRepository.save(pb1);
			productBillRepository.save(pb2);
			productBillRepository.save(pb3);


			//bill(String number, Double deliveryAmount, Double grossAmount, Double netAmount, LocalDateTime date, Client client)
			//productbill(Integer quantity, Product product, Bill bill)


		};
	}
	@Autowired
	private PasswordEncoder passwordEncoder;

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

}
