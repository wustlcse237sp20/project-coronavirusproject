package quickSortTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import src.Province;
import src.quickSort;

class quickSortSecondTest {
	
	Province province1 = new Province("p2", 90, 14);
	Province province2 = new Province("p1", 80, 12 );
	Province province3 = new Province("p3", 70, 24);
	Province province4 = new Province("p4", 60, 34);
	Province province5 = new Province("p6", 50, 42 );
	Province province6 = new Province("p5", 40, 54);
	Province province7 = new Province("p8", 30, 64);
	Province province8 = new Province("p7", 20, 72 );
	Province province9 = new Province("p9", 10, 84);
	
	Province[] provinceArray = new Province[9];
	
	quickSort test = new quickSort();
	
	
	@Test
	void test() {
		provinceArray[0] = province1;
		provinceArray[1] = province3;
		provinceArray[2] = province2;
		test.sort(provinceArray, 0, 2, false);
		assertTrue(provinceArray[0] == province2);
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
		test.sort(provinceArray, 0, 5, false);
		assertTrue(provinceArray[0] == province2);
		assertFalse(provinceArray[2] == province4);
		assertTrue(provinceArray[5] == province8);
	}
}