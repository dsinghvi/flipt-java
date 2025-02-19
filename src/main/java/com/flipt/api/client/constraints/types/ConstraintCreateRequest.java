package com.flipt.api.client.constraints.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = ConstraintCreateRequest.Builder.class
)
public final class ConstraintCreateRequest {
  private final ConstraintComparisonType type;

  private final String property;

  private final String operator;

  private final Optional<String> value;

  private int _cachedHashCode;

  ConstraintCreateRequest(ConstraintComparisonType type, String property, String operator,
      Optional<String> value) {
    this.type = type;
    this.property = property;
    this.operator = operator;
    this.value = value;
  }

  @JsonProperty("type")
  public ConstraintComparisonType getType() {
    return type;
  }

  @JsonProperty("property")
  public String getProperty() {
    return property;
  }

  @JsonProperty("operator")
  public String getOperator() {
    return operator;
  }

  @JsonProperty("value")
  public Optional<String> getValue() {
    return value;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ConstraintCreateRequest && equalTo((ConstraintCreateRequest) other);
  }

  private boolean equalTo(ConstraintCreateRequest other) {
    return type.equals(other.type) && property.equals(other.property) && operator.equals(other.operator) && value.equals(other.value);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.type, this.property, this.operator, this.value);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ConstraintCreateRequest{" + "type: " + type + ", property: " + property + ", operator: " + operator + ", value: " + value + "}";
  }

  public static TypeStage builder() {
    return new Builder();
  }

  public interface TypeStage {
    PropertyStage type(ConstraintComparisonType type);

    Builder from(ConstraintCreateRequest other);
  }

  public interface PropertyStage {
    OperatorStage property(String property);
  }

  public interface OperatorStage {
    _FinalStage operator(String operator);
  }

  public interface _FinalStage {
    ConstraintCreateRequest build();

    _FinalStage value(Optional<String> value);

    _FinalStage value(String value);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements TypeStage, PropertyStage, OperatorStage, _FinalStage {
    private ConstraintComparisonType type;

    private String property;

    private String operator;

    private Optional<String> value = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(ConstraintCreateRequest other) {
      type(other.getType());
      property(other.getProperty());
      operator(other.getOperator());
      value(other.getValue());
      return this;
    }

    @Override
    @JsonSetter("type")
    public PropertyStage type(ConstraintComparisonType type) {
      this.type = type;
      return this;
    }

    @Override
    @JsonSetter("property")
    public OperatorStage property(String property) {
      this.property = property;
      return this;
    }

    @Override
    @JsonSetter("operator")
    public _FinalStage operator(String operator) {
      this.operator = operator;
      return this;
    }

    @Override
    public _FinalStage value(String value) {
      this.value = Optional.of(value);
      return this;
    }

    @Override
    @JsonSetter(
        value = "value",
        nulls = Nulls.SKIP
    )
    public _FinalStage value(Optional<String> value) {
      this.value = value;
      return this;
    }

    @Override
    public ConstraintCreateRequest build() {
      return new ConstraintCreateRequest(type, property, operator, value);
    }
  }
}
