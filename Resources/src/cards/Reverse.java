package cards;

import process.Calc;
import process.State;
import process.Turn;

public class Reverse extends Card {
    public Reverse(String seed) {
        number = 0;
        id = seed;
        skill = State.Skill.REVERSE;
        state = "Normal";
        calced = false;
    }
    @Override
    public int GetNumber() {
        return number;
    }
    @Override
    public boolean GetCalced() {
        return calced;
    }
    @Override
    public void SkillEffect(Card now) {
        if(now.GetCalced()) {
            Calc.SetBuff(now.GetNumber());
        }
    }
    @Override
    public void UseCard() {
        Turn.pre = Turn.now;
        Turn.now = this;
        Turn.SetDirection();
        State.SetState(state);
    }
}