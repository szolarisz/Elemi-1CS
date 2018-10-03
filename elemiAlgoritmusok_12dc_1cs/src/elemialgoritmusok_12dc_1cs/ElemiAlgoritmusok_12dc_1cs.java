/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elemialgoritmusok_12dc_1cs;

/**
 *
 * @author thomas
 */
public class ElemiAlgoritmusok_12dc_1cs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] vektor = { 5, 9, 11, 3, 2, 10, 15, 1, 7, 4, 15, 6, 13, 12, 8};
        //Eldöntés
        System.out.println("Eldöntés");
        int keres = 13;
        if( eldöntés(vektor,keres) )
            System.out.println("Szerepel benne");
        else
            System.out.println("Nem szerepel benne");
        System.out.println("Az 5-tel osztható számok száma a tömbben: "+
                megszámlálás(vektor));
        int [] rendezéshez = { 5, 9, 11, 3, 2, 10, 15, 1, 7, 4, 14, 6, 13, 12, 8};
        kiir(vektor);
        rendezBuborék(rendezéshez);
        kiir(rendezéshez);
        System.out.println("A max elem helye (index): "+maximum(vektor));
        System.out.println("A max elem értéke: " + vektor[maximum(vektor)]);
        System.out.println("A maximális elem a következõ helyeken forul elõ:");
        maxMind(vektor);
        
        int [] eredmény = new int[vektor.length];
        int maxDarab = kiválogatásStrázsa(vektor, eredmény);
        kiir(eredmény); //Ez nem jó
        for(int i=0; i<maxDarab; i++)
            System.out.print(eredmény[i]+" ");
        System.out.println("");
        
        int [] halmazhoz = {2,5,8,4,3,2,2,5,4,3,8,9};
        int [] halmaz = halmazKészítõ(halmazhoz);
        kiir(halmaz);
    }
    //----------------------
    
    static int [] halmazKészítõ(int [] mibõl){
        int strázsa =0;
        int [] temp = new int [mibõl.length];
        for(int elem: mibõl){
            boolean benneVan = false;
            for(int i=0; i<strázsa; i++)
                if(elem == temp[i])
                    benneVan = true;
            if(!benneVan)
                temp[strázsa++] = elem;
        }
        //Letisztázom
        int [] result = new int [strázsa];
        for(int i=0; i< strázsa; i++)
            result[i] = temp[i];
        
        return result;
    }
    
    static int kiválogatásStrázsa(int [] mibõl, int [] mibe){
        int strázsa = 0;
        for(int elem: mibõl)
            if(elem % 2 != 0) //F most páratlan
                mibe[strázsa++] = elem;
        return strázsa;
    }
    
    static void maxMind(int [] tömb){
        int maxHely = maximum(tömb);
        for(int i=0; i<tömb.length; i++) 
            if(tömb[maxHely] == tömb[i])
                System.out.print(i+" ");
        System.out.println("");
    }
    
    static int maximum(int [] tömb){
        int result = 0;
        for(int i=1; i<tömb.length; i++)
            if(tömb[result] < tömb[i])
                result = i;
        return result;
    }
    
    static void kiir(int [] tömb){
        for(int i=0; i<tömb.length -1; i++)
            System.out.print(tömb[i]+" ");
        System.out.println(tömb[tömb.length-1]);
    }
    
    static void rendezBuborék(int [] tömb){
        for(int i=0; i<tömb.length-1; i++)
            for(int j=0; j < tömb.length-1; j++)
                if(tömb[j] > tömb[j+1]){
                    int temp = tömb[j];
                    tömb[j] = tömb[j+1];
                    tömb[j+1] = temp;
                }
    }
    
    static boolean eldöntés(int [] tömb, int keres){
        boolean result = false;
        for( int elem : tömb)
            if(elem == keres){
                result = true;
                break;
            }
        return result;
    }
    
    static int keresés(int [] tömb, int keres){
        int result = -1;
        for(int i=0; i<tömb.length; i++)
            if(tömb[i] == keres){
                result = i;
                break;
            }
        return result;
    }
    
    static int megszámlálás(int [] tömb){
        // 5-tel osztható
        int darab = 0;
        for(int elem : tömb)
            if(elem % 5 == 0) //F
                darab++;
        return darab;
    }
    
    static int [] kiválogatás(int [] tömb){
        //F tulajdonság - páros
        int darab = 0;
        for(int elem: tömb)
            if(elem %2 == 0)
                darab++;
        
        int [] result = new int[darab];
        int index = 0;
        
        for(int elem: tömb)
            if(elem % 2 == 0)
                result[index++] = elem;
        
        return result;
    }
    
    
}
