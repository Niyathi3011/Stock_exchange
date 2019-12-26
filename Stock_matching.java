import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


class Stock_matching {
	
	 Stock_det D=new Stock_det();
	 HashMap<Integer,Double>hm=new HashMap<>();
	 
	public void order_matching() {
	   int n= D.order_id.length;

	   for(int i=0;i<n;i++)
	   {
		   if(D.buy_sell[i].matches("Buy"))
		    for(int j=0;j<i;j++)
		    {
		    	if(D.price[j] < D.price[i] && D.buy_sell[j].matches("Sell"))
			    if(D.qty[j]!=0)
			     hm.put(j, D.price[j]);
		    }
		 
		   HashMap<Integer, Double> hm1 = sortByValue(hm); 
		   
		   for (HashMap.Entry<Integer,Double> en : hm1.entrySet())
		   {
			   print_output(i,en.getKey());
		   }
		   
		   hm.clear();
	   }
	   
	}
	
	public void print_output(int i,int j) {
		
		int qty;
		if(D.qty[j]<D.qty[i]) {
			qty=D.qty[j];
			D.qty[j]=0;
			D.qty[i]-=qty;
		}
		
		else{
			qty=D.qty[i];
			D.qty[j]-=qty;
		}
		
	
		System.out.println(D.order_id[j]+" "+D.order_id[i]+" "+ qty+" "+D.price[j]);
	}
	
	 public static HashMap<Integer, Double> sortByValue(HashMap<Integer, Double> hm2) 
	    { 
	      
	        LinkedList<Map.Entry<Integer,Double> > list = 
	               new LinkedList<Map.Entry<Integer,Double> >(hm2.entrySet()); 
	  
	    
	        Collections.sort(list, new Comparator<Map.Entry<Integer, Double> >() { 
	            public int compare(Map.Entry<Integer,Double> o1, Map.Entry<Integer, Double> o2) 
	            { 
	                return (o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        });  
	        HashMap<Integer, Double> temp = new LinkedHashMap<Integer, Double>(); 
	        for (HashMap.Entry<Integer,Double> aa : list) { 
	            temp.put(aa.getKey(), aa.getValue()); 
	        } 
	        return temp; 
	    } 

	public static void main(String[] args) {
		
	    Stock_matching st=new Stock_matching();
	   
	    st.order_matching();
  
	}

}
