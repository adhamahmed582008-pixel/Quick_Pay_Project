import java.util.*;
public class Quick_Pay_Project{
   static Scanner input = new Scanner(System.in);
public static void main(String[] args) {   
//======================================================================================//
                                    //MAIN PROGRAM//
//======================================================================================//
//Handles the main admin panal options
        System.out.println("========== ADMIN PANEL ==========");
        int chose;
        do {
            System.out.println("1. Show Statistics");
            System.out.println("2. Search User");
            System.out.println("3. View All Users");
            System.out.println("4. Update User");
            System.out.println("5. View All Transactions");
            System.out.println("6. Block Account");
            System.out.println("7. Unblock Account");
            System.out.println("8. View User Details");
            System.out.println("9. Logout");
            System.out.println("Choose an option:");
            chose = input.nextInt();
            switch (chose) {
                case 1:
                    showStatistics();
                    break;
                case 2:
                    searchUser();
                    break;

                case 3:
                    viewAllUsers();
                    break;
                case 4:
                    updateUser();
                    break;
                case 5:
                    showTransactionHistory();
                case 6:
                    blockAccount();
                    break;
                case 7:

                case 8:

                case 9:

                default:
                    System.out.println("INVALID CHOISE!");


            }
        } while (chose != 9);


    }


// ==========================================================
//validation 
// ==========================================================
//1) numbers only check 
static boolean isDigitsOnly(String text)
{
    if(text.length()==0)
    {
        return false;
    }
    for(int i =0; i<text.length(); i++)
    {
        if (text.charAt(i) < '0' || text.charAt(i)>'9' )
        {
            return false;
        }
    }
    return true;
}
//2) at least 3 letter check for name 
static boolean isValidName(String name)
{
    if (name.length()<3){
         return false ; 
    }
        for (int i=0; i<name.length(); i++)
            {
                char character = name.charAt(i);
                boolean isLetter = (character>='a' && character <= 'z') || (character>='A' && character<='Z');
                if (!isLetter && character !=' ')//character dont equal space 
                {
                    return false;
                }
            } 
            return true ;
}
//3) email without spaces with one @ and one . 
static boolean isValidEmail(String email )
{
    if (email.contains(" "))
    {
        return false ; 
    }
    int at = email.indexOf("@"); // place of first @ (at=@)
    int dot = email.lastIndexOf(".");// last place of dot (dot=.)
    return at > 0 && at == email.lastIndexOf("@") && dot >at + 1 && dot < email.length()-1;
    // there are words before @ && there is only one @ && dot is after @ and there are words between them && there are words after dot 
}
//4) phone number is 11 digits and start with 01
static boolean isValidPhone (String Phones)
{
    return Phones.length()==11 && isDigitsOnly(Phones) && Phones.startsWith("01");
}
//5) PASSWORD IS 5 OR MORE LETTERS OR NUMBERS AND DONT CONTAIN ANY SPACES 
static boolean isValidPassword (String Passwords)
{
   return Passwords.length()>=5 && !Passwords.contains(" ");
}
//6) METHOD THAT READ STRING FOR ALL PROGRAM (USE ANY WHERE NEED STRING INPUT )
// message is any question you want to ask 
static String ReadText (String message)
{
    System.out.println(message);
    String line = input.nextLine().trim();
    return line;
}
//7) METHOD THAT READ NUMBERS FOR ALL PROGRAM (USE ANY WHERE NEED NUMBERS INPUT )
// message is any question you want to ask
static int ReadNumber (String message)
{
        System.out.print(message); 
        int number = input.nextInt(); 
        input.nextLine(); 
        return number;
}
//8) METHOD CHECK THAT VALUE IS MORE THAN ZERO 
static boolean isValidAmount (long amount)
{
    if (amount > 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}
//9) METHOD FOR CHECKING THAT TWO USERS CANT LOGIN WITH SAME EMAIL OR PHONE NUMBER
static boolean isAlreadyExist (String[] array , String targetvalue)
{
    for (int i = 0; i < array.length; i++)
    {
       if (array[i].equalsIgnoreCase(targetvalue))
       {
        return true; // REPETED 
       }
    }
    return false ; // NOT REPETED 
}
//10) METHOD PREVENT REPEATED PEOPLE IN FAVORITE OF SINGLE USER 
static boolean isAlreadyFavorite (String[] favoritelist , String contact )
{
   for (int i =0; i < favoritelist.length; i++) 
   {
    if (favoritelist[i].equalsIgnoreCase(contact))
    {
        return true; // REPETED 
    }
   }
   return false ; // NOT REPETED
}
//11) SENDER AND RECIVER ARE NOT THE SAME 
static boolean isValidSenderAndReciver (String senderphone , String recipientphone )
{
    if(senderphone.equalsIgnoreCase(recipientphone))
    {
        return false; // SENDER AND USER ARE THE SAME 
    }
    else 
    {
        return true; // SENDER AND USER ARENOT THE SAME 
    }
}
//12) CHECK IF USER IS BLOCKED OR NOT 
static boolean isAccountActive (String status)
{
    if(status.equalsIgnoreCase("active"))
    {
        return true; // NOT BLOCKED 
    }
    else{
        return false; // BLOCKED 
    }
}
//13) ENOUGH BALANCE
static boolean HasEnoughBalance (long CurrentBalance , long TransactionAmount ) 
{
    if (CurrentBalance>=TransactionAmount)
    {
        return true;
    }
    else
    {
        return false; 
    }
}
    // A method to help in printing the detailed information of a specific user by index
    static void printuserdata(int i) {
        System.out.println("========== User Found ==========");
        System.out.println("ID:" + ids[i]);
        System.out.println("USERNAME:" + USERNAME[i]);
        System.out.println("Balance:" + balance[i]);
        System.out.println("Email Adress:" + emails[i]);
        System.out.println("Status:" + (isblocked[i] ? "Blocked" : "Active"));

    }

    static void showStatistics() {
        //show overall statistics (total users,total balances,blocked accounts....)
        System.out.println("========== Show Statistics ==========");
        int totalusers = ids.length;
        int activeusers = 0;
        int blockredusers = 0;
        double totaltransurfferd = 0;
        for (int i = 0; i < USERNAME.length; i++) {
            if (isblocked[i]) {
                blockredusers++;
            } else {
                activeusers++;
            }
        }
        for (double j : amountofsuctran) {
            totaltransurfferd += j;

        }
        System.out.println("TOTAL Users:" + totalusers);
        System.out.println("Active Acounts:" + activeusers);
        System.out.println("Blocked Acounts:" + blockredusers);
        System.out.println("Successful Transactions:" + successfultransactions);
        System.out.println("Faild Transactions:" + faildtransactions);
        System.out.println("Tolal Amount of Successful Transactions:" + totaltransurfferd);

    }

    static void searchUser() {
        //Searches for a user using 4 options(ID,FULLNAME,EMAIL,PHONE)
        System.out.println("==========  Search User ==========");
        System.out.println("Chose from (1-4)");
        System.out.println("1.Search by ID");
        System.out.println("2.Search by FULL NAME");
        System.out.println("3.Search by phone number");
        System.out.println("4.Email adress");
        int methods = input.nextInt();
        input.nextLine();
        boolean isfound = false;

        switch (methods) {
            case 1://Search by user id
                System.out.println("Enter ID to search:");
                int idsearch = input.nextInt();
                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == idsearch) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            case 2://Search by fullname(case-insensitive)
                System.out.println("Enter full name to search");
                String namesearch = input.nextLine();
                for (int i = 0; i < USERNAME.length; i++) {
                    if (USERNAME[i].equalsIgnoreCase(namesearch)) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            case 3://Search by phone number
                System.out.println("Enter phone number to search:");
                String phonesearch = input.nextLine();
                for (int i = 0; i < phones.length; i++) {
                    if (phones[i].equalsIgnoreCase(phonesearch)) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            case 4://Search by email(case-insensitive)
                System.out.println("Enter Email addres to search:");
                String EMAILSEARCH = input.nextLine();
                for (int i = 0; i < emails.length; i++) {
                    if (emails[i].equalsIgnoreCase(EMAILSEARCH)) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            default:
                System.out.println("INVALID CHOICE");
        }

        if (!isfound) {
            System.out.println("USER IS NOT FOUND");
        }


    }

    static void viewAllUsers() {
        //Shows a list of all users registered in the system
        System.out.println("========== View All Users ==========");
        // Check for empty arrays
        if (ids.length == 0) {
            System.out.println("NO USER FOUND");
            return;
        }
        //loop goes through all users and print thier data
        for (int i = 0; i < ids.length; i++) {
            System.out.println("User:" + (i + 1));
            printuserdata(i);
        }


    }

    static void updateUser() {
        //Updates specific information about a selected user by entering their IDs
        System.out.println("Enter user ID to update:");
        int idforuser = input.nextInt();
        input.nextLine();
        boolean isfound = false;
        for (int i = 0; i<ids.length; i++) {
            if (ids[i] == idforuser) {
                isfound = true;
                System.out.println("==========  USER IS FOUND ==========");
                printuserdata(i);
                System.out.println("Chosse what you want to update:");
                System.out.println("1.Update Username");
                System.out.println("2.Update Email");
                System.out.println("3.Update Phone Number");
                System.out.println("Enter choice (1-3):");
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1:
                        {
    System.out.println("Enter new Username:");
    String newName = input.nextLine();

    while (isValidName(newName) == false) {
        System.out.println("Invalid name!");
        System.out.println("Enter new Username again:");
        newName = input.nextLine();
    }

    String OLDNAME = USERNAME[i];
    USERNAME[i] = newName;

    for (int j = 0; j < transactionSenders.length; j++) {

        if (transactionSenders[j].equalsIgnoreCase(OLDNAME)) {
            transactionSenders[j] = newName;
        }

        if (transactionReceivers[j].equalsIgnoreCase(OLDNAME)) {
            transactionReceivers[j] = newName;
        }
    }

    System.out.println("Username updated successfully");
    break;
                        }
                    
                case 2: {
    System.out.println("Enter new Email:");
    String newEmail = input.nextLine();

    while (isValidEmail(newEmail) == false) {
        System.out.println("Invalid email!");
        System.out.println("Enter new Email again:");
        newEmail = input.nextLine();
    }

    boolean emailExists = false;

    for (int j = 0; j < emails.length; j++) {
        if (j != i && emails[j].equalsIgnoreCase(newEmail)) {
            emailExists = true;
        }
    }

    while (emailExists == true) {
        System.out.println("Email already exists!");
        System.out.println("Enter another email:");
        newEmail = input.nextLine();

        while (isValidEmail(newEmail) == false) {
            System.out.println("Invalid email!");
            System.out.println("Enter new Email again:");
            newEmail = input.nextLine();
        }

        emailExists = false;

        for (int j = 0; j < emails.length; j++) {
            if (j != i && emails[j].equalsIgnoreCase(newEmail)) {
                emailExists = true;
            }
        }
    }

    emails[i] = newEmail;

    System.out.println("Email updated successfully!");
    break;
}



            case 3: {
    System.out.println("Enter new phone number:");
    String newPhone = input.nextLine();

    while (isValidPhone(newPhone) == false) {
        System.out.println("Invalid phone number!");
        System.out.println("Enter phone number again:");
        newPhone = input.nextLine();
    }

    boolean phoneExists = false;

    for (int j = 0; j < phones.length; j++) {
        if (j != i && phones[j].equals(newPhone)) {
            phoneExists = true;
        }
    }

    while (phoneExists == true) {
        System.out.println("Phone number already exists!");
        System.out.println("Enter another phone number:");
        newPhone = input.nextLine();

        while (isValidPhone(newPhone) == false) {
            System.out.println("Invalid phone number!");
            System.out.println("Enter phone number again:");
            newPhone = input.nextLine();
        }

        phoneExists = false;

        for (int j = 0; j < phones.length; j++) {
            if (j != i && phones[j].equals(newPhone)) {
                phoneExists = true;
            }
        }
    }

    phones[i] = newPhone;

    System.out.println("Phone Number updated successfully!");
    break;
}
                    default:
                        System.out.println("INVALID CHOICE!");
                }
                break;

            }
        }
        if (!isfound){
            System.out.println("User not found");
        }
    }
static void  showTransactionHistory(){
        //shows all transactions history
        System.out.println("========== ALL TRANSACTIONS HISTROY ==========");
        if (transactionIDs.length==0){
            System.out.println("NO transactions found");
            return;
        }
        for (int i =0;i<transactionIDs.length;i++){
            System.out.println("Transaction ID :"+transactionIDs[i]);
            System.out.println("Sender :"+transactionSenders[i]);
            System.out.println("Recever :"+transactionReceivers[i]);
            System.out.println("Amount :"+amountofsuctran[i]);
            System.out.println("Status :"+transactionStatuses[i]);
            System.out.println("--------------------------------------------------");
        }


}
static void blockAccount() {
        //block accounts baisd on ID
        System.out.println("Enter user ID to block");
        int idtoblock=input.nextInt();
        input.nextLine();
        boolean isfound =false;
        for (int i =0;i<ids.length;i++) {
            if (ids[i] == idtoblock) {
                isfound = true;
                if (isblocked[i]) {
                    System.out.println("This Acount is Already blocked");
                } else {
                    isblocked[i] = true;
                    System.out.println("Acount For" +" "+ USERNAME[i] +" "+ "blocked successfully.");
                }
                break;
            }
        }
        if (!isfound){
            System.out.println("User not found");
        }


                }



    //Global variabls useing arrays to store database information

    static int[] ids = {111, 222, 333};
    static String[] USERNAME = {"adham ahmed", "mariam yasser", "fatma ashraf"};
    static String[] emails = {"adham@gmail.com", "mariam@gmail.com", "fatma@gmail.com"};
    static long[] balance = {20000, 90000, 300000};
    static boolean[] isblocked = {true, true, false};
    static int successfultransactions = 5;
    static int faildtransactions = 3;
    static double[] amountofsuctran = {50.0, 100.0, 300.0, 500.0, 40.0, 600.0,900.0,30.0};
    static String[] phones = {"01012345678", "01123456789", "01234567890"};
static int[]transactionIDs = {101,102,103,104,105,106,107,108};
static String[]transactionSenders = {"adham ahmed","mariam yasser","fatma ashraf","adham ahmed","mariam yasser","fatma ashraf","adham ahmed","mariam yasser"};
static String[]transactionReceivers = {"mariam yasser","fatma ashraf","adham ahmed","fatma ashraf","adham ahmed","mariam yasser","fatma ashraf","adham ahmed"};
static String[]transactionStatuses = {"SUCCESS","SUCCESS","SUCCESS","SUCCESS","SUCCESS","FAILED","FAILED","FAILED"};
static String[]passwords = {"12345","13430","3211145"};

}