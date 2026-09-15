package pollytech.aisw.bookmarket.service;

import pollytech.aisw.bookmarket.domain.Cart;
import pollytech.aisw.bookmarket.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }

    @Override
    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);
    }
}
