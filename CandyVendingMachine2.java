public class CandyVendingMachine {
       public static void main(String[] args) {
               System.out.println("--- Welcome to Candy Shop --");

               ProductDispenser Candy = new ProductDispenser (0.50, 12); 
               ProductDispenser Chips = new ProductDispenser (0.65, 12); 
               ProductDispenser Gum= new ProductDispenser (0.45, 12); 
               ProductDispenser Cookies = new ProductDispenser (0.85, 12);

               CashRegister CR = new CashRegister();

               int select = 0; 
               do {

                     select = getIntInput("\n To select an item, enter \n" + "1 for Candy\n" + "2 for Chips\n" + "3 for Gum\n"+ "4 for Cookies\n" + "9 to exit \n");

                      switch (select) {
                      case 1:
                                purchase (Candy, CR);
                                break;
                      case 2:
                                purchase (Chips, CR);
                                break;
                       case 3:
                                purchase (Gum, CR);
                                break;
                        case 4:
                                purchase(Cookies, CR);
                                break;
                        case 9:
                                break;
                        default:
                                System.out.println("Invalid Selection");
                         } 
                 } while (select != 9); 
          }
          public static void purchase (ProductDispenser product, CashRegister cashreg) {
                Scanner input = new Scanner(System.in);
                if (product.getProdQty () > 0) {
                     double pmt = 0;

                     do  {
                            System.out.print("Please deposit " + (product.getProdCost() * 100 - pmt) + " cents.");
                            pmt += input.nextDouble();
                      } while (pmt < product.getProdCost() * 100);
                      product.setProdQty (1);
                      cashreg.setCashOnHand (product.getProdCost()); 
                      System.out.println("Collect your item at the bottom and enjoy.");

                }

        }