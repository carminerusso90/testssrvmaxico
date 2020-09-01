/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

/*
 * Generated by OData VDM code generator of SAP Cloud SDK in version 2.19.0
 */

package vdm.namespaces.zscpmaxiconguagliosrv01;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.sap.cloud.sdk.s4hana.connectivity.ErpConfigContext;
import com.sap.cloud.sdk.s4hana.datamodel.odata.adapter.ODataField;
import com.sap.cloud.sdk.s4hana.datamodel.odata.annotation.Key;
import com.sap.cloud.sdk.s4hana.datamodel.odata.helper.VdmEntity;
import com.sap.cloud.sdk.typeconverter.TypeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vdm.namespaces.zscpmaxiconguagliosrv01.field.ZSCP_CHECK_VALUES_PODField;
import vdm.namespaces.zscpmaxiconguagliosrv01.selectable.ZSCP_CHECK_VALUES_PODSelectable;
import vdm.services.ZSCPMAXICONGUAGLIOSRV01Service;


/**
 * <p>Original entity name from the Odata EDM: <b>ZSCP_CHECK_VALUES_POD</b></p>
 * 
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true, callSuper = true)
@EqualsAndHashCode(doNotUseGetters = true, callSuper = true)
@JsonAdapter(com.sap.cloud.sdk.s4hana.datamodel.odata.adapter.ODataVdmEntityAdapterFactory.class)
public class ZSCP_CHECK_VALUES_POD
    extends VdmEntity<ZSCP_CHECK_VALUES_POD>
{

    /**
     * Selector for all available fields of ZSCP_CHECK_VALUES_POD.
     * 
     */
    public final static ZSCP_CHECK_VALUES_PODSelectable ALL_FIELDS = new ZSCP_CHECK_VALUES_PODSelectable() {


        @Nonnull
        @Override
        public String getFieldName() {
            return "*";
        }

        @Nonnull
        @Override
        public List<String> getSelections() {
            return Collections.singletonList("*");
        }

    }
    ;
    /**
     * (Key Field) Constraints: Not nullable, Maximum length: 50 <p>Original property name from the Odata EDM: <b>Pod</b></p>
     * 
     * @return
     *     Def.punto cont.
     */
    @Key
    @SerializedName("Pod")
    @JsonProperty("Pod")
    @Nullable
    @ODataField(odataName = "Pod")
    private String pod;
    /**
     * Use with available fluent helpers to apply the <b>Pod</b> field to query operations.
     * 
     */
    public final static ZSCP_CHECK_VALUES_PODField<String> POD = new ZSCP_CHECK_VALUES_PODField<String>("Pod");
    /**
     * Constraints: Not nullable, Maximum length: 1 <p>Original property name from the Odata EDM: <b>Status</b></p>
     * 
     * @return
     *     Esito Check
     */
    @SerializedName("Status")
    @JsonProperty("Status")
    @Nullable
    @ODataField(odataName = "Status")
    private String status;
    /**
     * Use with available fluent helpers to apply the <b>Status</b> field to query operations.
     * 
     */
    public final static ZSCP_CHECK_VALUES_PODField<String> STATUS = new ZSCP_CHECK_VALUES_PODField<String>("Status");
    /**
     * Constraints: Not nullable, Maximum length: 255 <p>Original property name from the Odata EDM: <b>Descrizione</b></p>
     * 
     * @return
     *     Descrizione Esito
     */
    @SerializedName("Descrizione")
    @JsonProperty("Descrizione")
    @Nullable
    @ODataField(odataName = "Descrizione")
    private String descrizione;
    /**
     * Use with available fluent helpers to apply the <b>Descrizione</b> field to query operations.
     * 
     */
    public final static ZSCP_CHECK_VALUES_PODField<String> DESCRIZIONE = new ZSCP_CHECK_VALUES_PODField<String>("Descrizione");

    /**
     * {@inheritDoc}
     * 
     */
    @Nonnull
    @Override
    public Class<ZSCP_CHECK_VALUES_POD> getType() {
        return ZSCP_CHECK_VALUES_POD.class;
    }

    /**
     * (Key Field) Constraints: Not nullable, Maximum length: 50 <p>Original property name from the Odata EDM: <b>Pod</b></p>
     * 
     * @param pod
     *     Def.punto cont.
     */
    public void setPod(
        @Nullable
        final String pod) {
        rememberChangedField("Pod", this.pod);
        this.pod = pod;
    }

    /**
     * Constraints: Not nullable, Maximum length: 1 <p>Original property name from the Odata EDM: <b>Status</b></p>
     * 
     * @param status
     *     Esito Check
     */
    public void setStatus(
        @Nullable
        final String status) {
        rememberChangedField("Status", this.status);
        this.status = status;
    }

    /**
     * Constraints: Not nullable, Maximum length: 255 <p>Original property name from the Odata EDM: <b>Descrizione</b></p>
     * 
     * @param descrizione
     *     Descrizione Esito
     */
    public void setDescrizione(
        @Nullable
        final String descrizione) {
        rememberChangedField("Descrizione", this.descrizione);
        this.descrizione = descrizione;
    }

    @Override
    protected String getEntityCollection() {
        return "ZSCP_CHECK_VALUES_PODSet";
    }

    @Nonnull
    @Override
    protected Map<String, Object> getKey() {
        final Map<String, Object> result = Maps.newHashMap();
        result.put("Pod", getPod());
        return result;
    }

    @Nonnull
    @Override
    protected Map<String, Object> toMapOfFields() {
        final Map<String, Object> values = super.toMapOfFields();
        values.put("Pod", getPod());
        values.put("Status", getStatus());
        values.put("Descrizione", getDescrizione());
        return values;
    }

    @Override
    protected void fromMap(final Map<String, Object> inputValues) {
        final Map<String, Object> values = Maps.newHashMap(inputValues);
        // simple properties
        {
            if (values.containsKey("Pod")) {
                final Object value = values.remove("Pod");
                if ((value == null)||(!value.equals(getPod()))) {
                    setPod(((String) value));
                }
            }
            if (values.containsKey("Status")) {
                final Object value = values.remove("Status");
                if ((value == null)||(!value.equals(getStatus()))) {
                    setStatus(((String) value));
                }
            }
            if (values.containsKey("Descrizione")) {
                final Object value = values.remove("Descrizione");
                if ((value == null)||(!value.equals(getDescrizione()))) {
                    setDescrizione(((String) value));
                }
            }
        }
        // structured properties
        {
        }
        // navigation properties
        {
        }
        super.fromMap(values);
    }

    /**
     * Use with available fluent helpers to apply an extension field to query operations.
     * 
     * @param fieldName
     *     The name of the extension field as returned by the OData service.
     * @param <T>
     *     The type of the extension field when performing value comparisons.
     * @param fieldType
     *     The Java type to use for the extension field when performing value comparisons.
     * @return
     *     A representation of an extension field from this entity.
     */
    @Nonnull
    public static<T >ZSCP_CHECK_VALUES_PODField<T> field(
        @Nonnull
        final String fieldName,
        @Nonnull
        final Class<T> fieldType) {
        return new ZSCP_CHECK_VALUES_PODField<T>(fieldName);
    }

    /**
     * Use with available fluent helpers to apply an extension field to query operations.
     * 
     * @param typeConverter
     *     A TypeConverter<T, DomainT> instance whose first generic type matches the Java type of the field
     * @param fieldName
     *     The name of the extension field as returned by the OData service.
     * @param <T>
     *     The type of the extension field when performing value comparisons.
     * @param <DomainT>
     *     The type of the extension field as returned by the OData service.
     * @return
     *     A representation of an extension field from this entity, holding a reference to the given TypeConverter.
     */
    @Nonnull
    public static<T,DomainT >ZSCP_CHECK_VALUES_PODField<T> field(
        @Nonnull
        final String fieldName,
        @Nonnull
        final TypeConverter<T, DomainT> typeConverter) {
        return new ZSCP_CHECK_VALUES_PODField<T>(fieldName, typeConverter);
    }

    @Override
    @Nullable
    public ErpConfigContext getErpConfigContext() {
        return super.getErpConfigContext();
    }

    /**
     * 
     * @deprecated
     *     Use {@link #attachToService(String, ErpConfigContext)} instead.
     */
    @Override
    @Deprecated
    public void setErpConfigContext(
        @Nullable
        final ErpConfigContext erpConfigContext) {
        super.setErpConfigContext(erpConfigContext);
    }

    @Override
    protected void setServicePathForFetch(
        @Nullable
        final String servicePathForFetch) {
        super.setServicePathForFetch(servicePathForFetch);
    }

    @Override
    public void attachToService(
        @Nullable
        final String servicePath,
        @Nullable
        final ErpConfigContext configContext) {
        super.attachToService(servicePath, configContext);
    }

    @Override
    protected String getDefaultServicePath() {
        return ZSCPMAXICONGUAGLIOSRV01Service.DEFAULT_SERVICE_PATH;
    }

}
