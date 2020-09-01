/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

/*
 * Generated by OData VDM code generator of SAP Cloud SDK in version 2.19.0
 */

package vdm.namespaces.zscpmaxiconguagliosrv.link;

import javax.annotation.Nonnull;
import com.sap.cloud.sdk.s4hana.datamodel.odata.helper.EntityLink;
import com.sap.cloud.sdk.s4hana.datamodel.odata.helper.VdmObject;
import vdm.namespaces.zscpmaxiconguagliosrv.ZSCP_CHECK_VALUES;
import vdm.namespaces.zscpmaxiconguagliosrv.selectable.ZSCP_CHECK_VALUESSelectable;


/**
 * Template class to represent entity navigation links of {@link vdm.namespaces.zscpmaxiconguagliosrv.ZSCP_CHECK_VALUES ZSCP_CHECK_VALUES} to other entities. Instances of this object are used in query modifier methods of the entity
 * fluent helpers. Contains methods to compare a field's value with a provided value.
 * 
 * Use the constants declared in each entity inner class. Instantiating directly requires knowing the underlying OData
 * field names, so use the constructor with caution.
 * 
 * @param <ObjectT>
 * Entity type of subclasses from {@link com.sap.cloud.sdk.s4hana.datamodel.odata.helper.VdmObject VdmObject}.
 * 
 */
public class ZSCP_CHECK_VALUESLink<ObjectT extends VdmObject<?> >
    extends EntityLink<ZSCP_CHECK_VALUESLink<ObjectT> , ZSCP_CHECK_VALUES, ObjectT>
    implements ZSCP_CHECK_VALUESSelectable
{


    /**
     * Use the constants declared in each entity inner class. Instantiating directly requires knowing the underlying OData field names, so use with caution.
     * 
     * @param fieldName
     *     OData navigation field name. Must match the field returned by the underlying OData service.
     */
    public ZSCP_CHECK_VALUESLink(final String fieldName) {
        super(fieldName);
    }

    private ZSCP_CHECK_VALUESLink(final EntityLink<ZSCP_CHECK_VALUESLink<ObjectT> , ZSCP_CHECK_VALUES, ObjectT> toClone) {
        super(toClone);
    }

    @Nonnull
    @Override
    protected ZSCP_CHECK_VALUESLink<ObjectT> translateLinkType(final EntityLink<ZSCP_CHECK_VALUESLink<ObjectT> , ZSCP_CHECK_VALUES, ObjectT> link) {
        return new ZSCP_CHECK_VALUESLink<ObjectT>(link);
    }

}