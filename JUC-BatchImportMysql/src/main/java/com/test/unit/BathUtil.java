package com.test.unit;

import java.util.ArrayList;
import java.util.List;

public class BathUtil {
    /**
     * 创建静态方法，直接通过类调用，直接将总条数按组分割
     * @param list  [1, 4, 3, 5, 2, 5, 2, 2, 0, 0, 3, 0, 2, 0, 1, 2, 0, 4, 2, 2, 0...]   size 100
     * @param pageSize  按10分割
     * @param <T>
     * @return  newList [[1, 4, 3, 5, 2, 5, 2, 2, 0, 0], [3, 0, 2, 0, 1, 2, 0, 4, 2, 2], [0, 2, 1, 5, 2, 4, 1, 1, 5, 5]...]  size 10
     */
    public static <T>   List<List<T>> pagingList(List<T> list, int pageSize){
        //总数据
        int length = list.size();
        //根据每页大小pageSize，能够分得总页数
        int num = (length+pageSize-1)/pageSize;
        List<List<T>> newList =  new ArrayList<>();
        for(int i=0;i<num;i++){
            int fromIndex = i*pageSize;
            int toIndex = (i+1)*pageSize<length?(i+1)*pageSize:length;
            newList.add(list.subList(fromIndex,toIndex));
        }
        return newList;
    }



}
