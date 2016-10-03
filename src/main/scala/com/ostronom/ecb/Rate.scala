package com.ostronom.ecb

import java.time.LocalDate


final case class Rate(currency: Currency, rate: BigDecimal)
final case class DayRates(time: LocalDate, rates: Vector[Rate])
