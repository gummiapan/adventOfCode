/**
 * Created by Gustav on 2016-12-06.
 */
public class NumpadOne {

    public advent2.Number numPad(Character direction, advent2.Number activeNumber){

        switch (direction) {
            case 'U':
                if(activeNumber.equals(advent2.Number.FOUR))
                    activeNumber = advent2.Number.ONE;
                else if(activeNumber.equals(advent2.Number.FIVE))
                    activeNumber = advent2.Number.TWO;
                else if(activeNumber.equals(advent2.Number.SIX))
                    activeNumber = advent2.Number.THREE;
                else if(activeNumber.equals(advent2.Number.SEVEN))
                    activeNumber = advent2.Number.FOUR;
                else if(activeNumber.equals(advent2.Number.EIGHT))
                    activeNumber = advent2.Number.FIVE;
                else if(activeNumber.equals(advent2.Number.NINE))
                    activeNumber = advent2.Number.SIX;
                break;

            case 'D':
                if(activeNumber.equals(advent2.Number.ONE))
                    activeNumber = advent2.Number.FOUR;
                else if(activeNumber.equals(advent2.Number.TWO))
                    activeNumber = advent2.Number.FIVE;
                else if(activeNumber.equals(advent2.Number.THREE))
                    activeNumber = advent2.Number.SIX;
                else if(activeNumber.equals(advent2.Number.FOUR))
                    activeNumber = advent2.Number.SEVEN;
                else if(activeNumber.equals(advent2.Number.FIVE))
                    activeNumber = advent2.Number.EIGHT;
                else if(activeNumber.equals(advent2.Number.SIX))
                    activeNumber = advent2.Number.NINE;
                break;

            case 'R':
                if(activeNumber.equals(advent2.Number.ONE))
                    activeNumber = advent2.Number.TWO;
                else if(activeNumber.equals(advent2.Number.TWO))
                    activeNumber = advent2.Number.THREE;
                else if(activeNumber.equals(advent2.Number.FOUR))
                    activeNumber = advent2.Number.FIVE;
                else if(activeNumber.equals(advent2.Number.FIVE))
                    activeNumber = advent2.Number.SIX;
                else if(activeNumber.equals(advent2.Number.SEVEN))
                    activeNumber = advent2.Number.EIGHT;
                else if(activeNumber.equals(advent2.Number.EIGHT))
                    activeNumber = advent2.Number.NINE;
                break;

            case 'L':
                if(activeNumber.equals(advent2.Number.TWO))
                    activeNumber = advent2.Number.ONE;
                else if(activeNumber.equals(advent2.Number.THREE))
                    activeNumber = advent2.Number.TWO;
                else if(activeNumber.equals(advent2.Number.FIVE))
                    activeNumber = advent2.Number.FOUR;
                else if(activeNumber.equals(advent2.Number.SIX))
                    activeNumber = advent2.Number.FIVE;
                else if(activeNumber.equals(advent2.Number.EIGHT))
                    activeNumber = advent2.Number.SEVEN;
                else if(activeNumber.equals(advent2.Number.NINE))
                    activeNumber = advent2.Number.EIGHT;
                break;
                
        }
        return activeNumber;
    }
}
