
public class Main {
	public static void main(String[] args) throws Exception {
    
        String space = "";
        for(int i = 1; i <= 12; i++){
            for(int j = 1; j <= 12; j++){
                int product = i*j;
                if(product < 10)
                    space = "   ";
                else if(product < 100)
                    space = "  ";
                else
                    space = " ";
                System.out.print(space + product);
            }
            System.out.println();
        }
        
	}
}
