

aspect Test {
    

    pointcut changes(Animal a, String b): target(a) && call(String Animal.setName(String)) && args(b);

    after(Animal a, String b) returning (String c): changes(a, b) {
        System.out.println("I am going to name it : " + b + c);
    }
}