package Arrayofobjects;

import java.lang.*;

public class Candle {

    public static class Builder {

        public String dateTime;
        public Double openP;
        public Double closeP;
        public Double high;
        public Double low;
        public Double MA5;
        public Double MA10;
        public Double MA20;
        public Double MAinUse; //Change MA here to use different one
        public Double ATR14;
        public Double candleSize; //high - low
        public String candleType;

        //Constructor

        public Builder(String dateTime) {
            this.dateTime = dateTime;
        }

        //Builder methods:
        public Builder timestamp(String dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder openPrice(Double openP) {
            this.openP = openP;
            return this;
        }

        public Builder closePrice(Double closeP) {
            this.closeP = closeP;
            return this;
        }

        public Builder high(Double high) {
            this.high = high;
            return this;
        }

        public Builder low(Double low) {
            this.low = low;
            return this;
        }

        public Builder MA5(Double MA5) {
            this.MA5 = MA5;
            return this;
        }

        public Builder MA10(Double MA10) {
            this.MA10 = MA10;
            return this;
        }

        public Builder MA20(Double MA20) {
            this.MA20 = MA20;
            return this;
        }

        public Builder MAinUse(Double MAinUse) {
            this.MAinUse = MAinUse;
            return this;
        }

        public Builder ATR14(Double ATR14) {
            this.ATR14 = ATR14;
            return this;
        }

        public Builder CandleSize(Double candleSize) {
            this.candleSize = Math.abs(this.closeP - this.openP);
            return this;
        }

        public Builder CandleType(Double openP, Double closeP, Double MAinUse, Double ATR14) {
            if (closeP > openP) {  // Bull?
                if ((closeP > MAinUse) && (candleSize > ATR14)) {
                    this.candleType = "buob";
                } else if ((closeP < MAinUse) && (candleSize > ATR14)) {
                    this.candleType = "buub";
                } else if ((closeP < MAinUse) && (candleSize < ATR14)) {
                    this.candleType = "buus";
                } else if ((closeP > MAinUse) && (candleSize < ATR14)) {
                    this.candleType = "buos";
                }
            }
            if (closeP < openP) {  // Bear?
                if ((closeP > MAinUse) && (candleSize > ATR14)) {
                    this.candleType = "beob";
                } else if ((closeP < MAinUse) && (candleSize > ATR14)) {
                    this.candleType = "beub";
                } else if ((closeP < MAinUse) && (candleSize < ATR14)) {
                    this.candleType = "beus";
                } else if ((closeP > MAinUse) && (candleSize < ATR14)) {
                    this.candleType = "beos";
                }
            }
            return this;
        }


        public Candle build() {
            Candle candle = new Candle();
            candle.dateTime = this.dateTime;
            candle.openP = this.openP;
            candle.closeP = this.closeP;
            candle.high = this.high;
            candle.low = this.low;
            candle.MA5 = this.MA5;
            candle.MA10 = this.MA10;
            candle.MA20 = this.MA20;
            candle.candleType = this.candleType;
            return candle;
        }

        //Getter
        public String getCandleType() {
            return candleType;
        }

        @Override
        public String toString() {
            return "Candle: " +
                    "dateTime='" + dateTime +
                    ", openP=" + openP +
                    ", closeP=" + closeP +
                    ", high=" + high +
                    ", low=" + low +
                    ", MA5=" + MA5 +
                    ", MA10=" + MA10 +
                    ", MA20=" + MA20 +
                    ", MAinUse=" + MAinUse +
                    ", ATR14=" + ATR14 +
                    ", candleSize=" + candleSize +
                    '}';
        }


    }

    public Candle(){

    }

}






