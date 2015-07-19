# TestOcr
Test Ocr Library PlayGround

[![Build Status](https://travis-ci.org/lcappuccio/TestOcr.svg?branch=master)](https://travis-ci.org/lcappuccio/TestOcr)

## Requirements
* install libtesseract on your system

  ```ubuntu: sudo apt-get install tesseract-ocr```

* for other platforms check the [Google Code Readme](https://code.google.com/p/tesseract-ocr/wiki/ReadMe#Installation)

**NOTE**

This project depends on Tess4J 2.0 and requires Tesseract 3.0.3 to be installed on the system and this Tesseract
version depends on Leptonica 1.70 available only on Ubuntu >= 14.04, for this reason tests are skipped in Travis script.

For further info see: https://code.google.com/p/tesseract-ocr/wiki/Compiling

## Usage
This project is intended to be run as a testbed code through unit tests and the IDE environment needs to be set with
the following variables:
* TESSDATA_PREFIX (optional): the variable needs to be set with the **tessdata** folder that contains the training data
* LC_NUMERIC: sets the default locale for numeric values to the platform default, usually "C", with quotes