
package Main;

import AdminTask.AdminTask;
import AdminTask.AdminTaskController;
import Customer.Customer;
import Customer.CustomerController;
import Invoice.Invoice;
import Invoice.InvoiceController;
import Invoice.InvoiceItemController;
import Product.Product;
import Product.ProductController;
import User.User;
import User.UserController;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        AdminTask admin1=new AdminTask();
        
        User u1=new User();
        String uID,pass;
        int mainMenuController,subMenuController;
        String mainExit="y";
        String subExit="y";
        try{
            
            
        
        System.out.println("****** ---    Welcome to The Ivoice System ---   ******");
        System.out.print("Please enter User ID: ");
        u1.setUserID(scan.next());
        System.out.print("Please enter Password: ");
        u1.setUserPassword(scan.next());
        
        
        //call login function
        boolean x=UserController.loginUser(u1);
        
        if(x==false){
            System.out.println("access denied!..Username or Password Incorrect.");
            
            admin1.setTaskInformation("Access Denied! Login Failed");
            AdminTaskController.addTask(admin1);
        }else{
            admin1.setTaskInformation("Access Granted | Successfully Log Into The System");
            AdminTaskController.addTask(admin1);
            
            do{
                System.out.println("\n*****--- Invoice generate System Main Menu ---*****\n");
                //main menu
                System.out.println("1.) Manage Products");
                System.out.println("2.) Manage Customers");
                System.out.println("3.) Invoice Generation");
                System.out.println("4.) Display All Invoices");
                System.out.println("5.) Admin Tasks");
                System.out.println("6.) Exit from the System");

                System.out.print("Please enter the Number to Select a Menu Item : ");
                //getting user input to select main menu item
                mainMenuController=scan.nextInt();
            
                //end of main menu
                
                if(mainMenuController==1){
                    
                    System.out.println("\n*****--- You selected Manage Products from the Main Menu ---*****\n");
                    Product p1=new Product();
                    
                    do{
                        System.out.println("These are the Products Managements");
                        //products menu
                        System.out.println("1.) Add New Product");
                        System.out.println("2.) Delete A Product");
                        System.out.println("3.) Update A Product");
                        System.out.println("4.) Display A product Details");
                        System.out.println("5.) Display All the Products details");
                        System.out.println("6.) Back to Main menu");

                        System.out.print("\nEnter the number of the Selected Function : ");
                        //getting user selection to products
                        subMenuController=scan.nextInt();
                        
                        switch(subMenuController){
                                                
                            //add product
                            case 1:
                                System.out.println("\n**- You Selected Add A New Product Function -**\n");

                                System.out.print("Eneter Product ID: ");
                                p1.setProductID(scan.next());

                                System.out.print("Enter Product Name: ");
                                p1.setProductName(scan.next());

                                System.out.print("Enter Product Description: ");
                                p1.setDescription(scan.next());

                                System.out.print("Enter Product Purchase Price: ");
                                p1.setPurchasePrice(scan.nextDouble());

                                System.out.print("Enter Product Selling Price: ");
                                p1.setSellingPrice(scan.nextDouble());

                                System.out.print("Enter Product Quantity: ");
                                p1.setQuantity(scan.nextInt());

                                int i=ProductController.addProduct(p1);

                                if(i!=0){
                                    System.out.println("Product Added");
                                    admin1.setTaskInformation("A New Product Added | "+p1.getProductID()+" - "+p1.getProductName());
                                    AdminTaskController.addTask(admin1);
                                }
                                break;
                            //delete product    
                            case 2:
                                System.out.println("\n**- You Selected Delete A Product Function -**\n");

                                System.out.print("Eneter Product ID: ");
                                p1.setProductID(scan.next());

                                int j=ProductController.deleteProduct(p1);

                                if(j!=0){
                                    System.out.println("Product Deleted");
                                    admin1.setTaskInformation("A Product Deleted | "+p1.getProductID());
                                    AdminTaskController.addTask(admin1);
                                }
                                break;
                            //update product    
                            case 3:
                                System.out.println("\n**- You Selected Update A Product Function -**\n");

                                System.out.print("Eneter product ID that you want to update: ");
                                p1.setProductID(scan.next());

                                System.out.print("Enter New Product Name: ");
                                p1.setProductName(scan.next());

                                System.out.print("Enter New Product Description: ");
                                p1.setDescription(scan.next());

                                System.out.print("Enter New Product Purchase Price: ");
                                p1.setPurchasePrice(scan.nextDouble());

                                System.out.print("Enter New Product Selling Price: ");
                                p1.setSellingPrice(scan.nextDouble());

                                System.out.print("Enter New Product Quantity: ");
                                p1.setQuantity(scan.nextInt());

                                int k=ProductController.updateProduct(p1);

                                if(k!=0){
                                    System.out.println("Product Updated");
                                    admin1.setTaskInformation("A Product Updated | "+p1.getProductID());
                                    AdminTaskController.addTask(admin1);
                                }
                                break;
                            //get one product details    
                            case 4:
                                System.out.println("\n**- You Selected Display A Product Function -**\n");

                                System.out.print("Eneter product ID that you want to get Details: ");
                                p1.setProductID(scan.next());

                                ProductController.getProduct(p1);
                                admin1.setTaskInformation("A Product Displayed | "+p1.getProductID());
                                AdminTaskController.addTask(admin1);

                                break;
                            //get all the product details    
                            case 5:
                                System.out.println("\n**- You Selected Display All Products Function -**\n");

                                ProductController.getProducts();
                                admin1.setTaskInformation("All Products Displayed");
                                AdminTaskController.addTask(admin1);
                                
                                break;
                                
                            case 6:
                                break;

                            default:
                                System.out.println("Invalid Input!");
                        }
                        
                        if(subMenuController==6){
                            break;
                        }
                        System.out.println("Do you want to go back to Product Management Menu?(press y/n)");
                        subExit=scan.next();
                    
                    }while(subExit.equals("y"));

                }
                else if(mainMenuController==2){
                    
                    System.out.println("\n*****--- You selected Manage Customers from the Main Menu ---*****\n");
                    Customer c1=new Customer();
                    
                    do{
                        System.out.println("These are the Customers Managements");
                        //customers menu
                        System.out.println("1.) Add New Customer");
                        System.out.println("2.) Delete A Customer");
                        System.out.println("3.) Update A Customer");
                        System.out.println("4.) Display A Customer Details");
                        System.out.println("5.) Display All the Customers details");
                        System.out.println("6.) Back to Main menu");

                        System.out.print("\nEnter the number of the Selected Function : ");
                        //getting user selection to products
                        subMenuController=scan.nextInt();
                    
                        switch(subMenuController){
                            //add customer
                            case 1:
                                System.out.println("\n**- You Selected Add A New Customer Function -**\n");

                                System.out.print("Eneter Customer ID: ");
                                c1.setCustomerID(scan.next());

                                System.out.print("Enter Customer Name: ");
                                c1.setCustomerName(scan.next());

                                System.out.print("Enter Customer Email: ");
                                c1.setEmail(scan.next());

                                System.out.print("Enter Customer Address:");
                                c1.setAddress(scan.next());

                                System.out.print("Enter Customer Contact Number: ");
                                c1.setContactNumber(scan.nextInt());

                                System.out.println("Enter Customer Date of Birth(YYYY-MM-DD): ");
                                c1.setDateOfBirth(scan.next());

                                System.out.println("Enter Customer Gender: ");
                                c1.setGender(scan.next());

                                int i=CustomerController.addCustomer(c1);

                                if(i!=0){
                                    System.out.println("Customer Added");
                                    admin1.setTaskInformation("A New Customer Added | "+c1.getCustomerID()+"-"+c1.getCustomerName());
                                    AdminTaskController.addTask(admin1);
                                }
                                break;
                            //delete customer    
                            case 2:
                                System.out.println("\n**- You Selected Delete A Customer Function -**\n");

                                System.out.print("Eneter Customer ID: ");
                                c1.setCustomerID(scan.next());

                                int j=CustomerController.deleteCustomer(c1);

                                if(j!=0){
                                    System.out.println("Customer Deleted");
                                    admin1.setTaskInformation("A Customer Deleted | "+c1.getCustomerID());
                                    AdminTaskController.addTask(admin1);
                                }
                                break;
                            //update Customer    
                            case 3:
                                System.out.println("\n**- You Selected Update A Customer Function -**\n");

                                System.out.print("Eneter Customer ID that you want to update: ");
                                c1.setCustomerID(scan.next());

                                System.out.print("Enter New Customer Name: ");
                                c1.setCustomerName(scan.next());

                                System.out.print("Enter New Customer Email: ");
                                c1.setEmail(scan.next());

                                System.out.print("Enter New Customer Address:");
                                c1.setAddress(scan.next());

                                System.out.print("Enter New Customer Contact Number: ");
                                c1.setContactNumber(scan.nextInt());

                                System.out.print("Enter New Customer Date of Birth(YYYY-MM-DD): ");
                                c1.setDateOfBirth(scan.next());

                                System.out.print("Enter New Customer Gender: ");
                                c1.setGender(scan.next());

                                int k=CustomerController.updateCustomer(c1);

                                if(k!=0){
                                    System.out.println("Customer Updated");
                                    admin1.setTaskInformation("A Customer updated | "+c1.getCustomerID());
                                    AdminTaskController.addTask(admin1);
                                }
                                break;
                            //get one customer details    
                            case 4:
                                System.out.println("\n**- You Selected Display A Customer Function -**\n");

                                System.out.print("Eneter Customer ID that you want to get Details: ");
                                c1.setCustomerID(scan.next());

                                CustomerController.getCustomer(c1);
                                admin1.setTaskInformation("A Customer details Displayed");
                                AdminTaskController.addTask(admin1);
                                break;
                            //get all customers details    
                            case 5:
                                System.out.println("\n**- You Selected Display All Customers Function -**\n");

                                CustomerController.getCustomers();
                                admin1.setTaskInformation("All Customers Displayed");
                                AdminTaskController.addTask(admin1);
                                
                                break;

                            case 6:
                                break;

                            default:
                                    System.out.println("Invalid Input!");
                        }
                        if(subMenuController==6){
                            break;
                        }

                        System.out.println("Do you want to go back to Product Management Menu?(press y/n)");
                        subExit=scan.next();
                        }while(subExit.equals("y"));
                    
                }
                else if(mainMenuController==3){
                    //invoice generate process
                    System.out.println("\n*****--- You selected Invoice Generation from the Main Menu ---*****\n");
                    Invoice inv1=new Invoice();
                    
                    System.out.print("Enter Invoice ID Number: ");
                    inv1.setInvoiceNumber(scan.next());
                    
                    
                    boolean invoiceAuth=InvoiceController.checkInvoiceNo(inv1);
                    
                    if(invoiceAuth==false){
                        System.out.println("Invalid Invoice ID or This ID Already Taken");
                    }else{
                        System.out.println("valid invoice ID");
                        
                        
                        System.out.print("Enter Customer ID: ");
                        //String cus=scan.next();
                        inv1.setCustomerID(scan.next());

                        Customer c2=new Customer();
                        c2.setCustomerID(inv1.getCustomerID());

                        boolean cusAuth=CustomerController.customerCheck(c2);

                        if(cusAuth==false){
                            System.out.println("\n!!! Invalid Customer ID !!!\n");
                        }else{
                            CustomerController.getCustomer(c2);
                            String addItem="y";
                            Product p2=new Product();

                            double totalDiscountOfInvoice=0.0;
                            double totalAmountOfInvoice=0.0;

                            do{
                                //adding Product to invoice

                                //get product ID
                                System.out.print("\nEnter product ID: ");
                                p2.setProductID(scan.next());

                                //checking product availability
                                boolean productExits=ProductController.checkProductExists(p2);
                                if(productExits==false){
                                    System.out.println("Invalid Product ID!");
                                }
                                else{
                                    //if the product exists, now adding the product items to the Invoice
                                    ProductController.getProduct(p2);

                                    System.out.print("\nEnter Product Quantity: ");
                                    inv1.setItemQuantity(scan.nextInt());

                                    System.out.print("Enter Discount for per Product: ");
                                    inv1.setPerItemDiscount(scan.nextDouble());
                                    //totalDiscountOfInvoice+=inv1.getPerItemDiscount()*inv1.getItemQuantity();

                                    boolean availability=ProductController.checkProductQuantityAvailability(p2);

                                    if (availability==true){

                                        System.out.println("\nyeah! we have stock!!!!");

                                        //invoice id
                                        System.out.println("Invoice No = "+inv1.getInvoiceNo());

                                        //product id setting to invoice
                                        inv1.setProductID(p2.getProductID());
                                        System.out.println("product id is "+inv1.getProductID());

                                        //quantity store into invoice
                                        //inv1.setItemQuantity(p2.getQuantity());
                                        System.out.println("product quantity for invoice "+inv1.getItemQuantity());
                                        //update current available stock on product table
                                        p2.setProductID(inv1.getProductID());
                                        p2.setQuantity(inv1.getItemQuantity());
                                        int updatedStock=ProductController.updateProductStock(p2);
                                        if(updatedStock!=0){System.out.println("---------product stock has been updated!------");}

                                        //get product selling price
                                        inv1.setUnitPerPrice(ProductController.getProductUnitPrice(p2));
                                        System.out.println("invoice added unit price is "+inv1.getUnitPerPrice());

                                        //get discount per product
                                        System.out.println("Discount per Item is = "+inv1.getPerItemDiscount());
                                        //total product discount calculation
                                        totalDiscountOfInvoice+=(inv1.getPerItemDiscount()*inv1.getItemQuantity());

                                        //display item total price
                                        inv1.setPerItemTotal(InvoiceItemController.itemTotalPriceCalculation(inv1.getUnitPerPrice(),inv1.getPerItemDiscount(),inv1.getItemQuantity()));
                                        System.out.println("total item price= Rs."+inv1.getPerItemTotal());
                                        //total product price calculation
                                        totalAmountOfInvoice+=inv1.getPerItemTotal();

                                        //add one particular item record to invoice item table
                                        int addItemToInvoice=InvoiceItemController.addItemToInvoice(inv1);
                                        if(addItemToInvoice!=0){
                                            System.out.println("***-- The Product added to the Invoice --***");
                                            admin1.setTaskInformation("A New Invoice Generated | "+inv1.getInvoiceNo());
                                            AdminTaskController.addTask(admin1);
                                        }


                                    }else{
                                        System.out.println("\nSorry there is no Stock available!\n");
                                    }


                                }

                                System.out.print("\nDo you want Add another Product to Invoice(press y/n): ");
                                addItem=scan.next();
                            }while(addItem.equals("y"));

                            //add invoice
                            inv1.setInvoiceTotalAmount(totalAmountOfInvoice);
                            inv1.setInvoiceTotalDiscount(totalDiscountOfInvoice);
                            int addInvoice=InvoiceController.addInvoice(inv1);
                            if(addInvoice!=0){
                                System.out.println("Invoice Created");
                            }

                        }                                       
                        
                        
                    }
                    
                    
                }
                else if(mainMenuController==4){
                
                    InvoiceController.getInvoices();
                    admin1.setTaskInformation("All Invoices Displayed");
                    AdminTaskController.addTask(admin1);
                }
                else if(mainMenuController==5){
                    //admin task
                    System.out.println("\n*****--- You selected Admin Task from the Main Menu ---*****\n");
                    AdminTaskController.getTasks();
                    admin1.setTaskInformation("All Admin Tasks Displayed");
                    AdminTaskController.addTask(admin1);
                    
                    
                    
                }
                else if(mainMenuController==6){
                    break;
                }
                else{
                    
                }
                
                System.out.println("\nDo you want to go back to Main menu?(press y/n)");
                mainExit=scan.next();
                
            }while(mainExit.equals("y"));
            
            System.out.println("\nThank you!\n");
            admin1.setTaskInformation("LogOut From the System");
            AdminTaskController.addTask(admin1);
                
        }

        }
        catch(ClassNotFoundException ex){
            System.out.println("class not founded!");
        }catch(SQLException ex){
            System.out.println("SQL error!");
        }
        
    }
    
}
