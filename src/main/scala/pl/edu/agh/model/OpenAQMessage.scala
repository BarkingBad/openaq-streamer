package pl.edu.agh.model

import io.circe.generic.JsonCodec

@JsonCodec
case class OpenAQMessage(
    date: DateStruct,
    parameter: String,
    value: Double,
    unit: String,
    averagingPeriod: PeriodStruct,
    location: String,
    city: String,
    country: String,
    coordinates: Coordinates
)
