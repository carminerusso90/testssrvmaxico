/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

/*
 * Generated by OData VDM code generator of SAP Cloud SDK in version 2.19.0
 */

package vdm.services;

import javax.annotation.Nonnull;
import javax.inject.Named;
import vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUESByKeyFluentHelper;
import vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUESFluentHelper;
import vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES_PODByKeyFluentHelper;
import vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES_PODFluentHelper;
import vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES_TRADERByKeyFluentHelper;
import vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES_TRADERFluentHelper;
import vdm.namespaces.zscpmaxiconguagliosrv01.batch.DefaultZSCPMAXICONGUAGLIOSRV01ServiceBatch;


/**
 * <h3>Details:</h3><table summary='Details'><tr><td align='right'>OData Service:</td><td>ZSCP_MAXI_CONGUAGLIO_SRV_01</td></tr></table>
 * 
 */
@Named("vdm.services.DefaultZSCPMAXICONGUAGLIOSRV01Service")
public class DefaultZSCPMAXICONGUAGLIOSRV01Service
    implements ZSCPMAXICONGUAGLIOSRV01Service
{

    @Nonnull
    private final String servicePath;

    /**
     * Creates a service using {@link ZSCPMAXICONGUAGLIOSRV01Service#DEFAULT_SERVICE_PATH} to send the requests.
     * 
     */
    public DefaultZSCPMAXICONGUAGLIOSRV01Service() {
        servicePath = ZSCPMAXICONGUAGLIOSRV01Service.DEFAULT_SERVICE_PATH;
    }

    /**
     * Creates a service using the provided service path to send the requests.
     * <p>
     * Used by the fluent {@link #withServicePath(String)} method.
     * 
     */
    private DefaultZSCPMAXICONGUAGLIOSRV01Service(
        @Nonnull
        final String servicePath) {
        this.servicePath = servicePath;
    }

    @Override
    @Nonnull
    public DefaultZSCPMAXICONGUAGLIOSRV01Service withServicePath(
        @Nonnull
        final String servicePath) {
        return new DefaultZSCPMAXICONGUAGLIOSRV01Service(servicePath);
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    @Nonnull
    public DefaultZSCPMAXICONGUAGLIOSRV01ServiceBatch batch() {
        return new DefaultZSCPMAXICONGUAGLIOSRV01ServiceBatch(this);
    }

    @Override
    @Nonnull
    public ZSCP_CHECK_VALUESFluentHelper getAllZSCP_CHECK_VALUES() {
        return new ZSCP_CHECK_VALUESFluentHelper(servicePath);
    }

    @Override
    @Nonnull
    public ZSCP_CHECK_VALUESByKeyFluentHelper getZSCP_CHECK_VALUESByKey(final String pod, final String trader) {
        return new ZSCP_CHECK_VALUESByKeyFluentHelper(servicePath, pod, trader);
    }

    @Override
    @Nonnull
    public ZSCP_CHECK_VALUES_PODFluentHelper getAllZSCP_CHECK_VALUES_POD() {
        return new ZSCP_CHECK_VALUES_PODFluentHelper(servicePath);
    }

    @Override
    @Nonnull
    public ZSCP_CHECK_VALUES_PODByKeyFluentHelper getZSCP_CHECK_VALUES_PODByKey(final String pod) {
        return new ZSCP_CHECK_VALUES_PODByKeyFluentHelper(servicePath, pod);
    }

    @Override
    @Nonnull
    public ZSCP_CHECK_VALUES_TRADERFluentHelper getAllZSCP_CHECK_VALUES_TRADER() {
        return new ZSCP_CHECK_VALUES_TRADERFluentHelper(servicePath);
    }

    @Override
    @Nonnull
    public ZSCP_CHECK_VALUES_TRADERByKeyFluentHelper getZSCP_CHECK_VALUES_TRADERByKey(final String trader) {
        return new ZSCP_CHECK_VALUES_TRADERByKeyFluentHelper(servicePath, trader);
    }

}
