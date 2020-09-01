/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

/*
 * Generated by OData VDM code generator of SAP Cloud SDK in version 2.19.0
 */

package vdm.namespaces.zscpmaxiconguagliosrv01;

import java.util.Map;
import javax.annotation.Nonnull;
import com.google.common.collect.Maps;
import com.sap.cloud.sdk.s4hana.datamodel.odata.helper.FluentHelperByKey;
import vdm.namespaces.zscpmaxiconguagliosrv01.selectable.ZSCP_CHECK_VALUES_TRADERSelectable;


/**
 * Fluent helper to fetch a single {@link vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES_TRADER ZSCP_CHECK_VALUES_TRADER} entity using key fields. This fluent helper allows methods which modify the underlying query to be called before executing the query itself. 
 * 
 */
public class ZSCP_CHECK_VALUES_TRADERByKeyFluentHelper
    extends FluentHelperByKey<ZSCP_CHECK_VALUES_TRADERByKeyFluentHelper, ZSCP_CHECK_VALUES_TRADER, ZSCP_CHECK_VALUES_TRADERSelectable>
{

    private final Map<String, Object> key = Maps.newHashMap();

    /**
     * Creates a fluent helper object that will fetch a single {@link vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES_TRADER ZSCP_CHECK_VALUES_TRADER} entity with the provided key field values. To perform execution, call the {@link #execute execute} method on the fluent helper object.
     * 
     * @param servicePath
     *     Service path to be used to fetch a single {@code ZSCP_CHECK_VALUES_TRADER}
     * @param trader
     *     Forn. servizi<p>Constraints: Not nullable, Maximum length: 10</p>
     */
    public ZSCP_CHECK_VALUES_TRADERByKeyFluentHelper(
        @Nonnull
        final String servicePath, final String trader) {
        super(servicePath);
        this.key.put("Trader", trader);
    }

    @Override
    @Nonnull
    protected Class<ZSCP_CHECK_VALUES_TRADER> getEntityClass() {
        return ZSCP_CHECK_VALUES_TRADER.class;
    }

    @Override
    @Nonnull
    protected Map<String, Object> getKey() {
        return key;
    }

}