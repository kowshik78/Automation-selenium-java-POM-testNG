package utils;
import java.util.Random;

public class Constant {

    public final static String firstname = randomGenerator();
    public final static String lastname = randomGenerator();
    public final static String Zip = "1900";

    public final static String email = randomGenerator();
    public final static String password = "1qazZAQ!";
    public final static String confirmpassword = password;

    public final static String currentpassword = "1qazZAQ!";
    public final static String newpassword = "1qazZAQ!!";

    public final static String loginname = "standard_user";
    public final static String loginpassword = "secret_sauce";

    public final static String street1 = "demo2";
    public final static String city = "Dhaka";
    public final static String zip = "1900";
    public final static String telephone = "1234567890";







    private static String randomGenerator(){
        String domain = "@yopmail.com";
        String characters= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i< 10 ; i++)
        {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            stringBuilder.append(randomChar);
        }
        return stringBuilder+domain;
    }
}