/**
 * 
 */
package com.crux.assignment.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jenish Lad
 * @Description: Class for initializing B-Tree during application startup time
 */
@Configuration
public class InitilizeBtree {
	
	/**
	 * @Description: Method for creating instance for B-Tree
	 * @return
	 */
	@Bean
	public BTree initlizeBtreeInstance() {
		System.out.println("initlizeBtreeInstance");
		BTree bTree=new BTree(3);
		return bTree;
	}
}
