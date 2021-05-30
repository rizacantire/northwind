package kodlamaio.northwind.api.controllers;

import java.util.List;

import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products/")
public class ProductsController {
	
	
	private ProductService productService;
	
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@GetMapping("getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Product product) {

		return this.productService.add(product);
	}

	@GetMapping("getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}

	@GetMapping("getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
	}

	@GetMapping("getallByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){

		return this.productService.getAll(pageNo,pageSize);
	}
	@GetMapping("getAllSorted")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}

	@GetMapping("getdetails")
	public DataResult<List<ProductWithCategoryDto>> getDetails(){
		return this.productService.getProductDetails();
	}
	
	
}
