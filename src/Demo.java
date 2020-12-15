import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,5,20,25,30,35);
//        List<Integer> newList=new ArrayList<>();
//
//        list.forEach(a->{
//            if(a>10){
//                newList.add(a);
//            }
//        });

        List<Integer> newList=list.stream().filter(a->a>10)
                .collect(Collectors.toList());
        System.out.println("New List: "+newList);

        //Normal Java
//        for(Integer i:list){
////            System.out.println(i);
////        }

        //Java 8,lambda expression
        list.forEach(a-> System.out.println(a));

        //Java 8, method reference
      //  list.forEach(System.out::println);

        Consumer<Integer> c=x-> System.out.println(x);
        c.accept(20);

        //Function Interface
        Function<String,Integer> f=str->str.length();
        Integer i1=f.apply("Abhijeet");
        System.out.println("Value of i1: "+i1);

        BiFunction<Integer,Integer,Integer> bi=(a,b)->a+b;
        Integer i2=bi.apply(20,30);
        System.out.println("Value of i2: "+i2);

        Function<String,Integer> f1=str->str.length(); // 4
        Function<Integer,Integer> f2=val->val*10;  //40
        Integer i3=f1.andThen(f2).apply("Abhi");
        System.out.println("Value of i3: "+i3);

        BinaryOperator<Integer> bin=(x,y)->x+y;
        Integer i4=bin.apply(40,50);
        System.out.println("Value of i4: "+i4);
    }
}
