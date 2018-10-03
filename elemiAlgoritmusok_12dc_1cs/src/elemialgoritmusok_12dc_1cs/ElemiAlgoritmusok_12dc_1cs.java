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
        //Eld�nt�s
        System.out.println("Eld�nt�s");
        int keres = 13;
        if( eld�nt�s(vektor,keres) )
            System.out.println("Szerepel benne");
        else
            System.out.println("Nem szerepel benne");
        System.out.println("Az 5-tel oszthat� sz�mok sz�ma a t�mbben: "+
                megsz�ml�l�s(vektor));
        int [] rendez�shez = { 5, 9, 11, 3, 2, 10, 15, 1, 7, 4, 14, 6, 13, 12, 8};
        kiir(vektor);
        rendezBubor�k(rendez�shez);
        kiir(rendez�shez);
        System.out.println("A max elem helye (index): "+maximum(vektor));
        System.out.println("A max elem �rt�ke: " + vektor[maximum(vektor)]);
        System.out.println("A maxim�lis elem a k�vetkez� helyeken forul el�:");
        maxMind(vektor);
        
        int [] eredm�ny = new int[vektor.length];
        int maxDarab = kiv�logat�sStr�zsa(vektor, eredm�ny);
        kiir(eredm�ny); //Ez nem j�
        for(int i=0; i<maxDarab; i++)
            System.out.print(eredm�ny[i]+" ");
        System.out.println("");
        
        int [] halmazhoz = {2,5,8,4,3,2,2,5,4,3,8,9};
        int [] halmaz = halmazK�sz�t�(halmazhoz);
        kiir(halmaz);
    }
    //----------------------
    
    static int [] halmazK�sz�t�(int [] mib�l){
        int str�zsa =0;
        int [] temp = new int [mib�l.length];
        for(int elem: mib�l){
            boolean benneVan = false;
            for(int i=0; i<str�zsa; i++)
                if(elem == temp[i])
                    benneVan = true;
            if(!benneVan)
                temp[str�zsa++] = elem;
        }
        //Letiszt�zom
        int [] result = new int [str�zsa];
        for(int i=0; i< str�zsa; i++)
            result[i] = temp[i];
        
        return result;
    }
    
    static int kiv�logat�sStr�zsa(int [] mib�l, int [] mibe){
        int str�zsa = 0;
        for(int elem: mib�l)
            if(elem % 2 != 0) //F most p�ratlan
                mibe[str�zsa++] = elem;
        return str�zsa;
    }
    
    static void maxMind(int [] t�mb){
        int maxHely = maximum(t�mb);
        for(int i=0; i<t�mb.length; i++) 
            if(t�mb[maxHely] == t�mb[i])
                System.out.print(i+" ");
        System.out.println("");
    }
    
    static int maximum(int [] t�mb){
        int result = 0;
        for(int i=1; i<t�mb.length; i++)
            if(t�mb[result] < t�mb[i])
                result = i;
        return result;
    }
    
    static void kiir(int [] t�mb){
        for(int i=0; i<t�mb.length -1; i++)
            System.out.print(t�mb[i]+" ");
        System.out.println(t�mb[t�mb.length-1]);
    }
    
    static void rendezBubor�k(int [] t�mb){
        for(int i=0; i<t�mb.length-1; i++)
            for(int j=0; j < t�mb.length-1; j++)
                if(t�mb[j] > t�mb[j+1]){
                    int temp = t�mb[j];
                    t�mb[j] = t�mb[j+1];
                    t�mb[j+1] = temp;
                }
    }
    
    static boolean eld�nt�s(int [] t�mb, int keres){
        boolean result = false;
        for( int elem : t�mb)
            if(elem == keres){
                result = true;
                break;
            }
        return result;
    }
    
    static int keres�s(int [] t�mb, int keres){
        int result = -1;
        for(int i=0; i<t�mb.length; i++)
            if(t�mb[i] == keres){
                result = i;
                break;
            }
        return result;
    }
    
    static int megsz�ml�l�s(int [] t�mb){
        // 5-tel oszthat�
        int darab = 0;
        for(int elem : t�mb)
            if(elem % 5 == 0) //F
                darab++;
        return darab;
    }
    
    static int [] kiv�logat�s(int [] t�mb){
        //F tulajdons�g - p�ros
        int darab = 0;
        for(int elem: t�mb)
            if(elem %2 == 0)
                darab++;
        
        int [] result = new int[darab];
        int index = 0;
        
        for(int elem: t�mb)
            if(elem % 2 == 0)
                result[index++] = elem;
        
        return result;
    }
    
    
}
