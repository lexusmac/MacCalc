package com.company;

public class CalcOOP {
        private double firstNumber;
        private double secondNumber;
        private double memory;
        private int operation = 0; // 0-addition, 1-minus, 2-multiply, 3-division, 4-sqrt
        private double result;
        private double n=0;

        final int maxOperationNumber = 4;

        public String getErrorDescription(int n)
        {
            String []errors= {"No error", "Division by zero", "SQRT of negative number"};

            return errors[n];
        }

        public boolean checkNumber(String number)
        {
            boolean error = false;
            number.replaceAll(".", ","); //меняем точки на запятые
            try {
                n = Double.parseDouble(number);
            } catch (NumberFormatException e) {
                error = true;
            }

            return error;
        }

        public void setFirstNumber(String number) {
            checkNumber(number);
            this.firstNumber = n;
        }
        public double getFirstNumber()	{
            return this.firstNumber;
        }
        public double getSecondNumber() {
            return secondNumber;
        }
        public void setSecondNumber(String number) {
            checkNumber(number);
            this.secondNumber = n;
        }
        public double getMemory() {
            return memory;
        }
        public void setMemory(double memory) {
            this.memory = memory;
        }
        public int getOperation() {
            return operation;
        }
        public void setOperation(int operation) {
            if (operation > maxOperationNumber)
                this.operation = 0;
            else
                this.operation = operation;
        }


        public double getResult() {
            return result;
        }
        public void setResult(double result) {
            this.result = result;
        }
        public int sum()
        {
            this.setResult(this.firstNumber + this.secondNumber);
            return 0;
        }
        public int minus()
        {
            this.setResult(this.firstNumber - this.secondNumber);
            return 0;
        }
        public int multiply()
        {
            this.setResult(this.firstNumber * this.secondNumber);
            return 0;
        }
        public int division()
        {
            if (this.secondNumber != 0)
            {
                this.setResult(this.firstNumber / this.secondNumber);
                return 0;
            }
            else
                return 1;
        }
        public int sqrt()
        {
            if (this.firstNumber >= 0)
            {
                this.setResult(Math.sqrt(this.firstNumber));
                return 0;
            }
            else
                return 2;
        }

    }
