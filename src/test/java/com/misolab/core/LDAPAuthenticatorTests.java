package com.misolab.core;

import com.misolab.core.util.LDAPAuthenticator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://www.forumsys.com/tutorials/integration-how-to/ldap/online-ldap-test-server/
//LDAPAuthenticator
//ldap.principal= uid=%s,dc=example,dc=com
//ldap.providerUrl= ldap://ldap.forumsys.com


class LDAPAuthenticatorTests {

    LDAPAuthenticator ldapAuthenticator;

    final String principal = "uid=%s,dc=example,dc=com";
    final String providerUrl = "ldap://ldap.forumsys.com";

    @BeforeEach
    void setup() {
        ldapAuthenticator = new LDAPAuthenticator(principal, providerUrl);
    }

    @Test
    void testLogin() {
        //  성공을 하려면 cn=%s,dc=example,dc=com 으로 해야함
        LDAPAuthenticator.Result result = ldapAuthenticator.login("read-only-admin", "password");
        assertFalse(result.isOk());

        boolean success = ldapAuthenticator.isSimpleLogin("riemann", "password");
        assertTrue(success);
    }
}
