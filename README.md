Scala ECB currency exchange rates parser
========================================

This library allows you to retrieve ECB provided data for exchange rates
 of different currencies compared to Euro.
 
The API is very simple.

- `com.ostronom.ecb.Parser.loadLatest()(implicit client: HttpClient, ec: ExecutionContext): Future[Option[DayRates]]`

returns latest exchange rates 

- `com.ostronom.ecb.Parser.loadLast90Days()(implicit client: HttpClient, ec: ExecutionContext): Future[Seq[Option[DayRates]]]`

returns exchange rates history for last 90 days.

You should provide implicit HttpClient which is a simple object with `get(url: String): Future[String]` method.

Usage examples could be found in tests. 

That's it.

License
=======

[WTFPL](http://www.wtfpl.net/)