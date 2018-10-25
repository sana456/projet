package cat.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cat.entities.Produit;

public interface IProduiRepository extends JpaRepository<Produit, Long>{ 
	@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> produitParMC(@Param("x")String mc ,Pageable p);
	public List<Produit> FindByDesignation(String des);
	public Page<Produit> findByDesignation(String des , Pageable p);

}
