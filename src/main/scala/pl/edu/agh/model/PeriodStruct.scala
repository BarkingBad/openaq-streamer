package pl.edu.agh.model

import io.circe.generic.JsonCodec

@JsonCodec
case class PeriodStruct(value: Int, unit: String)
