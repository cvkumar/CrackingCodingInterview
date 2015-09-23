package hashTables;

import java.util.Scanner;

/* Class HashTableChainingSinglyLinkedListTest */
public class HashTableChainingSinglyLinkedListTest
{ 
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size"); 
        /* Make object of HashTableChainingSinglyLinkedList */
        HashTableChainingSinglyLinkedList htcsll = new HashTableChainingSinglyLinkedList(scan.nextInt() );
 
        char ch;
        /*  Perform HashTableChainingSinglyLinkedList operations  */
        do    
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. clear");
            System.out.println("4. size"); 
            System.out.println("5. check empty");
            System.out.println("6. Lookup Value");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                htcsll.insert( scan.nextInt() ); 
                break;                          
            case 2 :                 
                System.out.println("Enter integer element to delete");
                htcsll.remove( scan.nextInt() ); 
                break;                        
            case 3 : 
                htcsll.makeEmpty();
                System.out.println("Hash Table Cleared\n");
                break;
            case 4 : 
                System.out.println("Size = "+ htcsll.getSize() );
                break; 
            case 5 : 
                System.out.println("Empty status = "+ htcsll.isEmpty() );
                break;
            case 6 :
            	System.out.println("What Item should I lookup?");
            	System.out.println(htcsll.lookup( scan.nextInt() ));
            	break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /* Display hash table */ 
            htcsll.printHashTable();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
    }
}