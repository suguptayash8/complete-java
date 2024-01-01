package utils;

import java.security.PrivateKey;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * employee [id, name, Department, Salary]
 *            1   suyash  IT         20
 *            2   Janardhana Non_IT  10
 *            3   Aaksh      IT      5
 *            4   Peeyush   Non_IT   3
 *
 *       select e.name, e.id, m.max_salary from employee as e inner join
 *       (select max(salary)
 *  *       as max_salary from employee  group by Department) as m on e.salary = m.salary;
 *
 * select * from employee order by salary desc limit 1 offset 2
 * rama
 * amar
 */
public class Anagrams {

    public static void main(String [] args){
        System.out.println(isAnagram("", ""));
    }
    public static boolean isAnagram(String inpA, String inpB){
        if(Objects.nonNull(inpA) || Objects.nonNull(inpB)){
            return false;
        }

        if(inpA.length() != inpB.length() ){
            return false;
        }

        String sA = inpA.toLowerCase().chars().mapToObj((ch)-> String.valueOf(ch)).sorted().collect(Collectors.joining());
        String sB = inpB.toLowerCase().chars().mapToObj((ch)-> String.valueOf(ch)).sorted().collect(Collectors.joining());

        if(sA.equals(sB)){
            return  true;
        }

        return false;
    }

}
