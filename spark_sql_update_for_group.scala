val df = Seq(
  (1, "fn", "red"),
  (2, "fn", "blue"),
  (3, "fn", "green"),
  (4, "aa", "blue"),
  (5, "aa", "green"),
  (6, "bb", "red"),
  (7, "bb", "red"),
  (8, "aa", "blue")
).toDF("id", "fn", "color")
val redOrNot = df.groupBy("fn")
  .agg(collect_set('color) as "values")
  .withColumn("hasRed", array_contains('values, "red"))

// gives null for no option
val colorPicker = when('hasRed, "red")
val result = df.join(redOrNot, "fn")
  .withColumn("resultColor", colorPicker) 
  .withColumn("color", coalesce('resultColor, 'color)) // skips nulls that leads to the answer
  .select('id, 'fn, 'color)
