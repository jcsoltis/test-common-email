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
	private static final String[] TEST_HEADER1 = {"name1", "value1"};
	private static final String[] TEST_HEADER2 = {"name2", "value2"};
	private static final String[] TEST_HEADER3 = {"name3", "value3"};
	private static final String[] TEST_HEADER4 = {"name4", "value4"};
	private static final String[] TEST_HEADER_NULL = {null, null};

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

	//Test Email addHeader(String name, String value)
	@Test
	public void testAddHeader() throws Exception {
		emailConcrete.addHeader(TEST_HEADER1[0], TEST_HEADER1[1]);
		emailConcrete.addHeader(TEST_HEADER2[0], TEST_HEADER2[1]);
		emailConcrete.addHeader(TEST_HEADER3[0], TEST_HEADER3[1]);
		emailConcrete.addHeader(TEST_HEADER4[0], TEST_HEADER4[1]);
		int testHeaderSize = 4;
		
		assertEquals("AddHeader size", testHeaderSize, emailConcrete.headers.size());
	}
	
	//Test Email addHeader(String name, String value) for null name
	@Test
	public void testAddHeaderNullName() throws Exception {
		try{     
			emailConcrete.addHeader(TEST_HEADER_NULL[0],TEST_HEADER2[1]);
			fail("AddHeader null name not working correctly");
		}catch(IllegalArgumentException e){}
	}
	
	//Test Email addHeader(String name, String value) for null value
	@Test
	public void testAddHeaderNullValue() throws Exception {
		try{     
			emailConcrete.addHeader(TEST_HEADER3[0],TEST_HEADER_NULL[1]);
			fail("AddHeader null value not working correctly");
		}catch(IllegalArgumentException e){}
	}
	
	//Teardown method blank because nothing to really tear down
	@After
	public void teardownEmailTest() throws Exception {
		
	}
}
