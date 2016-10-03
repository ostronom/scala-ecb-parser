package com.ostronom.ecb


sealed trait Currency
object Currency {
  case object AUD extends Currency // Australian Dollar (A$)
  case object BGN extends Currency // Bulgarian Lev (BGN)
  case object BRL extends Currency // Brazilian Real (R$)
  case object CAD extends Currency // Canadian Dollar (CA$)
  case object CHF extends Currency // Swiss Franc (CHF)
  case object CNY extends Currency // Chinese Yuan (CN¥)
  case object CZK extends Currency // Czech Republic Koruna (CZK)
  case object DKK extends Currency // Danish Krone (DKK)
  case object EUR extends Currency // Euro (€)
  case object GBP extends Currency // British Pound Sterling (£)
  case object HKD extends Currency // Hong Kong Dollar (HK$)
  case object HRK extends Currency // Croatian Kuna (HRK)
  case object HUF extends Currency // Hungarian Forint (HUF)
  case object IDR extends Currency // Indonesian Rupiah (IDR)
  case object ILS extends Currency // Israeli New Sheqel (₪)
  case object INR extends Currency // Indian Rupee (Rs.)
  case object JPY extends Currency // Japanese Yen (¥)
  case object KRW extends Currency // South Korean Won (₩)
  case object LTL extends Currency // Lithuanian Litas (LTL)
  case object MXN extends Currency // Mexican Peso (MX$)
  case object MYR extends Currency // Malaysian Ringgit (MYR)
  case object NOK extends Currency // Norwegian Krone (NOK)
  case object NZD extends Currency // New Zealand Dollar (NZ$)
  case object PHP extends Currency // Philippine Peso (Php)
  case object PLN extends Currency // Polish Zloty (PLN)
  case object RON extends Currency // Romanian Leu (RON)
  case object RUB extends Currency // Russian Ruble (RUB)
  case object SEK extends Currency // Swedish Krona (SEK)
  case object SGD extends Currency // Singapore Dollar (SGD)
  case object THB extends Currency // Thai Baht (฿)
  case object TRY extends Currency // Turkish Lira (TRY)
  case object USD extends Currency // US Dollar ($)
  case object ZAR extends Currency // South African Rand (ZAR)

  def fromString(s: String): Currency = s.toUpperCase match {
    case "AUD" => AUD
    case "BGN" => BGN
    case "BRL" => BRL
    case "CAD" => CAD
    case "CHF" => CHF
    case "CNY" => CNY
    case "CZK" => CZK
    case "DKK" => DKK
    case "EUR" => EUR
    case "GBP" => GBP
    case "HKD" => HKD
    case "HRK" => HRK
    case "HUF" => HUF
    case "IDR" => IDR
    case "ILS" => ILS
    case "INR" => INR
    case "JPY" => JPY
    case "KRW" => KRW
    case "LTL" => LTL
    case "MXN" => MXN
    case "MYR" => MYR
    case "NOK" => NOK
    case "NZD" => NZD
    case "PHP" => PHP
    case "PLN" => PLN
    case "RON" => RON
    case "RUB" => RUB
    case "SEK" => SEK
    case "SGD" => SGD
    case "THB" => THB
    case "TRY" => TRY
    case "USD" => USD
    case "ZAR" => ZAR
  }
}
