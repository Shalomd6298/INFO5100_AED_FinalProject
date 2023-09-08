/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Canteen.MealPlan;
import Business.Canteen.MealPlanDirectory;
import Business.Customer.Customer;
import Business.Customer.CustomerBillingDirectory;
import Business.Customer.CustomerDirectory;
import Business.Employer.EmployerDirectory;
import Business.PropertyManagement.Laundary;
import Business.PropertyManagement.LaundaryDirectory;
import Business.RealEstate.PropertyDirectory;
import Business.PropertyManagement.ServiceProviderDirectory;
import Business.PropertyManagement.ServiceRequest;
import Business.Services.RentalRequestDirectory;
import Business.PropertyManagement.ServiceRequestDirectory;
import Business.Recreation.Room;
import Business.Recreation.RoomDirectory;
import Business.User.User;
import Business.User.UserDirectory;
import Business.WorkRequest.LaundryWorkRequestDirectory;
import Business.WorkRequest.MealPlanWorkRequestDirectory;
import Database.mysql_db_connection;
import com.github.javafaker.Faker;



public class Network {

    static int networkId;
    private String name;
    UserDirectory userDirectory;
    CustomerDirectory customerDirectory;
    CustomerBillingDirectory customerbillingdirectory;  
    mysql_db_connection db = new mysql_db_connection();   
    PropertyDirectory propertyDirectory;
    RentalRequestDirectory rentalRequestDirectory;   
    ServiceProviderDirectory serviceproviderdir;
    ServiceRequestDirectory servicerequestdirectory;
    MealPlanDirectory mealPlanDirectory;
    MealPlanWorkRequestDirectory mealPlanworkreqDirectory;
    LaundaryDirectory laundarydirectory;
    LaundryWorkRequestDirectory laundaryworkrequestdirectory;
    RoomDirectory roomDirectory;
    EmployerDirectory employerDirectory;
    EcoSystem ecoSystem;
    User superAdmin;
    User realEstateManager;
    User propertymanager;
    User canteenmanager;
    User laundarymanager;
    User customer_shalom;
    User service_nishant;
    User recreationManager;
    User service_nick;
    MealPlanDirectory mealPlan1;
   
    public Network() {

        userDirectory = new UserDirectory();
        customerDirectory = new CustomerDirectory();
        propertyDirectory = new PropertyDirectory();
        rentalRequestDirectory = new RentalRequestDirectory();
        roomDirectory = new RoomDirectory();
        customerbillingdirectory = new CustomerBillingDirectory();
        serviceproviderdir = new ServiceProviderDirectory();
        servicerequestdirectory = new ServiceRequestDirectory();
        employerDirectory = new EmployerDirectory();
        mealPlanDirectory = new MealPlanDirectory();
        mealPlanworkreqDirectory= new MealPlanWorkRequestDirectory();
        laundarydirectory = new LaundaryDirectory();
        laundaryworkrequestdirectory = new LaundryWorkRequestDirectory();
        
        
        // pre-population of ROLES..
        // pre-population of super admin
        superAdmin = this.userDirectory.createUserAccount("admin", "admin", "System Admin", "SA0");
        
        // pre-population of different enterprise managers
        realEstateManager = this.userDirectory.createUserAccount("realmanager", "realmanager", "Real Estate Manager", "REM0");
        this.employerDirectory.newEmployerProfile("REM0", "David Furtado", "Real Estate Manager", 10f);
        
        recreationManager = this.userDirectory.createUserAccount("roommanager", "roommanager", "Recreation Manager", "RECM0");
        this.employerDirectory.newEmployerProfile("RECM0", "Tehel Hamilton", "Recreation Manager", 8.5f);

        propertymanager = this.userDirectory.createUserAccount("propertym", "propertym", "Property Manager", "PM01");
        this.employerDirectory.newEmployerProfile("PM01", "Francis Martin", "Property Manager", 6.2f);

        canteenmanager = this.userDirectory.createUserAccount("canteen", "canteen", "Canteen Manager", "CM01");
        this.employerDirectory.newEmployerProfile("CM01", "Neil Peart", "Canteen Manager", 3.5f);

        laundarymanager = this.userDirectory.createUserAccount("laundary", "laundary", "Laundary Manager", "LM01");
        this.employerDirectory.newEmployerProfile("LM01", "Gonzalo Fernandes", "Laundary Manager", 9f);
        
        // Pre-populate Service providers
        service_nishant = this.userDirectory.createUserAccount("nishant", "nishant", "Electrician", "E01");
        serviceproviderdir.createServiceProvider("E01", "Nishant", "Patel", "nishant", "nishant", 25, "nishantt@gmail.com", Long.valueOf("7894561258"), "Electrician");
 
        service_nick = this.userDirectory.createUserAccount("nick", "nick", "Plumber", "E02");
        serviceproviderdir.createServiceProvider("E02", "Nick", "Patrick", "nick", "nick", 25, "nick@gmail.com", Long.valueOf("7894561258"), "Plumber");
                
        
        // Pre-populate property listings 
        populate_Properties(4, 1, 950f, "1191 Boylston street", "Boston",  "MA", 02215d, "12 months", "True", "01-09-2023", 42.34658, -71.09343);
        populate_Properties(5, 2, 800f, "75 St Alphonsus St", "Boston",  "MA", 02120d, "12 months", "True", "01-09-2023", 42.33463, -71.10096);
        populate_Properties(4, 2, 750f, "4, 200 Northampton Street", "Boston",  "MA", 02118d, "12 months", "True", "01-09-2023", 42.33773, -71.07972);
        populate_Properties(4, 1, 1000f, "79 Glenville Ave", "Boston",  "MA", 02134d, "6 months", "True", "01-09-2023", 42.34967, -71.13442);
        
        // Pre-populate Customers 
        populate_Customers();
        
        // Pre-populate Recreational Rooms
        populateRooms();
        
        //// Pre-Populate Meal Plans
        MealPlan fb1 = new MealPlan();
            fb1.setMealId("Meal01");
            fb1.setCategory("BreakFast");
            fb1.setMealName("Meal Plan Keto 1");
            fb1.setMealDescription("Orange Juice and Omlet");
            fb1.setPrice(Double.parseDouble("7"));
        this.getMealPlanDirectory().addNewMenuData(fb1);
        
        MealPlan fb2 = new MealPlan();
            fb2.setMealId("Meal02");
            fb2.setCategory("Lunch");
            fb2.setMealName("Meal Plan Mexican");
            fb2.setMealDescription("Burrito Bowl with Rice and veggies in Chipotle style");
            fb2.setPrice(Double.parseDouble("10"));
        this.getMealPlanDirectory().addNewMenuData(fb2);
        
        MealPlan fb3 = new MealPlan();
            fb3.setMealId("Meal03");
            fb3.setCategory("Dinner");
            fb3.setMealName("Meal Plan Indian");
            fb3.setMealDescription("Paneer Curry with Garlic Naan and buttermilk");
            fb3.setPrice(Double.parseDouble("35"));
        this.getMealPlanDirectory().addNewMenuData(fb3);
        
        
        /// Pre-Populate Laundary Categories
        Laundary laundry1 = this.getLaundarydirectory().addLaundryDetails();
        laundry1.setCategory("Jeans");
        laundry1.setPrice(Float.parseFloat("5"));
        
        Laundary laundry2 = this.getLaundarydirectory().addLaundryDetails();
        laundry2.setCategory("Shirt");
        laundry2.setPrice(Float.parseFloat("3"));
        
        Laundary laundry3 = this.getLaundarydirectory().addLaundryDetails();
        laundry3.setCategory("Jacket");
        laundry3.setPrice(Float.parseFloat("6"));
        
        Laundary laundry4 = this.getLaundarydirectory().addLaundryDetails();
        laundry4.setCategory("T-Shirt");
        laundry4.setPrice(Float.parseFloat("2"));
        
        Laundary laundry5 = this.getLaundarydirectory().addLaundryDetails();
        laundry5.setCategory("Wollen Cloths");
        laundry5.setPrice(Float.parseFloat("10"));
        
        /// Pre-populate Service requests from Customer
        for (Customer c : this.getCustomerDirectory().getCustomerlist()){
        ServiceRequest sr1 = this.getServicerequestdirectory().customerServicerequest(c, "Electricity","Heater is not working", "This is demo", "Request Sent", 0);
        ServiceRequest sr2 = this.getServicerequestdirectory().customerServicerequest(c, "Plumber","Pipe is leaking", "This is demo", "Request Sent", 0);
        ServiceRequest sr3 = this.getServicerequestdirectory().customerServicerequest(c, "Electricity","TV Charger is damageed", "This is demo", "Request Sent", 0);
        ServiceRequest sr4 = this.getServicerequestdirectory().customerServicerequest(c, "Plumber","Drained is blocked", "This is demo", "Request Sent", 0);
        ServiceRequest sr5 = this.getServicerequestdirectory().customerServicerequest(c, "Electricity","Alaram is not functional", "This is demo", "Request Sent", 0);
        }
    }
    
    public static int getNetworkId() {
        return networkId;
    }

    public static void setNetworkId(int networkId) {
        Network.networkId = networkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDirectory getUserDirectory() {
        return userDirectory;
    }

    public void setUserDirectory(UserDirectory userDirectory) {
        this.userDirectory = userDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public PropertyDirectory getPropertyDirectory() {
        return propertyDirectory;
    }

    public void setPropertyDirectory(PropertyDirectory propertyDirectory) {
        this.propertyDirectory = propertyDirectory;
    }
    
    public RentalRequestDirectory getRentalRequestDirectory() {
        return rentalRequestDirectory;
    }

    public void setRentalRequestDirectory(RentalRequestDirectory rentalRequestDirectory) {
        this.rentalRequestDirectory = rentalRequestDirectory;
    }
    
    public RoomDirectory getRoomDirectory() {
        return roomDirectory;
    }

    public void setRoomDirectory(RoomDirectory roomDirectory) {
        this.roomDirectory = roomDirectory;
    }

    public CustomerBillingDirectory getCustomerbillingdirectory() {
        return customerbillingdirectory;
    }

    public void setCustomerbillingdirectory(CustomerBillingDirectory customerbillingdirectory) {
        this.customerbillingdirectory = customerbillingdirectory;
    }

    public ServiceProviderDirectory getServiceproviderdir() {
        return serviceproviderdir;
    }

    public void setServiceproviderdir(ServiceProviderDirectory serviceproviderdir) {
        this.serviceproviderdir = serviceproviderdir;
    }

    public ServiceRequestDirectory getServicerequestdirectory() {
        return servicerequestdirectory;
    }

    public void setServicerequestdirectory(ServiceRequestDirectory servicerequestdirectory) {
        this.servicerequestdirectory = servicerequestdirectory;
    }

    public MealPlanDirectory getMealPlanDirectory() {
        return mealPlanDirectory;
    }

    public void setMealPlanDirectory(MealPlanDirectory mealPlanDirectory) {
        this.mealPlanDirectory = mealPlanDirectory;
    }

    public MealPlanWorkRequestDirectory getMealPlanworkreqDirectory() {
        return mealPlanworkreqDirectory;
    }

    public void setMealPlanworkreqDirectory(MealPlanWorkRequestDirectory mealPlanworkreqDirectory) {
        this.mealPlanworkreqDirectory = mealPlanworkreqDirectory;
    }

    public LaundaryDirectory getLaundarydirectory() {
        return laundarydirectory;
    }

    public void setLaundarydirectory(LaundaryDirectory laundarydirectory) {
        this.laundarydirectory = laundarydirectory;
    }

    public LaundryWorkRequestDirectory getLaundaryworkrequestdirectory() {
        return laundaryworkrequestdirectory;
    }

    public void setLaundaryworkrequestdirectory(LaundryWorkRequestDirectory laundaryworkrequestdirectory) {
        this.laundaryworkrequestdirectory = laundaryworkrequestdirectory;
    }

    public MealPlanDirectory getMealPlan1() {
        return mealPlan1;
    }

    public void setMealPlan1(MealPlanDirectory mealPlan1) {
        this.mealPlan1 = mealPlan1;
    }
 
    public EmployerDirectory getEmployerDirectory() {
        return employerDirectory;
    }

    public void setEmployerDirectory(EmployerDirectory employerDirectory) {
        this.employerDirectory = employerDirectory;
    }
       
    
    public void populateRooms(){
        Faker faker = new Faker();
        
        Integer number = 2;
        Integer count = 01;
        
        for(int i=0; i<=number; i++){
           roomDirectory.createRoom("Room_" + count, true); 
           count ++;
        }
        
        for(Room r : roomDirectory.getRooms()){
            int randomNumber = faker.random().nextInt(11);
            r.setNo_of_requests(randomNumber);
        }
    }
    

    public void populate_Customers(){
                
        // creating a customer manually to demo login as customer
        customer_shalom = this.userDirectory.createUserAccount("shalom", "shalom", "Customer", "C01");
        customerDirectory.prePopulate("C01", "Shalom", "Daniel", "shalom", "shalom", 25, "shalomd498@gmail.com", Long.valueOf("8574151043"));
        db.db_conn("C_01", "Shalom", "Daniel", "shalom", "shalom", 25, "shalomd498@gmail.com", Long.valueOf("8574151043"));
        
        
        Faker faker = new Faker();
        
        // creating 10 random customers with fake info to populate DB
        for(int i=0;i<25;i++){
                    
            String userId = faker.regexify("C_[a-z]{4}");;
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String userName = faker.name().username();
            String password = faker.internet().password();
            int age = faker.number().numberBetween(18, 70);
            String emailId = faker.internet().emailAddress();
            Long phoneNumber = faker.number().numberBetween(1000000000L, 9999999999L);

            this.userDirectory.createUserAccount(userName, password, "Customer", userId);
            customerDirectory.prePopulate(userId, firstName, lastName,userName, password, age, emailId, phoneNumber);
            db.db_conn(userId, firstName, lastName,userName, password, age, emailId, phoneNumber);

        }
  
    }
                
    public void populate_Properties(Integer no_of_rooms, Integer no_of_bathrooms, Float price, String address, String city, String state, Double zip, String leaseType, String isAvailable, String start_date, Double latitude, Double longitude){
        
        Faker faker = new Faker();
        
        String ID = faker.regexify("P_[a-z]{4}");
        
        Boolean availability_status ;
        if(isAvailable.equals("True")){
            availability_status = true;
        }else{
            availability_status = false;
        }

        
        propertyDirectory.createProperty(ID, no_of_rooms, no_of_bathrooms, address, city, state, zip, price, leaseType, start_date, availability_status, latitude, longitude);    
        
        
//            db.db_conn(userId, firstName, lastName,userName, password, age, emailId, phoneNumber);
//
//        }
  
    } 
}