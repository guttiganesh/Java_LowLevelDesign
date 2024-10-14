package LLD.DesignVendingMachine;

public class Inventory {
    ItemShelf[] inventory = null;

    public Inventory(int itemCount) {
        this.inventory = new ItemShelf[itemCount];
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void intialEmptyInventory(){
        int startCode = 101;
        for(int i=0;i<inventory.length;i++){
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item,int code) throws Exception {
        for(ItemShelf shelf:inventory){
            if(shelf.code == code){
                if(shelf.isSoldOut()){
                    shelf.item = item;
                    shelf.setSoldOut(false);
                }else{
                    throw new Exception("already item is present, you can not add item here");
                }
            }
        }
    }

    public Item getItem(int code) throws Exception {
        for(ItemShelf shelf:inventory){
            if(shelf.code == code){
                if(shelf.isSoldOut()) throw new Exception("item already sold out");
                else return shelf.item;
            }
        }
        return null;
    }

    public void updateSoldOutItem(int code){
        for(ItemShelf shelf:inventory){
            if(shelf.code == code){
                shelf.setSoldOut(true);
            }
        }
    }

}
