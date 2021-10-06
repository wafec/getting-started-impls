package main

import "fmt"
import t "time"

func main() {
	const intConstant = 100
	const strConstant = "test"
	var intVar int32
	var intVarInitialized = 10

	inferredIntType := 9

	// This is a comment
	fmt.Printf("hello, world\n")
	fmt.Println(t.Now())
	/* 
	This is a multiline comment
	*/

	// Go does not allow declaring a variable without using it
	fmt.Println(intConstant, strConstant, intVar, intVarInitialized, inferredIntType)
}