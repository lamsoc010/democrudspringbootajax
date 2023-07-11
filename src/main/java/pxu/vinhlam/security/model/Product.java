package pxu.vinhlam.security.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float price;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	
	@ManyToMany
	@JoinTable(name = "product_tags", 
			joinColumns = @JoinColumn(name="productId"),
			inverseJoinColumns = @JoinColumn(name="tagId"))
	private List<Tag> tags;
}
