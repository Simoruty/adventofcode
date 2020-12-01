1:
	go run part1/main.go <input

2:
	go run part2/main.go <input | \
	   convert -size 900x280 xc:white -font "Apple Braille" -pointsize 24 \
		 -fill black -annotate +20+30 "@-" -blur 0x6 -sharpen 0x1.0 \
		 -units PixelsPerInch -density 72 png:- | \
	   tesseract stdin stdout 2>/dev/null \
		grep . | tr -cd "A-Z\n"

3:
	go run part2/main.go <input
