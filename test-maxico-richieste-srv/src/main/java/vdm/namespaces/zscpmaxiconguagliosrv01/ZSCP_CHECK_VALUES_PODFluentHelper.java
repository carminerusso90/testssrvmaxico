/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

/*
 * Generated by OData VDM code generator of SAP Cloud SDK in version 2.19.0
 */

package vdm.namespaces.zscpmaxiconguagliosrv01;

import javax.annotation.Nonnull;
import com.sap.cloud.sdk.s4hana.datamodel.odata.helper.FluentHelperRead;
import vdm.namespaces.zscpmaxiconguagliosrv01.selectable.ZSCP_CHECK_VALUES_PODSelectable;


/**
 * Fluent helper to fetch multiple {@link vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES_POD ZSCP_CHECK_VALUES_POD} entities. This fluent helper allows methods which modify the underlying query to be called before executing the query itself. 
 * 
 */
public class ZSCP_CHECK_VALUES_PODFluentHelper
    extends FluentHelperRead<ZSCP_CHECK_VALUES_PODFluentHelper, ZSCP_CHECK_VALUES_POD, ZSCP_CHECK_VALUES_PODSelectable>
{


    /**
     * Creates a fluent helper using the specified service path to send the read requests.
     * 
     * @param servicePath
     *     The service path to direct the read requests to.
     */
    public ZSCP_CHECK_VALUES_PODFluentHelper(
        @Nonnull
        final String servicePath) {
        super(servicePath);
    }

    @Override
    @Nonnull
    protected Class<ZSCP_CHECK_VALUES_POD> getEntityClass() {
        return ZSCP_CHECK_VALUES_POD.class;
    }

}
