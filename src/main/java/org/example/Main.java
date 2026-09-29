package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Створення категорій
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");


        // Створення об'єктів класу Product
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        // Виведення інформації про товари
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

        // Створення кошика
        Cart cart = new Cart();
        // Додавання товарів до кошика
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        // Виведення інформації про товари в кошику
        System.out.println(cart);
        // Припустимо, користувач вирішив видалити навушники з кошика
        cart.removeProduct(product3);
        // Виведення оновленої інформації про товари в кошику
        System.out.println("\nПісля видалення товару:");
        System.out.println(cart);

        // Оголошення товарів і категорій з попереднього коду
         cart = new Cart();
        List<Order> history = new ArrayList<>();
        List<Product> catalog = List.of(product1, product2, product3);

        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Зробити замовлення");
            System.out.println("5 - Видалити товар з кошика");
            System.out.println("6 - Історія замовлення");
            System.out.println("7 - Пошук товару");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    // Проста логіка додавання, для прикладу використаємо ID для вибору
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        history.add(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear(); // Метод для очищення кошика, який потрібно реалізувати в класі Cart
                    }
                    break;
                case 5:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int idRemove = scanner.nextInt();
                    if (idRemove == 1) cart.removeProduct(product1);
                    else if (idRemove == 2) cart.removeProduct(product2);
                    else if (idRemove == 3) cart.removeProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 6:
                    System.out.println(history);
                    break;
                case 7:
                    System.out.println("ВВедіть назву або категорію товару");
                    scanner.nextLine();
                    String q = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    for (Product p : catalog){
                        if (p.getName().toLowerCase().contains(q) ||
                                p.getCategory().getName().toLowerCase().contains(q)){
                            System.out.println(p);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("За вашим запитом нічого не знайдено");
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }

        }

    }
}
