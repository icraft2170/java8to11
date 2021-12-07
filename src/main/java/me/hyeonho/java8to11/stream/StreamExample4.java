package me.hyeonho.java8to11.stream;

import lombok.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class StreamExample4 {

    public static void main(String[] args) {
        final List<Product> products =
                Arrays.asList(
                    new Product(1L, "A", new BigDecimal("100.50")),
                    new Product(2L, "B", new BigDecimal("23.00")),
                    new Product(3L, "C", new BigDecimal("31.45")),
                    new Product(4L, "D", new BigDecimal("80.20")),
                    new Product(5L, "E", new BigDecimal("7.50"))
                );

        System.out.println("\nProducts.price >= $30 \n" +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00")) >= 0)
                        .collect(toList())
        );

        System.out.println("\nProducts.price >= $30 (with : joining)\n" +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00")) >= 0)
                        .map(product -> product.toString())
                        .collect(joining("\n"))
        );

        System.out.println("\nIntStream.sum() : " +
                IntStream.of(1, 2, 3, 4, 5)
                        .sum()
        );

        System.out.println("\nTotal Price : " +
                products.stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        );


        System.out.println("\nTotal Price ( >= $30) " +
                products.stream()
                        .map(Product::getPrice)
                        .filter(price -> price.compareTo(new BigDecimal("30")) >= 0)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );


        System.out.println("\n# of Products Price  >= $30: " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .count()
        );


        final OrderedItem item1 = new OrderedItem(1L, products.get(0), 1);
        final OrderedItem item2 = new OrderedItem(2L, products.get(2), 3);
        final OrderedItem item3 = new OrderedItem(3L, products.get(4), 10);

        final Order order = new Order(1L, Arrays.asList(item1, item2, item3));

        System.out.println(order);

    }


    @AllArgsConstructor
    @Data
    static class Order {
        private Long id;
        List<OrderedItem> items;


        public BigDecimal totalPrice(){
            return items.stream()
                    .map(OrderedItem::getTotalPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }


    @AllArgsConstructor
    @Data
    static class OrderedItem {
        private Long id;
        private Product product;
        private int quantity;

         public BigDecimal getTotalPrice(){
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
            final StringBuilder sb = new StringBuilder("Product(");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append(", price=").append(price);
            sb.append(')');
            return sb.toString();
        }
    }
}
