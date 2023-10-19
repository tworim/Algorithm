package Bstudy.S_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new ArrayDeque<Integer>();

        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str){
                case "push_front" :
                    deq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back" :
                    deq.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front" :
                    if(deq.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(deq.poll());
                    }
                    break;


                case "pop_back" :
                    if(deq.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(deq.pollLast());
                    }
                    break;


                case "size" :
                    System.out.println(deq.size());
                    break;

                case "empty" :
                    if(deq.isEmpty()){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                    break;

                case "front" :

                    if(deq.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(deq.peek());
                    }
                    break;

                case "back" :

                    if(deq.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(deq.peekLast());

                    }
                    break;


            }


        }


    }
}
