package bubble_sort;

import java.util.List;

public class BubbleSort {
	public <T extends Comparable<T>> List<T> sort(List<T> unSorted){
		
		T max;
		
		for(int i = 0;i < unSorted.size() - 1;i++){
			for(int j = 0; j < unSorted.size() - 1 - i; j++){
				if(unSorted.get(j).compareTo(unSorted.get(j + 1)) > 0){
					max = unSorted.get(j);
					unSorted.set(j, unSorted.get(j + 1));
					unSorted.set(j + 1, max);
				}
			}
		}
		return unSorted;
	}
}
