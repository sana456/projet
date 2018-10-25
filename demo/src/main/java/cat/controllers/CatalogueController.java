package cat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import cat.dao.IProduiRepository;
import cat.entities.Produit;

@RestController 
public class CatalogueController {
@Autowired 
private IProduiRepository produitRepository;
@RequestMapping("/save")
public  Produit saveProduit(Produit p ) {
	produitRepository.save(p);
	return p ;
	
}
@RequestMapping("/all") 
public List<Produit> getProduits () {
	return produitRepository.findAll();
}
@RequestMapping("/produits")
public Page<Produit> getProduits(String mc , int page) {
	return produitRepository.produitParMC("%"+mc+"%" ,new PageRequest(page,5));
	
}
@RequestMapping("/get") 
public Produit getProduit(Long ref ) {
	return produitRepository.findOne(ref);
}
@RequestMapping("/delete") 
public boolean delete(Long ref) {
	produitRepository.delete(ref);
	return true;
}
@RequestMapping("/update")
public Produit update(Produit p) {
	produitRepository.saveAndFlush(p);
	return p ;
}
}
