import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        System.out.println("asdfasdf");

        //동일한 데이터를 가지는 배열과 리스트를 선언.
        //각각 데이터 정렬을 위한 메서드를 통해 데이터를 정렬.
        //정렬된 값을 확인하기 위해 출력문을 이용해 출력.
        String[] strArr = { "data3", "data2", "data1" };
        List<String> strList = Arrays.asList(strArr);

        //데이터 정렬을 위해 각각 Arrays, Collections 의 sort 메서드를 이용
        //정렬한 다음 for 문을 이용해 결과를 출력하는 형식.
        Arrays.sort(strArr);
        Collections.sort(strList);

        for(String str : strArr) {
            System.out.println(str);
        }

        for(String str : strList) {
            System.out.println(str);
        }
        System.out.println("\n\n");


        //데이터 소스(배열 혹은 리스트)로 부터 스트림을 생성.
        //정렬을 위해 sorted() 메서드를 호출.
        //출력을 위해 forEach() 메서드를 호출.
//        strList.stream().sorted().forEach(System.out::println);
//        Arrays.stream(strArr).sorted().forEach(System.out::println);

        //여기에서 forEach는 void forEach(Consumer<? super T> action) 로 정의되어 있음.
        //Cosumer 함수형 인터페이스를 인자로 가진다.
        //메서드 레퍼런스를 사용하지 않고 람다식으로 표현하면 아래와 같다.
//        strList.stream().sorted().forEach(x -> System.out.println(x));


        System.out.println((strList.stream().sorted()));
    }


}
