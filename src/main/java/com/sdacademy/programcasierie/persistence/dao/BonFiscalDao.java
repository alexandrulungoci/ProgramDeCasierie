package com.sdacademy.programcasierie.persistence.dao;

import com.sdacademy.programcasierie.persistence.model.BonFiscalModel;

public class BonFiscalDao extends ModelDao<BonFiscalModel> {

    public BonFiscalDao() {
        super("bon_fiscal.txt");
    }
}
