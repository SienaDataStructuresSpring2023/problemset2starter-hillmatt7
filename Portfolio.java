
import java.util.ArrayList;
import java.lang.Integer;

/**
 * Write a description of class Portfolio here.
 *
 * @author Matthew Hill
 * @version 2/24/2022
 */
public class Portfolio
{

    ArrayList<StockHolding> stocks = new ArrayList<StockHolding>();
    private int stocksCount = 0;
    private double lifetimeInvestment = 0;
    private double lifetimePayout = 0;

    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%6s%25s%10s%15s%15s%n", 
                "Symbol", "Name", "Shares", "@Price", "Total"));
        sb.append("-----------------------------------------------------------------------\n");

        for(StockHolding s : stocks){
            sb.append(s.toString());
        }
        return sb.toString();
    }

    
    /**
     * Returns index of stock in array given its symbol
     * 
     */
    private int getIndex(String stockSym){
        int index = 0;

        for (StockHolding i : stocks){
            if (stockSym.equals(i.getStockSymbol())){
                return index;
            }
            index++;
        }

        return -1;
    }

    /**
     * Buys a given stock based on the stocks symbol, shares, and price per share
     * 
     * 
     */
    public void buyStock(String symbol, String name, int shares, double price){
        for (StockHolding i : stocks){
            if (symbol.equals(i.getStockSymbol())){
                lifetimeInvestment += (price*shares);
                i.buyShares(shares, price);
                return;
            }
        }
        StockHolding stockAdd = new StockHolding(symbol, name, shares, price);
        stocks.add(stockAdd);
        lifetimeInvestment += (price*shares);
    }

    /**
     * Sells stock and returns the profit based on the same parameters for the previous method.
     * 
     * @returns profit of stock sale from the inputed parameters and changes the portfolio data accordingly to the details of the sale.
     * 
     */
    public double sellStock(String symbol, String name, int shares, double price){
        double payout = 0;
        if (price == 0){
            for (StockHolding a : stocks){
                if (symbol.equals(a.getStockSymbol())){
                    price = a.getStockPrice();
                }

            }
        }
        
        for (StockHolding i : stocks){
            if (symbol.equals(i.getStockSymbol())){
                payout = i.sellShares(shares, price);
                lifetimePayout += payout;
                if (i.getStockShares() == 0){
                    int index = getIndex(symbol);
                    stocks.remove(index);
                }
                return payout;
            }
        }
        return 0;
    }

    /**
     * Returns the current value of the portfolio
     * 
     * @returns the current value fo the portfolio based on the calculation of price per share and shares of each stock and adds it to a running total, which is then returned.
     * 
     */
    public double getCurrentValue(){
        double runningTotal = 0;
        for (StockHolding i : stocks){
            runningTotal += (i.getStockShares() * i.getStockPrice());
        }

        return runningTotal;
    }

    /**
     * 
     * @returns lifetimePayout
     */
    public double getLifetimePayout(){
        return lifetimePayout;
    }

    
    
    /**
     * 
     * @returns lifetimeInvestment
     */
    public double getLifetimeInvestment(){
        return lifetimeInvestment;
    }

}
