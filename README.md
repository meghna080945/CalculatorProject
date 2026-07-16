# AI Calculator
GUI calculator built with an open-source LLM (Qwen3.5:9b) at $0.00 cost 

Total cost:            $0.0000
Total duration (API):  34m 40s
Total duration (wall): 50m 26m 43s
Total code changes:    211 lines added, 1 lines removed
Usage by model:
  qwen3.5:9b:cloud:  694.4k input, 7.0k output, 0 cache read, 0 cache write ($0.00)

  Features Implemented

  - Basic Operations: Addition (+), Subtraction (-), Multiplication (*), Division (/)
  - Number Buttons: 0-9 with proper calculator layout
  - Special Functions:
    - Decimal point (.)
    - Equals (=)
    - Clear (Clr)
    - Delete (Del)
    - Negative/Positive toggle ((-))
  - Display: Large, readable text field that shows input and results
  - Error Handling: Prevents division by zero

  How to Use

  1. The calculator opens in a centered window (420x550 pixels)
  2. Click number buttons to enter values
  3. Use operation buttons (+, -, *, /) to set the operation
  4. Click "=" to see the result
  5. Use "Clr" to clear the display
  6. Use "Del" to delete the last character
  7. Use "(-)" to toggle between positive and negative

  Technical Details

  - Built with Java Swing for the GUI
  - Implements ActionListener for button handling
  - Proper layout with setBounds for positioning
  - Error handling for division by zero
  - Clean, readable code with comments

  To Run the Calculator

  1. Navigate to the CalculatorProject directory: cd ~/CalculatorProject
  2. Compile: javac Calculator.java
  3. Run: java Calculator
