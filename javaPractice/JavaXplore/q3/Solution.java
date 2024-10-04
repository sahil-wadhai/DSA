package q3;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
public class Solution{
    static class Medicine{
        private String name;
        private String batch;
        private String disease;
        private int price;
        
        Medicine(){}
        Medicine(String name,String batch, String disease, int price){
            this.name = name;
            this.batch = batch;
            this.disease = disease;
            this.price = price;
        }
        
        void setName(String name){
            this.name = name;
        }
        void setBatch(String batch){
            this.batch = batch;
        }
        void setDisease(String disease){
            this.disease = disease;
        }
        void setPrice(int price){
            this.price = price;
        }
        
        String getName(){
            return this.name;
        }
        String getBatch(){
            return this.batch;
        }
        String getDisease(){
            return this.disease;
        }
        int getPrice(){
            return this.price;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        Medicine [] medArr = new Medicine[n];
        for(int i = 0 ; i<n ;i++){
            String i1 = sc.nextLine();
            String i2 = sc.nextLine();
            String i3 = sc.nextLine();
            int i4 = sc.nextInt();sc.nextLine();
            medArr[i] = new Medicine(i1,i2,i3,i4);
        }
        String disease = sc.nextLine();
        Integer [] res = getPriceByDisease(medArr,disease);
        
        System.out.println("\nOutput : ");
        if(res.length==0){
            System.out.println("No medicine with given attribute");
        }
        else
        {
            for(Integer p : res)
                System.out.println(p);
        }
        sc.close();
    }
        
    static Integer[] getPriceByDisease(Medicine [] medArr , String disease){
        List<Integer> prices = new ArrayList<>();
        for(Medicine med:medArr){
            if(med.getDisease().equalsIgnoreCase(disease)){
                prices.add(med.getPrice());
            }
        }
        
        Collections.sort(prices);
        Integer [] ans = new Integer[prices.size()];
        int i = 0;
        for(Integer p : prices){
            ans[i] = p;
            i++;
        }
        return ans;
    }  
    
}