package test;

import java.util.Comparator;

public class Comp2 implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1.equals(o2)) return 1;
		if(o1.compareTo(o2) >= 1) return -1;
		else return 0;
	}


}
