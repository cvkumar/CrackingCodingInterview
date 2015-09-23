package nine.two;

import java.util.ArrayList;
import java.util.HashMap;
/* Part One: Robot is placed at (0,0) and must move to (X,Y). It can only step in the X or Y direction. How many ways
 * are there for him to move to that spot.
 * 
 * Dashes and Slashes Thm: Need X + Y objects of 2 types. Hence solution is Choose(x+y + 2 - 1, 2 -1)
 * or
 * Choose(x+y+1, 1)
 * 
 * Another way to think about it is that we need to select x direction steps from the total set of x+y steps. Hence we
 * Choose(x+y, x)
 * 
 * Part Two:
 * My Solution would be as follows.
 * 1. If we went too far or spot is not free, return false
 */
import java.util.Hashtable;


public class Robot_Mover {
	
	//BIG O 2^(x+y)
	public static boolean findPath(int x, int y) {
		ArrayList<Point> path = new ArrayList<Point>();
		return findPath(x, y, path);
	}
	
	public static boolean findPath(int x, int y, ArrayList<Point> path) {
		if (x < 0 || y < 0 || !isFree(x, y) ) {
			return false;
		}
	
		boolean atOrigin = x == 0 && y == 0;
		if (atOrigin || findPath(x-1, y, path) || findPath(x, y-1, path)) {
			path.add(new Point(x, y));
			return true;
		}
		return false;
	}
	
	public static boolean findPath2(int x, int y) {
		ArrayList<Point> path = new ArrayList<Point>();
		Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();
		return findPath2(x, y, path, cache);
	}
	
	public static boolean findPath2(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache) {
		if (x < 0 || y < 0 || !isFree(x, y) ) {
			return false;
		}
		
		Point p = new Point(x, y);
		if (cache.containsKey(p)) {
			return cache.get(p);
		}
		
		boolean atOrigin = x == 0 && y == 0;
		boolean success = false;
		
		if (atOrigin || findPath2(x-1, y, path, cache) || findPath2(x, y-1, path, cache)) {
			path.add(new Point(x, y));
			success = true;
		}
		cache.put(p, success);
		return success;
	}
	
	public static boolean myFindPath(int x, int y) {
		ArrayList<Point> path = new ArrayList<Point>();
		Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();
		return myFindPath(x, y, path, cache);
	}
	
	public static boolean myFindPath(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache) {
		if (x < 0 || y < 0 || !isFree(x,y)) {
			return false;
		}
		
		if(x==0 && y==0) {
			path.add(new Point(x,y));
			return true;
		}
		
		Point p = new Point(x,y);
		if (cache.containsKey(p)) {
			return cache.get(p);
		}
		
		if( myFindPath(x-1, y, path, cache) || myFindPath(x, y-1, path, cache)) {
			path.add(new Point(x,y));
			return true;
		}
		cache.put(new Point(x,y), false);
		return false;
	}
	
	public static boolean isFree(int x, int y) {
		Point[] points = {new Point(4,3), new Point(3,4), new Point(5,3), new Point(3,5), new Point(1,1)};
		for(int i = 0; i < points.length; i++) {
			if (x == points[i].x && y == points[i].y) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(findPath2(5, 5));
		
		/*
		Hashtable test = new Hashtable<Point, Integer>();
		Point a = new Point(0,0);
		Point b = new Point(0,0);
		
		System.out.println(a == b);
		
		test.put(a, 5);
		
		System.out.println(test.containsKey(b));
		*/
		
		
	}
}
