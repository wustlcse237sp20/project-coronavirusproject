package quickSortTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import src.Province;
import src.quickSort;

class quickSortFirstTest {
	
	Province province2 = new Province("p2", 103, 14);
	Province province1 = new Province("p1", 100, 12 );
	Province province3 = new Province("p3", 110, 24);
	Province province4 = new Province("p4", 203, 34);
	Province province6 = new Province("p6", 300, 42 );
	Province province5 = new Province("p5", 410, 54);
	Province province8 = new Province("p8", 503, 64);
	Province province7 = new Province("p7", 700, 72 );
	Province province9 = new Province("p9", 810, 84);
	
	Province[] provinceArray = new Province[9];
	
	quickSort test = new quickSort();
	
	
	@Test
	void test() {
		provinceArray[0] = province1;
		provinceArray[1] = province3;
		provinceArray[2] = province2;
		test.sort(provinceArray, 0, 2, true);
		assertTrue(provinceArray[0] == province1);
		assertTrue(provinceArray[2] == province3);
	}

	@Test
	void test2() {
		provinceArray[0] = province1;
		provinceArray[1] = province3;
		provinceArray[2] = province2;
		provinceArray[3] = province6;
		provinceArray[4] = province8;
		provinceArray[5] = province5;
		test.sort(provinceArray, 0, 5, true);
		assertTrue(provinceArray[0] == province1);
		assertTrue(provinceArray[2] == province3);
		assertTrue(provinceArray[5] == province8);
	}
}
