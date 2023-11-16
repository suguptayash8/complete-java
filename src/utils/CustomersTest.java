package utils;


/**
 * [{
 *     name,
 *     id,
 *     mobileNos:[]
 * }, {}]
 *
 * [mobileNos]
 * customers.stream().flatMap(cus-> cus.getMobileNos().stream())
 * .collect(Collectors.toList())
 */
public class CustomersTest {
}
