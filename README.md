# Scacure (Scala + Precure) 

All about Japanese battle heroine "Pretty Cure (Precure)".

Inspired by [Acme::PrettyCure](http://perl-users.jp/articles/advent-calendar/2010/acme/6) and [pycure](https://github.com/drillbits/pycure) and [rubicure](https://github.com/sue445/rubicure).

## Usage

run sbt console

```
$ sbt console
```

Get the all title of the series.

```scala
Precure.foreach(series => series.title >>> println)
```

Get the all name of girls.

```scala
Girls.foreach(girl => girl.name >>> println)
```

Get the now on air series.

```scala
Precure.now
```

Get the series by identifier.

```scala
Precure("MaxHeart")
```

