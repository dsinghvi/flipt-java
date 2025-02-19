package com.flipt.api.client.rules.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = RuleCreateRequest.Builder.class
)
public final class RuleCreateRequest {
  private final String segmentKey;

  private final int rank;

  private int _cachedHashCode;

  RuleCreateRequest(String segmentKey, int rank) {
    this.segmentKey = segmentKey;
    this.rank = rank;
  }

  @JsonProperty("segmentKey")
  public String getSegmentKey() {
    return segmentKey;
  }

  @JsonProperty("rank")
  public int getRank() {
    return rank;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof RuleCreateRequest && equalTo((RuleCreateRequest) other);
  }

  private boolean equalTo(RuleCreateRequest other) {
    return segmentKey.equals(other.segmentKey) && rank == other.rank;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.segmentKey, this.rank);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "RuleCreateRequest{" + "segmentKey: " + segmentKey + ", rank: " + rank + "}";
  }

  public static SegmentKeyStage builder() {
    return new Builder();
  }

  public interface SegmentKeyStage {
    RankStage segmentKey(String segmentKey);

    Builder from(RuleCreateRequest other);
  }

  public interface RankStage {
    _FinalStage rank(int rank);
  }

  public interface _FinalStage {
    RuleCreateRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements SegmentKeyStage, RankStage, _FinalStage {
    private String segmentKey;

    private int rank;

    private Builder() {
    }

    @Override
    public Builder from(RuleCreateRequest other) {
      segmentKey(other.getSegmentKey());
      rank(other.getRank());
      return this;
    }

    @Override
    @JsonSetter("segmentKey")
    public RankStage segmentKey(String segmentKey) {
      this.segmentKey = segmentKey;
      return this;
    }

    @Override
    @JsonSetter("rank")
    public _FinalStage rank(int rank) {
      this.rank = rank;
      return this;
    }

    @Override
    public RuleCreateRequest build() {
      return new RuleCreateRequest(segmentKey, rank);
    }
  }
}
