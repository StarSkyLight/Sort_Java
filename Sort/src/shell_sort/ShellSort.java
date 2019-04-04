package shell_sort;

import java.util.List;

public class ShellSort {
	
public <T extends Comparable<T>> List<T> sort(List<T> unSorted){
		
    	int gap = unSorted.size() / 2;   //初始步长为队列长度的一半
    	
		while(gap >= 1){
			for(int i = 0; i < gap; i++){
				//内部为插入排序
				for(int k = i; k < unSorted.size(); k = k + gap){
					T key = unSorted.get(k);
					int j;
					for(j = k - gap; j >= 0; j = j - gap){    //向后移动
						if(key.compareTo(unSorted.get(j)) < 0){ //前小于后
							unSorted.set(j + gap, unSorted.get(j));
						}
						else{
							break;
						}
					}
					unSorted.set(j + gap, key);
				}
			}
			gap = gap / 2;
		}
		
		return unSorted;
	}

}
