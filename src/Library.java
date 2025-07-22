public class Library {
    public static void main(String[] args) {
        Book b1 = new Book("The Alchemist", "Paulo Coelho", 200);
        Book b2 = new Book("1984", "George Orwell", 300);
        Textbook t1 = new Textbook("Java Programming", "James Gosling", 500, "Computer Science", 3);

        b1.displayInfo();
        b1.borrowBook();

        System.out.println();

        b2.displayInfo();
        b2.returnBook();

        System.out.println();

        t1.displayInfo();
        t1.borrowBook();
    }
}
