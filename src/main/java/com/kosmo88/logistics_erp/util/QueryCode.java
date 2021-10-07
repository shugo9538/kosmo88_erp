package com.kosmo88.logistics_erp.util;

public enum QueryCode {
    UPDATE {
        @Override
        public boolean check(int i) {
            if (i == 1)
                return SUCCESS;
            else
                return FAILURE;
        }
    }, INSERT {
        @Override
        public boolean check(int i) {
            if (i == 1)
                return SUCCESS;
            else
                return FAILURE;
        }
    }, DELETE {
        @Override
        public boolean check(int i) {
            if (i == 1)
                return SUCCESS;
            else
                return FAILURE;
        }
    };
    

    private final static boolean SUCCESS = true;
    private final static boolean FAILURE = false;

    public abstract boolean check(int i);
}
