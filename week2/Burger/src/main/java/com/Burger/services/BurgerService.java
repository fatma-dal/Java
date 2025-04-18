vspackage com.Burger.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Burger.Repositories.BurgerRepo;
import com.Burger.models.Burger;

@Service
public class BurgerService {
	
	@Autowired
	BurgerRepo burgerRepo;
	
	public List<Burger> allBurgers(){
		return burgerRepo.findAll();
	}
	
	public Burger createBurger(Burger burger) {
		return burgerRepo.save(burger);
	}
	
}
