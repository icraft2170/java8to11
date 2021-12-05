package me.hyeonho.java8to11.modern.functionalinterface_example;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {
        Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        Product productB = new Product(2L, "B", new BigDecimal("55.50"));
        Product productC = new Product(3L, "C", new BigDecimal("17.45"));
        Product productD = new Product(4L, "D", new BigDecimal("23.00"));
        Product productE = new Product(5L, "E", new BigDecimal("110.99"));
        final List<Product> products = Arrays.asList(
                productA,
                productB,
                productC,
                productD,
                productE
        );

        // 가격이 20달러 이상인 것
        System.out.println("products >= 20$" + filter(products, product -> product.getPrice().compareTo(new BigDecimal("20")) >= 0));

        // 가격이 10달러 이하인 것
        System.out.println("products <= 10$" + filter(products, product -> product.getPrice().compareTo(new BigDecimal("10")) <= 0));

        final List<Product> expensiveProducts = filter(products, product -> product.getPrice().compareTo(new BigDecimal("50")) > 0);
        final List<DiscountedProduct> discountedProducts =
                map(expensiveProducts
                , product -> new DiscountedProduct(product.getId(), product.getName(), product.getPrice()
                .multiply(new BigDecimal("0.5"))));



        System.out.println("expensiveProducts : " + expensiveProducts);
        System.out.println("discountedProducts : " + discountedProducts);

        Predicate<Product> lessThanOrEqualTo30 = product -> product.getPrice().compareTo(new BigDecimal("30")) <= 0;
        System.out.println("discounted products <= $30" + filter(discountedProducts, lessThanOrEqualTo30));
        System.out.println("products <= $30" + filter(products, lessThanOrEqualTo30));


        BigDecimal total = total(products, product -> product.getPrice());
        System.out.println("Total price : " + total);

        BigDecimal discountedProductsTotal = total(discountedProducts, product -> product.getPrice());
        System.out.println("discountedProductsTotal price : " + discountedProductsTotal);

        Order order = new Order(1L, "on-1234", Arrays.asList(
                new OrderedItem(1L, productA, 2),
                new OrderedItem(2L, productC, 1),
                new OrderedItem(3L, productD, 10)
        ));

        System.out.println("order total price : " + order.totalPrice());
    }

    private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T t : list) {
            if (predicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    private static <T> BigDecimal total(List<T> list, Function<T,BigDecimal> mapper){
         BigDecimal total = BigDecimal.ZERO;
         for (final T t : list) {
             total = total.add(mapper.apply(t));
         }
         return total;
     }

    @AllArgsConstructor
    @Data
    static class Order {
        private Long id;
        private String orderNumber;
        List<OrderedItem> items;

        public BigDecimal totalPrice(){
            return total(items, item -> item.getItemTotal());
        }
    }


    @AllArgsConstructor
    @Data
    static class OrderedItem {
        private Long id;
        private Product product;
        private int quantity;

        public BigDecimal getItemTotal(){
            return product.getPrice().multiply(new BigDecimal(quantity));
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    static class Product {

        private Long id;
        private String name;
        private BigDecimal price;


        @Override
        public String toString() {
            return new StringBuilder("Product{")
                    .append("id=").append(id)
                    .append(", name='").append(name).append('\'')
                    .append(", price=").append(price)
                    .append('}').toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getPrice(), product.getPrice());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName(), getPrice());
        }
    }


    @ToString(callSuper = true)
    static class DiscountedProduct extends Product{
        public DiscountedProduct(Long id, String name, BigDecimal price) {
            super(id, name, price);
        }

        public DiscountedProduct() {
        }
    }


}


