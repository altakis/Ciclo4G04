package com.unab.g04nosql.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.g04nosql.Collection.Products;
import com.unab.g04nosql.IService.IProductsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/products")
public class ProductsController {

    @Autowired
    private IProductsService service;

    @GetMapping
    public List<Products> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<Products> show(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Products save(@RequestBody Products person) {
        return service.save(person);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Products update(@PathVariable Integer id, @RequestBody Products products) {
        Optional<Products> op = service.findById(id);

        if (!op.isEmpty()) {
            Products productsUpdate = op.get();
            productsUpdate.setCodigo(products.getCodigo());
            productsUpdate.setNombre(products.getNombre());
            productsUpdate.setDescripcion(products.getDescripcion());            
            productsUpdate.setImagen(products.getImagen());
            productsUpdate.setCantidadMaxima(products.getCantidadMaxima());
            productsUpdate.setCantidadMinima(products.getCantidadMinima());
            productsUpdate.setStock(products.getStock());
            products.setPrecioUnitarioCompra(products.getPrecioUnitarioCompra());
            products.setPrecioUnitarioVenta(products.getPrecioUnitarioVenta());
            productsUpdate.setIva(products.getIva());
            productsUpdate.setDescuento(products.getDescuento());            
            productsUpdate.setCategoria_id(products.getCategoria_id());
            productsUpdate.setMarca_id(products.getMarca_id());
            productsUpdate.setUnidad_medida_id(products.getUnidad_medida_id());            
            productsUpdate.setEstado(products.getEstado());
            return service.save(productsUpdate);
        }

        return products;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
