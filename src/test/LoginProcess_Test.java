package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.BO.LoginProcess;
import model.DTO.User;

class LoginProcess_Test {

    @Test
    void isPasswordValid_trueWithValidArguments() {
	User user = new User();
	user.setPassword("dvakonja");
	assertTrue(LoginProcess.isPasswordValid(user, "dvakonja"));
	
    }
    
    @Test
    void isPasswordValid_trueWithWrongArguments() {
	User user = new User();
	user.setPassword("dvakonja");
	assertFalse(LoginProcess.isPasswordValid(user, "vakonja"));
	
    }

}
