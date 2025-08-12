package BehaviouralPattern.Strategy;

/*
 * Strategy interface : declares the payment method
 */
interface PaymentStrategy{
    void pay(int amount);
}

/*
 * Concrete Strategy
 */
class PaypalPayment implements PaymentStrategy{
    private String email;

    public PaypalPayment(String email){
        this.email = email;
    }
    @Override
    public void pay(int amount){
        System.out.println("Paid $" + amount + "using paypal account: " + email);
    }
}

class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;

    public CreditCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay(int amount){
        System.out.println("Paid $" + amount + " using Credit card: " + cardNumber);
    }
}

//Context: uses the strategy interface
class ShoppingCart{
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy){
        paymentStrategy = strategy;
    }
    public void checkout(int amount){
        if(paymentStrategy == null){
            throw new IllegalStateException("Payment Startegy not set!");
        }
        paymentStrategy.pay(amount);
    }
}

/*
 * Client
 */

public class PaymentMethodSelectionDemo {
    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        
        //pay with paypal
        cart.setPaymentStrategy(new PaypalPayment("user@example.com"));
        cart.checkout(400);

        cart.setPaymentStrategy(new CreditCardPayment("123456789"));
        cart.checkout(900);
    }    
}
