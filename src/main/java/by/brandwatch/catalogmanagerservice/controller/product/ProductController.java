package by.brandwatch.catalogmanagerservice.controller.product;

import by.brandwatch.catalogmanagerservice.exception.EntitiesNotFoundByIdsException;
import by.brandwatch.catalogmanagerservice.service.product.IProductService;
import by.brandwatch.catalogmanagerservice.service.product.model.ProductDto;
import by.brandwatch.catalogmanagerservice.service.product.model.ProductViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductViewDto> getProduct(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(this.productService.getProduct(id));
        } catch (EntitiesNotFoundByIdsException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage(), e);
        }
    }

    @PostMapping("")
    public ProductViewDto createProduct(@RequestBody ProductDto product) {
        return this.productService.createProduct(product);
    }

    @PutMapping("/update/{id}")
    public ProductViewDto updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto product) {
        try {
            return this.productService.updateProduct(id, product);
        } catch (EntitiesNotFoundByIdsException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getStatusText(), e);
        }
    }

    @DeleteMapping("")
    public void deleteProduct(@RequestBody Set<Long> ids) {
        try {
            this.productService.deleteProduct(ids);
        } catch (EntitiesNotFoundByIdsException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getStatusText(), e);
        }
    }

}
