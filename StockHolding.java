/**
 * Write a description of class Asset here.
 *
 * @author Matthew Hill
 * @version 2/24/2023
 */
public class StockHolding
{

    private String stockSymbol = "";
    private String stockName = "";
    private int stockShares = 0;
    private double stockPrice = 0.0;

    /**
     * 
     * Constructor for the StockHolding class
     * 
     * @param stockSymbol (Symbol of stock), stockName(Name of stock), stockShares(Number of shares per stock), stockPrice (Price per share)
     * 
     */public StockHolding(String stockSymbol, String stockName, int stockShares, double stockPrice){
        this.stockSymbol = stockSymbol;
        this.stockName = stockName;
        this.stockShares = stockShares;
        this.stockPrice = stockPrice;
    }

    /**
     * 
     * @return returns stockSymbol
    */
    public String getStockSymbol(){
        return stockSymbol;
    }

    /**
     * 
     * @return returns stockName
    */
    public String getStockName(){
        return stockName;
    }

    
    /**
     * 
     * @return returns stockShares
    */
    public int getStockShares(){
        return stockShares;
    }

    /**
     * 
     * @return returns stockPrice
    */
    public double getStockPrice(){
        return stockPrice;
    }

    /**
     * Buys shares of the stock portfolio and updates the instance variables accordingly
     * 
     * @param takes the amount of shares to buy and the price per share as parameters
     * 
     * 
     */
    public void buyShares(int shares2Buy, double pricePerShare){
        double totalPrice = stockShares * stockPrice + shares2Buy * pricePerShare;
        stockShares += shares2Buy;
        stockPrice = totalPrice / stockShares;
    }

    /**
     * Sells shares of the stock portfolio and updates the instance variables accordingly
     * 
     * @param takes the amount of shares to sell and the price per share as parameters
     * 
     * @return returns the profit of the sale in a double
     * 
     */
    public double sellShares (int shares2Sell, double pricePerShare){
        double rVal = 0;
        if(stockShares >= shares2Sell){
            stockShares -= shares2Sell;
            stockPrice = pricePerShare;
            rVal = shares2Sell * pricePerShare;
            return rVal;
        }
        return rVal;
    }

    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", stockSymbol, stockName, stockShares, stockPrice, (stockShares * stockPrice)); 
    }
}
