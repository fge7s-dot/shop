package service.impl;

import entity.BigType;
import entity.SmallType;
import mapper.BigTypeMapper;
import mapper.SmallTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BigTypeService;
import service.SmallTypeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BigTypeServiceImpl implements BigTypeService {

    @Autowired
    private BigTypeMapper bigTypeMapper;
    @Autowired
    private SmallTypeMapper smallTypeMapper;

    public int addBigType(BigType bigType) {
        BigType recore = bigTypeMapper.findBigTypeByIdCard(bigType);
        if (recore==null){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            bigType.setCreateTime(sdf.format(date));
            bigType.setDelFlag("0");
            return bigTypeMapper.addBigType(bigType);
        }
        return 0;

    }

    @Override
    public int delBigType(BigType bigType) {

        return bigTypeMapper.delBigType(bigType);
    }

    @Override
    public int upBigType(BigType bigType) {
        return bigTypeMapper.upBigType(bigType);
    }

    @Override
    public List<BigType> querryAllBigType(BigType bigType) {
        return bigTypeMapper.querryAllBigType(bigType);
    }

    @Override
    public List<BigType> findBigtype(BigType bigtype) {
        return bigTypeMapper.findBigType(bigtype);
    }

    @Override
    public BigType findById(BigType recored) {
        return bigTypeMapper.findBigTypeById(recored);
    }

    @Override
    public int add(BigType bigType) {
        if (bigType.getId()==null || bigType.getId()==""){
            BigType recore = bigTypeMapper.findBigTypeByIdCard(bigType);
            if (recore==null){
                String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                bigType.setId(uuid);
                bigType.setCreateTime(sdf.format(date));
                bigType.setDelFlag("0");
                return bigTypeMapper.addBigType(bigType);
            }

        }else {
            return bigTypeMapper.upBigType(bigType);
        }

        return 0;
    }


}
