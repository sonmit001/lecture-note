package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class NewReceipt implements Receipt {

	@Override
	public void print(List<Product> productList) {
		
		//보조(공통) 관심사(cross-cutting-concern)
		
		Map<Product, Integer> map = ADD(productList);
		int sum = SUM(map);
		
		Set<Map.Entry<Product, Integer>> set = map.entrySet();
		Iterator<Map.Entry<Product, Integer>> it = set.iterator();
		
		while(it.hasNext()) {
			Entry<Product, Integer> entry = it.next();
			String name = entry.getKey().productName;
			int price = entry.getKey().productPrice;
			int num = entry.getValue();
			System.out.println(name + " (수량 : " + num + ")  "+(price*num)+"원");
		}
		System.out.println("합계 : "+sum+"원");
			
		//보조(공통) 관심사(cross-cutting-concern)
		
	}

	public int SUM(Map<Product, Integer> productMap) { //모든 물건 합계
		
		Set<Map.Entry<Product, Integer>> set = productMap.entrySet();
		Iterator<Map.Entry<Product, Integer>> it = set.iterator();
		
		int sum = 0;
		
		while(it.hasNext()) {
			Entry<Product, Integer> entry = it.next();
			int price = entry.getKey().productPrice;
			int num = entry.getValue();
			sum += price * num;
		}
		
		return sum;
	}

	public Map<Product, Integer> ADD(List<Product> productList) {	//물건 추가
		
		Map<Product, Integer> map = new HashMap<>();
		
		List<Product> list = new ArrayList<>();
		Iterator<Product> it = productList.iterator();
		while(it.hasNext()) {
			Product product = it.next();
			
			int mapput = 0;
			
			for(Product p : list) {
				if(p.productName.equals(product.productName)) {
					int value = map.get(p);
					map.put(p, value+1);
					mapput = 1;
					break;
				}
			}
			
			if(mapput == 0) {
				list.add(product);
				map.put(product, 1);
			}
		}
		
		
		return map;
	}
	
	Scanner sc = new Scanner(System.in);
	
	public List<Product> AddProduct(){
		
		List<Product> list = new ArrayList<>();
		while(true) {
			
			System.out.println("*************\n"
							 + "1. 물건 선택 \n"
							 + "2. 선택 완료\n"
							 + "*************");
			
			switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					System.out.println("물건이름 ↓");
					String name = sc.nextLine();
					
					System.out.println("물건가격(같은 물건은 처음가격으로 설정됨) ↓");
					int price = Integer.parseInt(sc.nextLine());
					
					list.add(new Product(name, price));
					break;
	
				default:
					return list;
			}
		}
	}
}
