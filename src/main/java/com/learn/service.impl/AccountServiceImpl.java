package com.learn.service.impl;

import com.learn.dao.AccountDao;
import com.learn.model.ao.AccountAo;
import com.learn.model.dto.AccountDto;
import com.learn.model.dto.UserDto;
import com.learn.model.vo.AccountVo;
import com.learn.model.vo.UserVo;
import com.learn.service.IAccountService;
import com.learn.tools.CommonConvertBean;
import com.learn.tools.EncryptionCode;
import com.learn.tools.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountDao dao;
    @Override
    public AccountVo findAccount(AccountAo ao) {
        AccountDto dto = new AccountDto();
        AccountVo vo = new AccountVo();
        /** 初始化 */

        /** 查询 */
        dto = dao.findByaccount(ao);
        /** 返回 */
        if(dto != null) {
            vo.setUser(new UserVo());
            CommonConvertBean.SourceConvertTarget(dto, vo);
            CommonConvertBean.SourceConvertTarget(dto.getUser(), vo.getUser());
        }
        return vo;
    }

    @Override
    public Pager<AccountVo> findAll(Map<String,Object> paramAo) {
        Pager<AccountVo> pager = null;
        List<AccountDto> dtoList = null;
        Map<String,Object> param = new HashMap<>();
        dtoList = dao.findAll(paramAo);
        if(dtoList != null && dtoList.size() > 0){
            pager = new Pager<>();
            try {
                pager.setResult(CommonConvertBean.ListSourceConvertTarget(dtoList,AccountVo.class));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            pager.setPage(Integer.valueOf(paramAo.get("page").toString()));
            pager.setSize(Integer.valueOf(paramAo.get("size").toString()));
            pager.setTotal(dao.findAllNumber());
        }
        return pager;
    }

    @Override
    public Integer insertRecordFull(AccountAo ao) {
        AccountDto dto = new AccountDto();
        Integer res = null;
        /**  初始化 */
        CommonConvertBean.SourceConvertTarget(ao,dto);
        dto.setUser(new UserDto());
        dto.getUser().setId(ao.getUser().getId());
        dto.setCreateDate(new Date());
        /** 是否是明文存储  如果不是 那就加密 */
        if(dto.getA_flag() == '0'){
            dto.setPassword( EncryptionCode.encrypt(dto.getPassword(),new Long(dto.getCreateDate().getTime()).toString()) );
        }
        res = dao.insertRecordFull(dto);
        return res;
    }

    @Override
    public Integer updateRecord(AccountAo ao) {
        AccountDto dto = new AccountDto();
        AccountDto tmpDto = new AccountDto();
        String a1 = ao.getAccount();
        Integer res = 0;
        /** 初始化 */
        CommonConvertBean.SourceConvertTarget(ao,dto);
        dto.setUser(new UserDto());
        dto.getUser().setId(ao.getUser().getId());
        /** 查询 */
        tmpDto = dao.findByaccount(ao);
        if(tmpDto != null) {
            dto.setCreateDate(tmpDto.getCreateDate());
            /** 是否是明文存储  如果不是 那就加密 */
            if (dto.getA_flag() == '0') {
                dto.setPassword(EncryptionCode.encrypt(dto.getPassword(), new Long(dto.getCreateDate().getTime()).toString()));
            }
            System.out.println("======================================dto:" + dto + "==============================================");
            res = dao.updateRecord(dto, a1);
        }
        return res;
    }
}
