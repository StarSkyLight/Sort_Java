package merge_sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortIteration {
	
    public <T extends Comparable<T>> List<T> sort(List<T> unSorted){
    	List<T> tempList = new ArrayList<T>();
    	//生成临时存储list
		for(int q = 0; q < unSorted.size(); q++){
			tempList.add(q, unSorted.get(q));
		}
    	
    	//步长
    	int step = 1;
    	//游标
    	int part1_start = 0;
    	int part1_end = 0;
    	int part2_start = 0;
    	int part2_end = 0;
		//控制步长从1到n/2
		while(step < unSorted.size()){
			int two_steps = step * 2;
			//步长一定，控制每部分的遍历
			for(int i = 0; i < unSorted.size(); i = i + two_steps){
				part1_start = i;
				part2_start = part1_start + step;
				if(part2_start >= unSorted.size()){
					continue;  //如果part2_start越界，说明剩下的部分不足两个部分进行比较，则该部分在上次比较中已经有序，可以跳过本次比较
				}else{
					part1_end = part2_start - 1;
					part2_end = part2_start + step - 1;
					if(part2_end >= unSorted.size()){
						part2_end = unSorted.size() - 1;
					}
					int counter = part1_start;
					//两个序列均未完成排序
					while((part1_start <= part1_end) && (part2_start <= part2_end)){
						if(unSorted.get(part1_start).compareTo(unSorted.get(part2_start)) <= 0){ //前小于等于后
							tempList.set(counter, unSorted.get(part1_start));
							counter++;
							part1_start++;
						}else{
							tempList.set(counter, unSorted.get(part2_start));
							counter++;
							part2_start++;
						}
					}
					//第一个序列先完成排序
					while((part1_start > part1_end) && (part2_start <= part2_end)){
						tempList.set(counter, unSorted.get(part2_start));
						counter++;
						part2_start++;
					}
					//第二个序列先完成排序
					while((part1_start <= part1_end) && (part2_start > part2_end)){
						tempList.set(counter, unSorted.get(part1_start));
						counter++;
						part1_start++;
					}
				}
			}
			//将初步排序的结果复制到unSorted，供下次排序使用
			for(int k = 0; k < unSorted.size(); k++){
				unSorted.set(k, tempList.get(k));
			}
			//步长倍增
			step = two_steps;
		}
    	
		return unSorted;
	}

}
