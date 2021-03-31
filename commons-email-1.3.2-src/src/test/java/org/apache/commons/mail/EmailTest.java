package org.apache.commons.mail;

import static org.junit.Assert.*;

import java.util.Date;

import javax.mail.internet.InternetAddress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	//static global usage variables to be used in setting email functions
	private static final String[] TEST_EMAILS = { "ab@bc.com", "a.b@c.org",
			"abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd" };
	private static final String[] EMPTY_EMAILS = null;

	//concrete email object to be tested
	private EmailConcrete emailConcrete;
	
	//Setup method to initialize concrete email
	@Before
	public void setupEmailTest() throws Exception {
		emailConcrete = new EmailConcrete();
	}

	//Test Email addBcc(String... emails)
	@Test
	public void testAddBcc() throws Exception {
		emailConcrete.addBcc(TEST_EMAILS);
		int testBccSize = 3;
		
		assertEquals("AddBcc size", testBccSize, emailConcrete.getBccAddresses().size());
	}
	
	//Test Email addBcc(String... emails) for null list
	@Test
	public void testAddBccEmpty() throws Exception {
		try{     
			emailConcrete.addBcc(EMPTY_EMAILS);
			fail("AddBcc null list not working correctly");
		}catch(EmailException e){}
	}

	//Test Email addCc(String email)
	@Test
	public void testAddCc() throws Exception {
		emailConcrete.addCc(TEST_EMAILS[0]);
		emailConcrete.addCc(TEST_EMAILS[1]);
		int testCcSize = 2;
		
		assertEquals("AddCc size", testCcSize, emailConcrete.getCcAddresses().size());
	}
	
	//Teardown method blank because nothing to really tear down
	@After
	public void teardownEmailTest() throws Exception {
		
	}
}
