package mk.ukim.finki.emt.bankcontext.domain.dto;

import mk.ukim.finki.emt.sharedkernel.domain.base.UserType;

public class CreateUserDto {
    public String bankIdString;
    public String name;
    public String surname;
    public String location;
    public UserType type;
}
