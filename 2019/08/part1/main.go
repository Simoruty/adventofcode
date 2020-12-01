package main

import (
"bufio"
"fmt"
"math"
"os"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	fmt.Println(count(scanner.Text(), 25, 6))
}

func count(imageData string, b, h int) int {
	countZeros, countOnes, countTwos := 0, 0, 0
	min := math.MaxInt8
	res := 0
	for i := 0; i < len(imageData); i += b * h {
		for j := i; j < b*h+i; j++ {
			switch imageData[j] {
			case '0':
				countZeros++
			case '1':
				countOnes++
			case '2':
				countTwos++
			}
		}
		if countZeros < min {
			min = countZeros
			res = countOnes * countTwos
		}
		countZeros, countOnes, countTwos = 0, 0, 0
	}

	return res
}
