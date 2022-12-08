package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.RecordStock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecordStockMapperTest extends BhWmsApplicationTests {

    @Autowired
    private RecordStockMapper recordStockMapper;

    @Test
    void addRecordStock() {
        RecordStock recordStock = new RecordStock();
        recordStock.setCreateTime(new Date());
        recordStock.setIsDelete(1);
        recordStock.setProductId(2);
        recordStock.setProductStock(200);
        recordStock.setRepoId(1);
        recordStockMapper.addRecordStock(recordStock);
    }

    @Test
    public void inRecordStock(){
        RecordStock recordStock = new RecordStock();
        recordStock.setProductId(2);
        recordStock.setRepoId(1);
        recordStock.setProductStock(10);
        recordStockMapper.inRecordStock(recordStock);

    }

    @Test
    public void outRecordStock(){
        RecordStock recordStock = new RecordStock();
        recordStock.setProductId(1);
        recordStock.setRepoId(1);
        recordStock.setProductStock(500);
        recordStockMapper.outRecordStock(recordStock);

    }

    @Test
    void getRecordStockList() {
        List<RecordStock> recordStockList = recordStockMapper.getRecordStockList(1, null);
        recordStockList.forEach(System.out::println);
    }
}