package org.web3j.protocol.core.methods.response;

import org.web3j.protocol.core.Response;

/**
 * eth_call.
 */
public class EthCall extends Response<String> {

    // Numeric.toHexString(Hash.sha3("Error(string)".getBytes())).substring(0, 10)
    private static final String errorMethodId = "0x08c379a0";

    public String getValue() {
        return (String)this.getResult();
    }

    public boolean isReverted() {
        return this.hasError() || this.isErrorInResult();
    }

    private boolean isErrorInResult() {
        return this.getValue() != null && this.getValue().startsWith("0x08c379a0");
    }
}
