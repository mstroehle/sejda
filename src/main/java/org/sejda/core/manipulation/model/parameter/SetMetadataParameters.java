/*
 * Created on 09/lug/2010
 * Copyright (C) 2010 by Andrea Vacondio (andrea.vacondio@gmail.com).
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.sejda.core.manipulation.model.parameter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.sejda.core.manipulation.model.input.PdfSource;
import org.sejda.core.manipulation.model.pdf.PdfMetadataKey;
import org.sejda.core.validation.constraint.NotEmpty;

/**
 * Parameter class for the set metadata manipulation
 * 
 * @author Andrea Vacondio
 * 
 */
public final class SetMetadataParameters extends AbstractParameters {

    private static final long serialVersionUID = -9113822216737314063L;

    @Valid
    @NotNull
    private PdfSource inputSource;

    @NotEmpty
    private Map<PdfMetadataKey, String> metadata;

    public SetMetadataParameters() {
        metadata = new HashMap<PdfMetadataKey, String>();
    }

    public PdfSource getInputSource() {
        return inputSource;
    }

    public void setInputSource(PdfSource inputSource) {
        this.inputSource = inputSource;
    }

    /**
     * @see Map#entrySet()
     * @return
     */
    public Set<Entry<PdfMetadataKey, String>> entrySet() {
        return metadata.entrySet();
    }

    /**
     * @see Map#keySet()
     * @return
     */
    public Set<PdfMetadataKey> keySet() {
        return metadata.keySet();
    }

    /**
     * @see Map#putAll(Map)
     * @param m
     */
    public void putAll(Map<? extends PdfMetadataKey, ? extends String> m) {
        metadata.putAll(m);
    }

    /**
     * adds the key,value
     * 
     * @see Map#put(Object, Object)
     * @param key
     * @param metadata
     */
    public void put(PdfMetadataKey key, String metadata) {
        this.metadata.put(key, metadata);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(inputSource).append(metadata).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SetMetadataParameters)) {
            return false;
        }
        SetMetadataParameters parameter = (SetMetadataParameters) other;
        return new EqualsBuilder().appendSuper(super.equals(other)).append(inputSource, parameter.getInputSource())
                .append(metadata.entrySet(), parameter.entrySet()).isEquals();
    }
}
