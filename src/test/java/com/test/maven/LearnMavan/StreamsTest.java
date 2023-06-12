package com.test.maven.LearnMavan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsTest {
	
	@Test
	public void displayNames() {
		List<String> li = new ArrayList<String>();
		li.add("Abhijeet");
		li.add("Don");
		li.add("Alekhya");
		li.add("Adam");
		li.add("Ram");
		
		int count=0;
		for(int i=0;i<li.size();i++) {
			String name=li.get(i);
			if(name.startsWith("A")) {
				count++;
				
			}
		}
		System.out.println(count);
		
	}

	
	/*
	 * @Test public void getNames() { List<String> li = new ArrayList<String>();
	 * li.add("Abhijeet"); li.add("Don"); li.add("Alekhya"); li.add("Adam");
	 * li.add("Ram");
	 * 
	 * Long l=li.stream().filter(s->s.startsWith("A")).count();
	 * System.out.println(l); }
	 * 
	 * @Test public void streamMap() {
	 * Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->s.endsWith("a"))
	 * .map(s->s.toUpperCase()) .forEach(s->System.out.println(s));
	 * 
	 * List<String> names2=Arrays.asList("Abhijeet","Don","Alekhya","Adam","Ram");
	 * names2.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).forEach(
	 * s->System.out.println(s));
	 * 
	 * boolean flag=names2.stream().anyMatch(s->s.equalsIgnoreCase("Ram"));
	 * Assert.assertTrue(flag); }
	 * 
	 * @Test public void streamCollect() { //Converting from Stream to List
	 * List<String> li =
	 * Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->s.startsWith("A"
	 * )) .map(s->s.toUpperCase()).collect(Collectors.toList());
	 * System.out.println(li.get(0));
	 * 
	 * List<Integer> values=Arrays.asList(3,2,3,2,1,4,6,7,4);
	 * values.stream().distinct().forEach(s->System.out.println(s)); List<Integer>
	 * finalValues=values.stream().distinct().sorted().collect(Collectors.toList());
	 * System.out.println(finalValues.get(0)); }
	 */
}
