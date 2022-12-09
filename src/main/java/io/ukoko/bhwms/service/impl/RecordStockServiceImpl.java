package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.entity.RecordStock;
import io.ukoko.bhwms.enums.BhWmsStatus;
import io.ukoko.bhwms.exceptions.BhWmsException;
import io.ukoko.bhwms.mapper.RecordStockMapper;
import io.ukoko.bhwms.service.RecordStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class RecordStockServiceImpl implements RecordStockService {

    @Autowired
    private RecordStockMapper recordStockMapper;

    /**
     * 入库
     * @param recordStock
     */
    @Override
    public void inRecordStock(RecordStock recordStock) {
        System.out.println("===>>>>"+recordStock);
        List<RecordStock> recordStocks = recordStockMapper.getRecordStockList(recordStock.getProductId(), recordStock.getRepoId());
        if(recordStocks!=null && recordStocks.size()>0){
            //存在直接入库
            recordStockMapper.inRecordStock(recordStock);
        }else{
            //不存在需要插入
            recordStock.setCreateTime(new Date());
            recordStockMapper.addRecordStock(recordStock);
        }
    }

    /**
     * 出库
     * @param recordStock
     */
    @Override
    public void outRecordStock(RecordStock recordStock) {
        if(recordStock.getProductId()!=null && recordStock.getRepoId()!=null){
            List<RecordStock> recordStocks = recordStockMapper.getRecordStockList(recordStock.getProductId(), recordStock.getRepoId());
            if(recordStocks!=null && recordStocks.size()>0){
                //获取第一个
                RecordStock stock = recordStocks.get(0);
                //库存不够
                if(stock.getProductStock()<recordStock.getProductStock()){
                    throw new BhWmsException(BhWmsStatus.REPO_NOT_STOCK);
                }else{
                    recordStockMapper.outRecordStock(recordStock);
                }
            }
        }else{
            throw new BhWmsException(BhWmsStatus.REPO_NOT_PARAM);
        }
    }
}
