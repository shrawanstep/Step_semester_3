public class ProductInventoryCsvParser {
    public static void main(String[] args) { parseInventoryRecord("Wireless Mouse,WM-2201,150"); parseInventoryRecord("Wireless Mouse,150"); }
    static void parseInventoryRecord(String line) { String[] f=line.split(","); if(f.length!=3) System.out.println("Invalid Record"); else System.out.println("Product: "+f[0]+" | SKU: "+f[1]+" | Qty: "+f[2]); }
}
