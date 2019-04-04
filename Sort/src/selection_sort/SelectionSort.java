package selection_sort;

import java.util.List;

public class SelectionSort {
	
    public <T extends Comparable<T>> List<T> sort(List<T> unSorted){
		
    	T temp;
    	
		for(int i = 0;i < unSorted.size() - 1;i++){
			int min = i;
			for(int j = i + 1; j < unSorted.size(); j++){
				if(unSorted.get(min).compareTo(unSorted.get(j)) > 0){ //前大于后
					min = j;
				}
			}
			temp = unSorted.get(min);
			unSorted.set(min, unSorted.get(i));
			unSorted.set(i, temp);
		}
		return unSorted;
	}

}
