
// باقي الاوبشنز لو الباسورد غلط او الايميل
import java.util.Scanner;
public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        login();
    }
    // declare variables and arrays
    static int Max_Users = 100;
    static int[] ids = new int[Max_Users];
    static int nextId = 334; 
    static int registeredUsersCount = 3;
    static String[] usernames = new String[Max_Users];
    static String[] password = new String[Max_Users];
    static long[] balance = new long[Max_Users];
    static String[] phones = new String[Max_Users];
    static String[] emails = new String[Max_Users];
    static boolean[] isblocked = new boolean[Max_Users];
    static boolean[] isactive  = new boolean[Max_Users];
    static boolean[][] favourites = new boolean[Max_Users][Max_Users];
    static int[] senderhistory = new int[1000];
    static int[] receiverhistory = new int[1000];
    static long[] amounttansferd = new long[1000];
    static String[] status = new String[1000];
    static int count = 0;
    static int successfultransactions = 5;
    static int faildtransactions = 3;
    static String[] usernamesadmin = { "amr ashraf", "houda ahmed", "hana khaled" };
    static String[] phoneforadminpanalp = { "01546893456", "01145672345", "01034456783" };
    static double[] amountofsuctran = { 50.0, 100.0, 300.0, 500.0, 40.0, 600.0, 900.0, 30.0 };
    static int[] transactionIDs = { 101, 102, 103, 104, 105, 106, 107, 108 };
    static String[] transactionSenders = { "adham ahmed", "mariam yasser", "fatma ashraf", "adham ahmed", "mariam yasser", "fatma ashraf", "adham ahmed", "mariam yasser" };
    static String[] transactionReceivers = { "mariam yasser", "fatma ashraf", "adham ahmed", "fatma ashraf", "adham ahmed", "mariam yasser", "fatma ashraf", "adham ahmed" };
     static String[] transactionStatuses = { "SUCCESS", "SUCCESS", "SUCCESS", "SUCCESS", "SUCCESS", "FAILED", "FAILED","FAILED" };
     static String[] useroptions = { "1. Show Balance", "2. Transfer money","3. Transaction History", "4. Add Favorites ","5. Show Favorites", "6. Remove Favorites", "7. Search Recipient ","8. View Profile", "9. Update Profile", "10. logout" };
    static {
        // first user 
        ids[0] = 111;
        usernames[0] = "Adham Ahmed";
        password[0] = "12345";
        balance[0] = 20000;
        phones[0] = "01012345678";
        emails[0] = "adham@mail.com";
        isblocked[0] = false;
        isactive[0] = true; 
        //SECOND USER
          // User 2
        ids[1] = 222;
        usernames[1] = "Mariam yasser";
        password[1] = "134340";
        balance[1] = 90000;
        phones[1] = "01123456789";
        emails[1] = "mariam@mail.com";
        isblocked[1] = false;
        isactive[1] = true;
        // THIRD USER 
        ids[2] = 333;
        usernames[2] = "Fatma Ashraf";
        password[2] = "3211145";
        balance[2] = 300000;
        phones[2] = "01234567890";
        emails[2] = "fatma@mail.com";
        isblocked[2] = false;
        isactive[2] = true;
    }

    static int option;
    static boolean running = true;

    // methods
    // show balance method
    static void Showbalance(int currentuser) {
        System.out.println("Your balance : " + balance[currentuser]);

    }
    // transfer money
    static void Transfermoney(int currentuser) {
        System.out.println("Enter recipient phone number or email");
        String recipientinput = input.nextLine();
        int recpient = -1;
        for (int i = 0; i < registeredUsersCount; i++) {
            if (phones[i].equalsIgnoreCase(recipientinput) == true || emails[i].equalsIgnoreCase(recipientinput) == true) {
                recpient = i;
            }
        }
        if (recpient == -1) {
            System.out.println("recipient not found");
            return;
        }
        if (isactive[currentuser] == false) {
            System.out.println("Your account is not active");
            return;
        }
        if (isactive[recpient] == false) {
            System.out.println("This recipient is not active");
            return;
        }
        if (currentuser == recpient) {
            System.out.println("you can't transfer money to your self");
            return;
        }

        System.out.println("Enter amount to be transferred");
        long amount = input.nextLong();
        input.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount pls try again");
            return;
        }
        if (amount > balance[currentuser]) {
            System.out.println("Not enough balance");
            // تسجيل العملية كفاشلة عند الأدمن
            senderhistory[count] = currentuser;
            receiverhistory[count] = recpient;
            amounttansferd[count] = amount;
            status[count] = "Failed";
            faildtransactions++;
            count++;
            return;
        }

        // خصم المبلغ من المرسل وإضافته للمستقبل (تحديث الرصيد)
        balance[currentuser] -= amount;
        balance[recpient] += amount;

        System.out.println("transfer successful");
        System.out.println("Your current balance : " + balance[currentuser]);

        // حفظ العملية بنجاح في سجل المعاملات للأدمن واليوزر
        senderhistory[count] = currentuser;
        receiverhistory[count] = recpient;
        amounttansferd[count] = amount;
        status[count] = "Success";
        successfultransactions++;
        count++;
    }
    // Show transaction history
    static void Showtransactionhistory(int currentuser) {
        for (int j = 0; j < transactionIDs.length; j++) {
        System.out.println("Transaction ID :" + transactionIDs[j]);
        System.out.println("Sender :" + transactionSenders[j]);
        System.out.println("Recever :" + transactionReceivers[j]);
        System.out.println("Amount :" + amountofsuctran[j]);
        System.out.println("Status :" + transactionStatuses[j]);
        }
        for (int i = 0; i < count; i++) {
        System.out.println("Transaction ID :" + (109 + i));
        System.out.println("Sender :" + usernames[senderhistory[i]]);
        System.out.println("Recever :" + usernames[receiverhistory[i]]);
        System.out.println("Amount :" + amounttansferd[i]);
        System.out.println("Status :" + status[i]);
            }
        }
    

    // methods are not in order here
    // view profile methods
    static void viewprofile(int currentuser) {
        System.out.println("Username : " + usernames[currentuser]);
        System.out.println("Phone number : " + phones[currentuser]);
        System.out.println("Email : " + emails[currentuser]);
        System.out.println("Balance : " + balance[currentuser]);
    }

    // search recipient
    static void Searchrecipient() {
        System.out.println("Enter recipient phone number or email");
        String recipientsearch = input.nextLine();
        for (int i = 0; i < registeredUsersCount; i++) {
            if (phones[i].equalsIgnoreCase(recipientsearch) || emails[i].equalsIgnoreCase(recipientsearch)) {
                System.out.println("Found " + usernames[i] + "  " + emails[i]);
                return;
            }
        }
        System.out.println("Can't find recipient " + recipientsearch);
    }

    // update profile
    static void Updateprofile(int currentuser) {
        System.out.println("1. Change Email");
        System.out.println("2. Change Phone Number");
        System.out.println("3. Change Username");
        System.out.println("4. Change Password");
        System.out.println("Enter your choice");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            System.out.println("Enter new email");
            emails[currentuser] = input.nextLine();
            System.out.println("Email updated ");
        } else if (choice == 2) {
            System.out.println("Enter new phone number");
            phones[currentuser] = input.nextLine();
            System.out.println("Phone number updated ");
        } else if (choice == 3) {
            System.out.println("Enter new username");
            usernames[currentuser] = input.nextLine();
            System.out.println("Username updated ");
        } else if (choice == 4) {
            System.out.println("Enter new password");
            password[currentuser] = input.nextLine();
            System.out.println("Password updated ");
        } else {
            System.out.println("Invalid choice");
        }
    }
    // add to fav method

    static void Addtofavourite(int currentuser) {
        System.out.println("Enter Email or phone number");
        String Favouritecontact = input.nextLine();
        int friend = -1;
        for (int i = 0; i < registeredUsersCount; i++) {
            if (emails[i].equalsIgnoreCase(Favouritecontact) || phones[i].equalsIgnoreCase(Favouritecontact)) {
                friend = i;
            }
        }
        if (friend == -1) {
            System.out.println("Userr not found");
            return;
        }
        if (friend == currentuser) {
            System.out.println("You Cannot add yourself to favourites");
            return;
        }
        if (favourites[currentuser][friend]) {
            System.out.println("You already added a favourite");
            return;
        }
        favourites[currentuser][friend] = true;
        System.out.println("Added to favourite");
    }

    // remove favourites
    static void Removefavourite(int currentuser) {
        System.out.println("Enter Email or phone number");
        String Favouritecontact = input.nextLine();
        int friend = -1;
        for (int i = 0; i < registeredUsersCount; i++) {
            if (Favouritecontact.equalsIgnoreCase(emails[i]) || phones[i].equalsIgnoreCase(Favouritecontact)) {
                friend = i;
            }
        }
        if (friend == -1) {
            System.out.println("Userr not found");
            return;
        }
        if (!favourites[currentuser][friend]) {
            System.out.println("This user is  not added to ur favourite");
            return;
        }
        favourites[currentuser][friend] = false;
        System.out.println("Removed from favourite");
    }

    // Show fav method
    static void Showfavourites(int currentuser) {
        boolean favshowing = false;
        for (int i = 0; i < usernames.length; i++) {
            if (favourites[currentuser][i]) {
                System.out.println("Userr " + usernames[i]);
                favshowing = true;
            }
        }
        if (!favshowing) {
            System.out.println("You Have No Favourites");
        }
    }

    static void adminpanal() {
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
                    break;
                case 6:
                    blockAccount();
                    break;
                case 7:
                    unblockAccount();
                    break;
                case 8:
                    viewUserDetails();
                    break;
                case 9:
                    break;

                default:
                    System.out.println("INVALID CHOISE!");

            }
        } while (chose != 9);
    }

    static void printuserdata(int i) {
        System.out.println("========== User Found ==========");
        System.out.println("ID:" + ids[i]);
        System.out.println("USERNAME:" + usernames[i]);
        System.out.println("Balance:" + balance[i]);
        System.out.println("Email Adress:" + emails[i]);
        System.out.println("phone:" + phones[i]);
        System.out.println("Status:" + (isblocked[i] ? "Blocked" : "Active"));

    }

    static void showStatistics() {
        // show overall statistics (total users,total balances,blocked accounts....)
        System.out.println("========== Show Statistics ==========");
        int totalusers = registeredUsersCount;
        int activeusers = 0;
        int blockredusers = 0;
        double totaltransurfferd = 0;
        for (int i = 0; i < registeredUsersCount; i++) {
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
        // Searches for a user using 4 options(ID,FULLNAME,EMAIL,PHONE)
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
            case 1:// Search by user id
                System.out.println("Enter ID to search:");
                int idsearch = input.nextInt();
                input.nextLine();
                for (int i = 0; i < registeredUsersCount; i++) {
                    if (ids[i] == idsearch) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            case 2:// Search by fullname(case-insensitive)
                System.out.println("Enter full name to search");
                String namesearch = input.nextLine();
                for (int i = 0; i < registeredUsersCount; i++) {
                    if (usernames[i].equalsIgnoreCase(namesearch)) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            case 3:// Search by phone number
                System.out.println("Enter phone number to search:");
                String phonesearch = input.nextLine();
                for (int i = 0; i < registeredUsersCount; i++) {
                    if (phones[i].equalsIgnoreCase(phonesearch)) {
                        printuserdata(i);
                        isfound = true;
                        break;
                    }
                }
                break;
            case 4:// Search by email(case-insensitive)
                System.out.println("Enter Email addres to search:");
                String EMAILSEARCH = input.nextLine();
                for (int i = 0; i < registeredUsersCount; i++) {
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
        // Shows a list of all users registered in the system
        System.out.println("========== View All Users ==========");
        // Check for empty arrays
        if (registeredUsersCount== 0) {
            System.out.println("NO USER FOUND");
            return;
        }
        // loop goes through all users and print thier data
        for (int i = 0; i < registeredUsersCount; i++) {
            System.out.println("User:" + (i + 1));
            printuserdata(i);
        }

    }

    static void updateUser() {
        // Updates specific information about a selected user by entering their IDs
        System.out.println("Enter user ID to update:");
        int idforuser = input.nextInt();
        input.nextLine();
        boolean isfound = false;
        for (int i = 0; i < registeredUsersCount; i++) {
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
                        System.out.println("Enter new Username:");
                        String OLDNAME = usernames[i];
                        usernames[i] = input.nextLine();
                        String newName = usernames[i];
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
                    case 2:
                        System.out.println("Enter new Email");
                        emails[i] = input.nextLine();
                        System.out.println("Email updated successfully ");
                        break;
                    case 3:
                        System.out.println("Enter new phone number:");
                        phones[i] = input.nextLine();
                        System.out.println("Phone Number updated successfully");
                        break;
                    default:
                        System.out.println("INVALID CHOICE!");
                }
                break;

            }
        }
        if (!isfound) {
            System.out.println("User not found");
        }
    }

    static void showTransactionHistory() {
        // shows all transactions history
        System.out.println("========== ALL TRANSACTIONS HISTROY ==========");
        if (transactionIDs.length == 0) {
            System.out.println("NO transactions found");
            return;
        }
        for (int i = 0; i < transactionIDs.length; i++) {
            System.out.println("Transaction ID :" + (109+i));
            System.out.println("Sender :" + usernames[senderhistory[i]]);
            System.out.println("Recever :" + usernames[receiverhistory[i]]);
            System.out.println("Amount :" + amountofsuctran[i]);
            System.out.println("Status :" + transactionStatuses[i]);
            System.out.println("--------------------------------------------------");
        }

    }

    static void blockAccount() {
        // block accounts baisd on ID
        System.out.println("Enter user ID to block");
        int idtoblock = input.nextInt();
        input.nextLine();
        boolean isfound = false;
        for (int i = 0; i < registeredUsersCount; i++) {
            if (ids[i] == idtoblock) {
                isfound = true;
                if (isblocked[i]) {
                    System.out.println("This Acount is Already blocked");
                } else {
                    isblocked[i] = true;
                    System.out.println("Acount For" + " " + usernames[i] + " " + "blocked successfully.");
                }
                break;
            }
        }
        if (!isfound) {
            System.out.println("User not found");
        }
    }

    static void unblockAccount() {
        // to unblock user baisd on ID
        System.out.println("Enter user ID to unblock");
        int idtounblock = input.nextInt();
        input.nextLine();
        boolean isfound = false;
        for (int i = 0; i < registeredUsersCount; i++) {
            if (ids[i] == idtounblock) {
                isfound = true;
                if (isblocked[i]) {
                    isblocked[i] = false;
                    System.out.println("Acount for" + " " + usernames[i] + " " + "is unblocked successfully");
                }
                else{
                    System.out.println("this account is not blocked ");
                }
                break;
            }
        }
        if (!isfound) {
            System.out.println("User not found");
        }

    }

    static void viewUserDetails() {
        // shows detailed information about a specific user
        System.out.println("========== Detaild information ==========");
        if (ids.length == 0) {
            System.out.println("NO USER FOUND");
            return;
        }
        System.out.println("Enter an IDs to search for its information");
            int id = input.nextInt();
            input.nextLine();
        for (int i = 0; i < registeredUsersCount; i++)
         {
            if (ids[i] == id) 
            {
                System.out.println("USER IS FOUND");
                printuserdata(i);
                break;
            }
            else 
            {
                System.out.println("user is not found");
            }
        }
        
    }

    static void login() 
    {
        String menu[] = { "1. Login as admin", "2. Login as user ", "3. Sign Up", "4. Exit" };
        // هنا علشان اول ما يدوس لوج اوت يرجع للماين منيو
        running = true;
        while (running) {
            System.out.println("==== Quick Pay ====");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(menu[i]);
            }
            // هنا بيختار من الاوبشنز بعد ما سجل كيوزر
            System.out.println("Choose an option");
            option = input.nextInt();
            input.nextLine();
            
            // 1. لوجين الأدمن مع الـ Validation
            if (option == 1) {
                System.out.println("Enter the username you want to login by");
                String usernameadmin = input.nextLine();
                if (isValidName(usernameadmin) == false) {
                    System.out.println("Invalid username format");
                    continue;
                }
                System.out.println("Enter the phone number you want to login by");
                String phonenumbersadmin = input.nextLine();
                if (isValidPhone(phonenumbersadmin) == false) {
                    System.out.println("Invalid phone format");
                    continue;
                }
                
                boolean isadmin = false;
                for (int j = 0; j < usernamesadmin.length; j++) {
                    if (usernamesadmin[j].equalsIgnoreCase(usernameadmin) == true
                            && phoneforadminpanalp[j].equalsIgnoreCase(phonenumbersadmin) == true) {
                        System.out.println("You are successfully logged in");
                        isadmin = true;
                        adminpanal();
                        break;
                    }
                }

                if (isadmin == false) {
                    System.out.println("Invalid admin information");
                }
            }

            // 2. لوجين اليوزر مع الاسم، الرقم، والباسورد
            if (option == 2) {
                System.out.println(" Enter the username you want to login by");
                String username = input.nextLine();
                if (isValidName(username) == false) {
                    System.out.println("Invalid username format");
                    continue;
                }

                System.out.println(" Enter the phone number you want to login by");
                String phonenumber = input.nextLine();
                if (isValidPhone(phonenumber) == false) {
                    System.out.println("Invalid phone format");
                    continue;
                }
                
                System.out.println(" Enter your password");
                String pass = input.nextLine();
                if (isValidPassword(pass) == false) {
                    System.out.println("Invalid password format");
                    continue;
                }
                
                // علشلن الاسم لو غلط هو والرقم والباسورد
                boolean found = false;
                // علشان يبقى فاكر اليوزر طول ما بنستخدم البرنامج على حسب انديكس ال array
                int currentuser = -1;
                for (int i = 0; i < registeredUsersCount; i++) {
                    // بيلوب على الاراي و يشوف لو اليوزر نيم و الرقم والباس متطابقين
                    if (usernames[i].equalsIgnoreCase(username) == true && phones[i].equalsIgnoreCase(phonenumber) == true && password[i].equals(pass) == true) {
                        
                        if (isblocked[i] == true) {
                            System.out.println("Your account is blocked");
                            found = true;
                            break;
                        }

                        System.out.println("You are successfully logged in");
                        System.out.println("Welcome back " + usernames[i]);
                        found = true;
                        currentuser = i;
                        // علشان يظهر البانل اكتر من مرة
                        boolean loggedin = true;
                        while (loggedin == true) {
                            System.out.println("====== User Panel ======");
                            for (int j = 0; j < useroptions.length; j++) {
                                System.out.println(useroptions[j]);
                            }
                            System.out.println("choose an option");
                            option = input.nextInt();
                            input.nextLine();
                            switch (option) {
                                case 1:
                                    // اول ميثود
                                    Showbalance(currentuser);
                                    break;
                                case 2:
                                    // التانية
                                    Transfermoney(currentuser);
                                    break;
                                case 3: // التالتة
                                    Showtransactionhistory(currentuser);
                                    break;
                                case 4:
                                    Addtofavourite(currentuser);
                                    break;
                                case 5:
                                    Showfavourites(currentuser);
                                    break;
                                case 6:
                                    Removefavourite(currentuser);
                                    break;
                                case 7:
                                    Searchrecipient();
                                    break;
                                case 8:
                                    viewprofile(currentuser);
                                    break;
                                case 9:
                                    Updateprofile(currentuser);
                                    break;
                                case 10:
                                    loggedin = false;
                                    break;
                                default:
                                    if (option <= 0)
                                        System.out.println("Invalid option");
                            }

                        }
                    }

                }
                if (found == false) {
                    System.out.println("Invalied username, phone number or password");
                    System.out.println("pls try again");
                }

            }

            if (option == 3) {
                SignUp();
            }

            if (option == 4) {
                running = false;
            }
        }
    }
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
    for (int i = 0; i < registeredUsersCount; i++)
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
//14) SIGN UP METHOD 
static void SignUp ()
{
    System.out.println("===== SIGN UP =====");
    String newName = ReadText("Enter your name : ");
    if (registeredUsersCount >= Max_Users) {
    System.out.println("Registration is full. Cannot add more users.");
    return;
    }
    if (isValidName(newName) == false )
    {
        System.out.println("Invalid name! Must be at least 3 letters and contain only characters and spaces.");
        return ;
    }
    String newEmail = ReadText("Enter your email : ");
    if (isValidEmail(newEmail) == false ) 
    {
        System.out.println("Invalid email format");
        return;
    }
    if (isAlreadyExist(emails , newEmail ))
    {
        System.out.println("Email already exists");
        return;
    }
    String newPhone = ReadText("Enter your phone number : ");
    if (isValidPhone(newPhone) == false)
    {
        System.out.println("Invalid phone number must be 11 digits starting with 01 ");
        return;
    }
    if (isAlreadyExist(phones , newPhone ) == true )
    {
        System.out.println("Phone number already exists ");
        return;
    }
    String newPassword = ReadText("Enter your password : ");
    if (isValidPassword(newPassword) == false) 
    {
        System.out.println("Invalid password! Must be 5 or more characters and contain no spaces.");
        return;
    }
    long newBalance = ReadNumber("Enter your balance : ");
    if (isValidAmount(newBalance) == false)
    {
        System.out.println("Invalid amount Balance must be greater than zero ");
        return;
    }

    int index = registeredUsersCount;
    ids[index] = nextId;
    usernames[index] = newName;
    emails[index] = newEmail;
    phones[index] = newPhone;
    password[index] = newPassword;
    balance[index] = newBalance;
    isblocked[index] = false;
    isactive[index] = true;
    nextId++;
    registeredUsersCount++;
    System.out.println("Sign up successful!");
    System.out.println("Your ID is: " + ids[index]);
    System.out.println("Your balance is: " + balance[index]);
    System.out.println("You can now login.");
}
}




    

