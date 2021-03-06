/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

/*
 * Generated by OData VDM code generator of SAP Cloud SDK in version 2.19.0
 */

package vdm.namespaces.zscpmaxiconguagliosrv.batch;

import javax.annotation.Nonnull;
import com.sap.cloud.sdk.s4hana.datamodel.odata.helper.batch.BatchChangeSetFluentHelperBasic;
import vdm.services.ZSCPMAXICONGUAGLIOSRVService;


/**
 * Implementation of the {@link ZSCPMAXICONGUAGLIOSRVServiceBatchChangeSet} interface, enabling you to combine multiple operations into one changeset. For further information have a look into the {@link vdm.services.ZSCPMAXICONGUAGLIOSRVService ZSCPMAXICONGUAGLIOSRVService}.
 * 
 */
public class DefaultZSCPMAXICONGUAGLIOSRVServiceBatchChangeSet
    extends BatchChangeSetFluentHelperBasic<ZSCPMAXICONGUAGLIOSRVServiceBatch, ZSCPMAXICONGUAGLIOSRVServiceBatchChangeSet>
    implements ZSCPMAXICONGUAGLIOSRVServiceBatchChangeSet
{

    @Nonnull
    private final ZSCPMAXICONGUAGLIOSRVService service;

    DefaultZSCPMAXICONGUAGLIOSRVServiceBatchChangeSet(
        @Nonnull
        final DefaultZSCPMAXICONGUAGLIOSRVServiceBatch batchFluentHelper,
        @Nonnull
        final ZSCPMAXICONGUAGLIOSRVService service) {
        super(batchFluentHelper, batchFluentHelper);
        this.service = service;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Nonnull
    @Override
    protected DefaultZSCPMAXICONGUAGLIOSRVServiceBatchChangeSet getThis() {
        return this;
    }

}
