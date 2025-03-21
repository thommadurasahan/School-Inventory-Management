package com.beginners.sim.common.util;

public class Constant {

    // BASE URL
    public static final String API_VERSION = "/api/v1";

    // Inventory URLs
    public static final String INVENTORY_BASE_URL = API_VERSION;
    public static final String ITEM_BASE_URL = INVENTORY_BASE_URL + "/items";
    public static final String TYPE_BASE_URL = INVENTORY_BASE_URL + "/types";
    public static final String SUPPLIER_BASE_URL = INVENTORY_BASE_URL + "/suppliers";

    // Order URLs
    public static final String Order_BASE_URL = INVENTORY_BASE_URL + "/orders";

    // Repair URLs
    public static final String Repair_BASE_URL = INVENTORY_BASE_URL + "/repairs";

    // Survey URLs
    public static final String Survey_BASE_URL = INVENTORY_BASE_URL + "/surveys";

}
