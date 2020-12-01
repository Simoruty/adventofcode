package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	b := 25
	h := 6
	print(render(scanner.Text(), b, h), b, h)
}

func render(imageData string, b, h int) []byte {
	size := b * h
	image := make([]byte, size)
	for layout := 0; layout < len(imageData); layout += size {
		for i := layout; i < size+layout; i++ {
			if imageData[i] != '2' && image[i%size] == 0 {
				image[i%size] = imageData[i]
			}
		}
	}

	return image
}

func print(buffer []byte, b, h int) {
	for i := 0; i < h; i++ {
		for j := 0; j < b; j++ {
			switch buffer[i*b+j] {
			case '0':
				fmt.Print(" ")
			case '1':
				fmt.Print("█")
			}
		}
		fmt.Println()
	}
}