package insertion_sort;

import java.util.List;

public class InsertionSort {
	
    public <T extends Comparable<T>> List<T> sort(List<T> unSorted){
		
		for(int i = 0;i < unSorted.size();i++){
			T key = unSorted.get(i);
			int j;
			for(j = i - 1; j >= 0; j--){    //向后移动
				if(key.compareTo(unSorted.get(j)) < 0){ //前小于后
					unSorted.set(j+1, unSorted.get(j));
				}
				else{
					break;
				}
			}
			unSorted.set(j + 1, key);
		}
		return unSorted;
	}

}
