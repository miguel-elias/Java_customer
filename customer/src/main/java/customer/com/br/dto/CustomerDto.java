package customer.com.br.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {
    private  String name;
    private  String phone;
    private  String email;
    private  Long age;

}
