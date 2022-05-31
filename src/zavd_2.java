import java.util.*;

public class zavd_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a count of people:");
        int n = scanner.nextInt();
        System.out.print("Enter a step:");
        int m = scanner.nextInt()-1;


        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i<= n ; i ++){
            list.add(i);
        }

        int count = 0;
        Iterator<Integer> iterator = list.iterator();
        while(list.size() > 1){

            if (!iterator.hasNext()){
                iterator = list.iterator();
            }

            int temp = -1;
            while(iterator.hasNext() && count <= m){
                temp = iterator.next();
                count ++;
            }

            if (count > m){
                count = 0;
                iterator.remove();
                System.out.println("RIP " + temp);
            }
        }

                // the last person
        System.out.println("IS ALIVE " + list.get(0));
    }


}
