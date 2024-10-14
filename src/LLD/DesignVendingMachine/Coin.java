package LLD.DesignVendingMachine;

public enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    public int val;

    Coin(int val) {
        this.val = val;
    }
}
