package com.misolab.core;

import com.misolab.core.util.LDAPAuthenticator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest
class LDAPAuthenticatorTests {

    @Autowired
    LDAPAuthenticator ldapAuthenticator;

    @Test
    public void testLogin() {
        //  성공을 하려면 cn=%s,dc=example,dc=com 으로 해야함
        LDAPAuthenticator.Result result = ldapAuthenticator.login("read-only-admin", "password");
        assertThat(result.isOk(), is(false));

        boolean success = ldapAuthenticator.isSimpleLogin("riemann", "password");
        assertThat(success, is(true));
    }
}
