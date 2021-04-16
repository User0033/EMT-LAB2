package lab2.service;

import lab2.model.Book;
import lab2.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Book> listAllBooksInShoppingCart(Long cartId) throws Exception;

    ShoppingCart getActiveShoppingCart(String username) throws Exception;

    ShoppingCart addBookToShoppingCart(String username, Long productId) throws Exception;
}
