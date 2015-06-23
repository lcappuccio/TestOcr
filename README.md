# TestOcr
Test Ocr Library PlayGround

## Requirements
* install libtesseract on your system

  ```ubuntu: sudo apt-get install tesseract-ocr```

* for other platforms check the [Google Code Readme](https://code.google.com/p/tesseract-ocr/wiki/ReadMe#Installation)

## Usage
This project is intended to be run as a testbed code through unit tests and the IDE environment needs to be set with
the following variables:
* TESSDATA_PREFIX (optional): the variable needs to be set with the **tessdata** folder that contains the training data
* LC_NUMERIC: sets the default locale for numeric values to the platform default, usually "C", with quotes