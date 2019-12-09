#!/usr/bin/env bash

COOKIE_TOKEN="$1"
YEAR="$2"
DAY="$3"

#create dir
mkdir -p "$YEAR/0$DAY"

# download input files
http "https://adventofcode.com/$YEAR/day/$DAY/input" "Cookie:session=$COOKIE_TOKEN;" >"$YEAR/0$DAY/input"

# download assignment
http "https://adventofcode.com/$YEAR/day/$DAY" "Cookie:session=$COOKIE_TOKEN;" | pup 'article.day-desc' >"$YEAR/0$DAY/tmp.html"
lynx -dump "$YEAR/0$DAY/tmp.html" -width 80 >"$YEAR/0$DAY/assignment"
rm -f "$YEAR/0$DAY/tmp.html"
