

class MergeIntervals {
	// this problem need sorting first for starts
	public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        
		// remember check corner cases!!!!!!!
        if (intervals.size() <= 1) {
            return intervals;
        }
        
		// sort first
		Collections.sort(intervals, new MyComparator());
		
		Interval current, last = intervals.get(0);
		int id = 1;
		while (id < intervals.size()){
			// what if intevals doesnt have id = 1 ?!
			current = intervals.get(id);
			if (last.end < current.start) {
				result.add(last);
				last = current;
			} else if (last.end >= current.start && last.end < current.end) {
				last = new Interval(last.start, current.end);
			} else {
				last = new Interval(last.start, last.end);
			}
			// set next index!
            id++;
		}
		// list.add return boolean
		result.add(last);
		return result;
    }
	
	private static class MyComparator implements Comparator<Interval> {
		public int compare(Interval interval1, Interval interval2) {
			return interval1.start - interval2.start;
		}
	}
}

class Interval {
	int start, end;
	
	public Interval(){}
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}