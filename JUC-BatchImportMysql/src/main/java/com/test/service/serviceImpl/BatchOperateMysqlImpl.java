package com.test.service.serviceImpl;

import com.test.dao.BatchOperateMysqlDao;
import com.test.entity.GeneralTable;
import com.test.service.BatchOperateMysqlInf;
import com.test.unit.BatchInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;

@Service
public class BatchOperateMysqlImpl implements BatchOperateMysqlInf {

    @Resource
    private BatchOperateMysqlDao batchOperateMysqlDao;

    /**
     * 创建自适应机器本身线程数量的线程池
     */
    Integer process = Runtime.getRuntime().availableProcessors();
    ExecutorService executorService = new ThreadPoolExecutor(
            2,
            process,
            2L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );


    @Override
    public boolean insert(List<GeneralTable> list) {
        Future<Boolean> a = null;
        try {
            /**
             * submit与execute 都是向线程池提交任务。
             * submit提交后执行提交类实现callable方法后重写的call方法，execute提交后执行实现Runnable的run方法
             * Runnable任务没有返回值，而Callable任务有返回值。
             * 并且Callable的call()方法只能通过ExecutorService的submit(Callable <T> task) 方法来执行
             * 多人同时提交时的线程控制：
             */
            System.out.println("service线程："+Thread.currentThread().getName());
            a = executorService.submit(new BatchInsert(list, batchOperateMysqlDao));
            return a.get();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                return a.get();
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }finally {
            executorService.shutdown();
        }
    }



}