package com.example.demo.service;

import com.example.demo.model.Works;

import java.util.List;

/**
 * author duhongchi
 * <p> 业务接口类
 * Date 2020/3/26
 */
public interface IWorksService {
    /**
     *
     * @return
     */
    public List<Works> getWorksList();

    /**
     *
     * @param workId
     * @return
     */
    public Works findWorkById(Integer workId);

    /**
     *
     * @param works
     * @return
     */
    public Works addWork(Works works);

    /**
     *
     * @param works
     */
    public void modifiWork(Works works);

    /**
     *
     * @param workId
     * @return
     */
    public int removeWork(Integer workId);

}
