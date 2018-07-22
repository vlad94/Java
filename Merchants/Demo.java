package targovci;

import java.util.ArrayList;
import java.util.Random;


public class Demo {

	public static void main(String[] args) {
		
		
		
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		for(int i=1; i<=10; i++){
			int rand = new Random().nextInt(2);
			if(rand==0){
				SmallSupplier ss = new SmallSupplier("Dostavchik na drebno " + i);
				suppliers.add(ss);
			}
			else{
				BigSupplier bs = new BigSupplier("Dostavchik na edro " + i);
				suppliers.add(bs);
			}
		}
		
		ArrayList<ShoppingCentre> obekti = new ArrayList<ShoppingCentre>();
		for(int i=1; i<=20; i++){
			int rand = new Random().nextInt(3);
			if(rand==0){
				Stand sergia = new Stand(7); //area 7
				obekti.add(sergia);
			}else if (rand == 1){
				Pavilion budka = new Pavilion(5);
				obekti.add(budka);
			}else{
				MallStand mallStore = new MallStand(30);
				obekti.add(mallStore);
			}
		}
		
		Ambulant ambulant = new Ambulant("Ivan", 100);
		SoleTrader soleTrader = new SoleTrader("Consult ET", 500);
		Chain chain = new Chain("Lidl", 3000);
		ArrayList<Merchant> targovci = new ArrayList<Merchant>();
		targovci.add(ambulant);
		targovci.add(soleTrader);
		targovci.add(chain);
		
		for(ShoppingCentre sc : obekti){
			int rand = new Random().nextInt(2);
			if(rand==0){
				soleTrader.setShop(sc);
			}else{
				chain.addShop(sc);
			}
		}
		
		for(Supplier sup : suppliers){
			if(sup instanceof SmallSupplier){
				ambulant.setSmallsup((SmallSupplier) sup);
				soleTrader.addSupplier((SmallSupplier) sup); 
				chain.addSupplier(sup);
			}else{
				chain.addSupplier(sup);
			}
		}
		
		startWork(targovci);
		for(Merchant m : targovci){
			System.out.println(m.getName() + " ostana s " + m.getCapital() + " sled danaci");
		}
		
	}

	public static void startWork(ArrayList<Merchant> merchants){
		for(Merchant m : merchants){
			if(m instanceof Ambulant){
				((Ambulant) m).makeOrder(24);
				((Ambulant) m).showProducts();
				System.out.println(m.getName() + " razpolaga s " + m.getCapital() + " leva!");
				System.out.println("---------------------------------");
			}else if(m instanceof SoleTrader){
				((SoleTrader) m).makeOrder(new SmallSupplier("Ivan"), 100);
				System.out.println(((SoleTrader) m).getShop().getInventar());
				System.out.println(m.getName() + " razpolaga s " + m.getCapital() + " leva!");
				System.out.println("---------------------------------");
			}else{
				for(ShoppingCentre sc : ((Chain) m).getShops()){
				((Chain) m).makeOrder(((Chain) m).getSuppliers().get(new Random().nextInt(5)), 500, sc);
				System.out.println(sc.getInventar());
				System.out.println(m.getName() + " razpolaga s " + m.getCapital() + " leva!");
				}
			}
			m.payTaxes();
		}
		
		
	}
}
