package merge_sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortRecursion {
	
	public <T extends Comparable<T>> List<T> sort(List<T> unSorted, int start, int end){
		List<T> tempList = new ArrayList<T>();
		//生成临时存储list
		for(int q = 0; q < unSorted.size(); q++){
			tempList.add(q, unSorted.get(q));
		}
		
		if (start == end){
			return unSorted;
		}
		else{
			int mid1 = (start + end) / 2;
			int mid2 = mid1 + 1;
			
			sort(unSorted, start, mid1);
			sort(unSorted, mid2, end);
			
			int counter = start;
			while((start <= mid1) && (mid2 <= end)){
				if(unSorted.get(start).compareTo(unSorted.get(mid2)) <= 0){ //前小于等于后
					tempList.set(counter, unSorted.get(start));
					counter++;
					start++;
				}else{
					tempList.set(counter, unSorted.get(mid2));
					counter++;
					mid2++;
				}
			}
			//第一个序列先完成排序
			while((start > mid1) && (mid2 <= end)){
				tempList.set(counter, unSorted.get(mid2));
				counter++;
				mid2++;
			}
			//第二个序列先完成排序
			while((start <= mid1) && (mid2 > end)){
				tempList.set(counter, unSorted.get(start));
				counter++;
				start++;
			}
			//将初步排序的结果复制到unSorted，供下次排序使用
			for(int k = 0; k < unSorted.size(); k++){
				unSorted.set(k, tempList.get(k));
			}
		}
		return unSorted;
	}

}
