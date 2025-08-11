package Structural.Adapter;

// Quick Recap of Adapter Pattern
// Purpose:

// Allows objects with incompatible interfaces to work together by wrapping one with an adapter that translates the interface.

// Types:

// Object Adapter → uses composition

// Class Adapter → uses inheritance (Java rarely uses this due to single inheritance limit)

// Example 1: Payment Gateway Adapter
// Imagine your e-commerce app supports PayPal by default, but now you need to integrate Stripe without changing your existing checkout logic.

/*
 * Existing System/interface
 */
interface PaymentProcessor{
    void pay(double amount);
}

/*
 * Existing Implementation
 */
class PaypalProcessor implements PaymentProcessor{
    @Override
    public void pay(double amount){
        System.out.println("Paid $"+ amount + " using Paypal");
    }
}

/*
 * This is from third party Stripe SDK
 */
class StripePayment{
    public void makePayment(int cents){
        System.out.println("Paid $" + (cents/100.0) + " using Stripe");
    }
}

/*
 * This is our adapter
 */
class StripeAdapter implements PaymentProcessor{
    private StripePayment stripe;

    public StripeAdapter(StripePayment stripe){
        this.stripe = stripe;
    }

    @Override
    public void pay(double amount){
        int cents = (int)(amount * 100);
        stripe.makePayment(cents);
    }
}

/*
 * client
 */
public class AdapterDemo {
    public static void main(String[] args){
        PaymentProcessor paypal = new PaypalProcessor();
        paypal.pay(50.0);

        PaymentProcessor stripeAdapter = new StripeAdapter(new StripePayment());
        stripeAdapter.pay(75.5);
    }    
}
