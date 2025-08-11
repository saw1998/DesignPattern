package Creational.Builder;

// Purpose: Build complex objects step-by-step, especially when object creation has many optional parameters.
// Analogy: Ordering a Subway sandwich — you choose bread, fillings, sauces step-by-step.

// When to use: When constructors become too complex or have too many parameters.

class User{
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    private User(Builder builder){
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        email = builder.email;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private int age;
        private String email;

        public Builder firstName(String firstName) {this.firstName = firstName; return this;}
        public Builder lastName(String lastName){ this.lastName = lastName; return this;}
        public Builder age(int age) {this.age = age; return this;}
        public Builder email(String email) {this.email = email; return this;}

        public User build(){
            return new User(this);
        }
    }
}

public class BuilderDemo {
    public static void main(String[] args){
        User user = new User.Builder()
                        .firstName("firstName")
                        .lastName("lastName")
                        .age(54)
                        .email("hello@gamil.com")
                        .build();
    }
}

/*
 * ✅ Interview note: Builder solves telescoping constructor problem.
 */
