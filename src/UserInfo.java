public class UserInfo {
    private String name;
    private int age;
    private String email;
    private boolean isActive;

    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public boolean getIsActive() {
        return isActive;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Method to display user info
    public void displayInfo() {
        System.out.println("----- User Info -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Active: " + (isActive ? "Yes" : "No"));
        System.out.println("---------------------\n");
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create 3 different users
        UserInfo user1 = new UserInfo("Omair", 21, "3mairalfalahii@gmail.com", true);
        UserInfo user2 = new UserInfo("Ahmed", 28, "aisha@gmail.com", false);
        UserInfo user3 = new UserInfo("Omar", 19, "ahmed@gmail.com", true);

        // Display their information
        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

    }
}