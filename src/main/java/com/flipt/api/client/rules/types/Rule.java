package com.flipt.api.client.rules.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.client.distributions.types.Distribution;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = Rule.Builder.class
)
public final class Rule {
  private final String id;

  private final String flagKey;

  private final String segmentKey;

  private final List<Distribution> distributions;

  private final int rank;

  private final String createdAt;

  private final String updatedAt;

  private int _cachedHashCode;

  Rule(String id, String flagKey, String segmentKey, List<Distribution> distributions, int rank,
      String createdAt, String updatedAt) {
    this.id = id;
    this.flagKey = flagKey;
    this.segmentKey = segmentKey;
    this.distributions = distributions;
    this.rank = rank;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("flagKey")
  public String getFlagKey() {
    return flagKey;
  }

  @JsonProperty("segmentKey")
  public String getSegmentKey() {
    return segmentKey;
  }

  @JsonProperty("distributions")
  public List<Distribution> getDistributions() {
    return distributions;
  }

  @JsonProperty("rank")
  public int getRank() {
    return rank;
  }

  @JsonProperty("createdAt")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("updatedAt")
  public String getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Rule && equalTo((Rule) other);
  }

  private boolean equalTo(Rule other) {
    return id.equals(other.id) && flagKey.equals(other.flagKey) && segmentKey.equals(other.segmentKey) && distributions.equals(other.distributions) && rank == other.rank && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.flagKey, this.segmentKey, this.distributions, this.rank, this.createdAt, this.updatedAt);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Rule{" + "id: " + id + ", flagKey: " + flagKey + ", segmentKey: " + segmentKey + ", distributions: " + distributions + ", rank: " + rank + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    FlagKeyStage id(String id);

    Builder from(Rule other);
  }

  public interface FlagKeyStage {
    SegmentKeyStage flagKey(String flagKey);
  }

  public interface SegmentKeyStage {
    RankStage segmentKey(String segmentKey);
  }

  public interface RankStage {
    CreatedAtStage rank(int rank);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    _FinalStage updatedAt(String updatedAt);
  }

  public interface _FinalStage {
    Rule build();

    _FinalStage distributions(List<Distribution> distributions);

    _FinalStage distributions(Distribution distributions);

    _FinalStage addAllDistributions(List<Distribution> distributions);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements IdStage, FlagKeyStage, SegmentKeyStage, RankStage, CreatedAtStage, UpdatedAtStage, _FinalStage {
    private String id;

    private String flagKey;

    private String segmentKey;

    private int rank;

    private String createdAt;

    private String updatedAt;

    private List<Distribution> distributions = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(Rule other) {
      id(other.getId());
      flagKey(other.getFlagKey());
      segmentKey(other.getSegmentKey());
      distributions(other.getDistributions());
      rank(other.getRank());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      return this;
    }

    @Override
    @JsonSetter("id")
    public FlagKeyStage id(String id) {
      this.id = id;
      return this;
    }

    @Override
    @JsonSetter("flagKey")
    public SegmentKeyStage flagKey(String flagKey) {
      this.flagKey = flagKey;
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
    public CreatedAtStage rank(int rank) {
      this.rank = rank;
      return this;
    }

    @Override
    @JsonSetter("createdAt")
    public UpdatedAtStage createdAt(String createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    @Override
    @JsonSetter("updatedAt")
    public _FinalStage updatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    public _FinalStage addAllDistributions(List<Distribution> distributions) {
      this.distributions.addAll(distributions);
      return this;
    }

    @Override
    public _FinalStage distributions(Distribution distributions) {
      this.distributions.add(distributions);
      return this;
    }

    @Override
    @JsonSetter(
        value = "distributions",
        nulls = Nulls.SKIP
    )
    public _FinalStage distributions(List<Distribution> distributions) {
      this.distributions.clear();
      this.distributions.addAll(distributions);
      return this;
    }

    @Override
    public Rule build() {
      return new Rule(id, flagKey, segmentKey, distributions, rank, createdAt, updatedAt);
    }
  }
}
