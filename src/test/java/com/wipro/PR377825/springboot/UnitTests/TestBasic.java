package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.wipro.Basic.test.BasicTest;

public class TestBasic 
{
	
	@Test
	public void add()
	{
		System.out.println("test case started");
		int a = 10;
		int b = 20;
		BasicTest obj = new BasicTest();
		
		
		int sum = obj.add(a, b);		
		assertEquals(30, sum);
		System.out.println("test case ended");
	}
}
