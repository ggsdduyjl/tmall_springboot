package com.tmall.web;

import com.tmall.pojo.Product;
import com.tmall.pojo.PropertyValue;
import com.tmall.service.ProductService;
import com.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;

    @GetMapping(value = "products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid) throws Exception{
        Product product=productService.get(pid);
        propertyValueService.init(product);
        List<PropertyValue> propertyValues=propertyValueService.list(product);
        return propertyValues;
    }

    @PutMapping(value = "propertyValues")
    public PropertyValue update(@RequestBody PropertyValue bean){
        propertyValueService.update(bean);
        return bean;
    }
}
