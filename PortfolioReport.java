import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Integer;
import java.lang.Double;
import java.util.ArrayList;

/**
 * This program creates a portfolio by reading the transactions in
 * the file transactions.txt and buying and selling stock shares
 * accordingly.  Then, this program prints the portfolio report
 * as described in the problem set 2 instructions.
 *
 * @author Matthew Hill
 * @version 2/24/2023
 */
public class PortfolioReport
{
    /**
     * This program creates a portfolio by reading the transactions in
     * the file transactions.txt and buying and selling stock shares
     * accordingly.  Then, this program prints the portfolio report
     * as described in the problem set 2 instructions.
     * 
     * @param args No command line arguments required.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File("transactions.txt"));        
        Portfolio p = new Portfolio();
        ArrayList<Double> stockPriceIndex = new ArrayList<Double>();

        while(file.hasNext()){
            String line = file.nextLine();
            String[] data = line.split(",");
            if(data[0].equals("B")){
                //Buy the stock for the portfolio.
                // p.buyStock("NTDOY", "Nintendo", 4, 10.01);
                // p.buyStock("GOOGL", "Google", 12, 91.79);
                // p.buyStock("HD", "Home Depot", 3, 295.50);
                // p.buyStock("FRND", "Friendly's Ice Cream", 4, 770.00);
                p.buyStock(data[1].trim(), data[2].trim(), Integer.parseInt(data[3].trim()), Double.parseDouble(data[4].trim()));

            } else {
                //Sell the stock from the portfolio.
                // p.sellStock("NTDOY", "Nintendo", 1, 10.01);
                // p.sellStock("GOOGL", "Google", 3, 91.79);
                // p.sellStock("HD", "Home Depot", 3, 295.50);
                // p.sellStock("FRND", "Friendly's Ice Cream", 1, 770.00);
                if (data.length == 3) {
                    p.sellStock(data[1].trim(), "", Integer.parseInt(data[2].trim()), 0);
                } else if (data.length >= 4) {
                    p.sellStock(data[1].trim(), data[2].trim(), Integer.parseInt(data[3].trim()), Double.parseDouble(data[4].trim()));
                }             
            }
        }

        System.out.print(p);
        System.out.println();

        // Uncomment the lines of code below and complete the print statements to work as intended.
        System.out.println(String.format("      Current Value:  $%,15.2f", p.getCurrentValue()));
        System.out.println(String.format("Lifetime Investment:  $%,15.2f", p.getLifetimeInvestment()));
        System.out.println(String.format("    Lifetime Payout:  $%,15.2f", p.getLifetimePayout()));
    }
}
