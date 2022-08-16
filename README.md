# Merchant Trade
A Spring Boot application to perform following operation:

1) As Super Admin should be able to add the product with name, id, color, price

> + ProductController -> addProduct(@RequestBody Product product)

2) As super Admin should be able to add the category of product

> + ProductController -> updateProduct(@RequestBody Product product)
> + CateogoryController -> addCategory(@RequestBody Category category)

3) As Super Admin Able to View the product list

> + ProductController -> getAllProducts()

4) As Super Admin should be able to view by category and their product

> + ProductController -> getProductByCategory(@PathVariable String category)

5) As Super Admin should be able to search the product by name and category name

> + ProductController -> getProductByCategory(@PathVariable String category)
> + ProductController -> getProductByName(@PathVariable String name)

6) As super Admin should be able to add the merchant name to the product as name pin code , location, GST NO

> + MerchantController -> getMerchantById(@PathVariable int id)


7) As super Admin should be able to search the merchant by name and location

> + MerchantController -> getMerchantByName(@PathVariable String name)
> + MerchantController -> getMerchantByLocation(@PathVariable String location)

8) Use the Proper Exception handling for this

> + ProductController -> getProductByCategory(@PathVariable String category)
> + CategoryController -> getCategoryByName(@PathVariable String name)
> + CustomerController -> order(@PathVariable("id") int id,@PathVariable("productId") int productId)
> + MerchantController -> getMerchantById(@PathVariable int id)
> ,etc

9. Make use of java 8 lambda and stream API for filter

> + ProductController -> getProductByCategory(@PathVariable String category)

10. As super Admin able to add the customer and should be able to buy the product  

> + CustomerController -> addCustomer(@RequestBody Customer Customer)
> + CustomerController -> order(@RequestBody Customer customer,@PathVariable int id,@PathVariable int productId)