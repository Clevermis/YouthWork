package com.clevermis.service.forms;

import com.clevermis.dao.forms.FormsDao;
import com.clevermis.dao.forms.FormsDaoImpl;
import com.clevermis.entity.Forms;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-07 13:03
 * @since JDK 1.8
 **/
public class FormsServiceImpl implements FormsService{
    private FormsDao forms;
    public FormsServiceImpl(){
        forms = new FormsDaoImpl();
    }
    @Override
    public Object getFormsList() {
        return forms.getforms();
    }
}
