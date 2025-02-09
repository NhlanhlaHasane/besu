/*
 * Copyright Hyperledger Besu Contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.ethereum.api.jsonrpc.internal.results;

import org.hyperledger.besu.datatypes.Hash;
import org.hyperledger.besu.ethereum.api.jsonrpc.internal.methods.ExecutionEngineJsonRpcMethod.ExecutionStatus;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "latestValidHash", "validationError"})
public class EngineExecutionResult {
  ExecutionStatus status;
  Optional<Hash> latestValidHash;
  Optional<String> validationError;

  public EngineExecutionResult(
      final ExecutionStatus status, final Hash latestValidHash, final String validationError) {
    this.status = status;
    this.latestValidHash = Optional.ofNullable(latestValidHash);
    this.validationError = Optional.ofNullable(validationError);
  }

  @JsonGetter(value = "status")
  public String getStatus() {
    return status.name();
  }

  @JsonGetter(value = "latestValidHash")
  public String getLatestValidHash() {
    return latestValidHash.map(Hash::toHexString).orElse(null);
  }

  @JsonGetter(value = "validationError")
  public String getValidationError() {
    return validationError.orElse(null);
  }
}
