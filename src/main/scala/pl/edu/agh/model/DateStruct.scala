package pl.edu.agh.model

import io.circe.generic.JsonCodec

@JsonCodec
case class DateStruct(utc: String, local: String)
